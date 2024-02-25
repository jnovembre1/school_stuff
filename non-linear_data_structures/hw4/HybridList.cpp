#include <iostream>
#include <string>
#include <stdexcept>
#include "HybridList.h"
using namespace std;

HybridList::HybridList() {}

HybridList::HybridList(int blockSize) {
	if (blockSize <= 0)
		throw out_of_range("Invalid block size " + to_string(blockSize));
	this->blockSize = blockSize;
}

HybridList::HybridList(const HybridList& h) {
	operator = (h);

}

HybridList::~HybridList() {
	clear();
}


int HybridList::size() const {
	return numElements;
}

int HybridList::capacity() const {
	return numBlocks * blockSize;
}

int HybridList::block_size() const {
	return blockSize;
}

HybridListNode* HybridList::front() const {
	return head;
}

HybridListNode* HybridList::back() const {
	return tail;
}

double& HybridList::at(int index) const {
	HybridListNode* curNode = head;
	int elementsSearched = 0;

	if (index < 0 || index >= numElements)
		throw out_of_range("Invalid index " + to_string(index));

	// Iterate through all blocks to identify block containing the index
	while (curNode != nullptr) {
		if (index < elementsSearched + curNode->size()) {
			// Element is in this block so just return the correct element from
			// this block
			return curNode->at(index - elementsSearched);
		}
		// Element is not in this block so add the number of elements in the
		// block to the number of elements searched
		elementsSearched += curNode->size();
		curNode = curNode->next;
	}

	// Iterator went beyond last block so something went horribly wrong
	abort();
}

HybridList& HybridList::operator= (const HybridList& h) {
	if (this != &h) {
		clear();

		blockSize = h.blockSize;
		numElements = h.numElements;

		HybridListNode* source = h.head;
		HybridListNode* dest = nullptr;
		HybridListNode* prevDest = nullptr;

		while (source != nullptr) { 
			dest = new HybridListNode(blockSize);
			
			for (int i = 0; i < blockSize; i++) {
				dest->at(i) = source->at(i);
			}
			if (prevDest == nullptr) { 
				head = dest;
			} else {
				prevDest->next = dest;
			
			}
			prevDest = dest;
			source = source->next;
		}
		tail = dest;
	}
	return *this;
}

void HybridList::push_back(double value) {
	if (numBlocks == 0) {
		// Hybrid list is empty so creating a new node that will be both the head
		// and tail and append the element to it
		HybridListNode* newTail = new HybridListNode(blockSize);
		newTail->push_back(value);
		tail = newTail;
		head = newTail;
		numBlocks = 1;
	}
	else if (tail->size() == blockSize) {
		// Tail node is full so create a new tail node and copy the back half of
		// the old tail node to the new tail node
		HybridListNode* newTail = new HybridListNode(blockSize);

		// Copy just under half of elements from old tail to new tail
		for (int i = blockSize / 2 + 1; i < blockSize; i++)
			newTail->push_back(tail->at(i));
		tail->resize(blockSize / 2 + 1);
		//cout << tail->size() << endl;
		// Append new item to new tail
		newTail->push_back(value);
		tail->next = newTail;
		//cout << newTail->size() << endl;
		//cout << "Tail: " << tail << endl;
		//cout << "New tail: " << newTail << endl;
		tail = newTail;
		numBlocks++;
	}
	else
		tail->push_back(value);	// Tail isn't full so just append to tail
	
	numElements++;
}

void HybridList::pop_back() {
	if (numElements > 0) {
		if (numBlocks == 1) {
			tail->pop_back();
			numElements--;
			if (tail->size() == 0) {
				delete tail;
				head = tail = nullptr;
				numBlocks = 0;
			}
		} else {
			HybridListNode* prev = head;
			while (prev->next != tail) {
				prev = prev->next;
			}
			tail ->pop_back();
			numElements--;
			
			if (tail->size() == 0 ) {
				delete tail;
				prev -> next = nullptr;
				tail = prev;
				numBlocks--;
			}
		}
	} else {
		throw out_of_range("Cannot pop an empty list.");
	}

}

void HybridList::insert (int index, double value) {
	if (index >= 0 && index <= numElements) {
		int bIndex = index / blockSize;
		int eIndex = index % blockSize;

		if (index == numElements) {
			push_back(value);
			return;
		}

		HybridListNode* current = head;
		for (int i = 0; i < bIndex; i++) {
			current = current->next;
		}

		if (current->size() == blockSize) { 
			HybridListNode* newBlock = new HybridListNode(blockSize);

			for (int i = blockSize / 2; i < blockSize; i++) {
				newBlock->push_back(current->at(i));
			}

			current->resize(blockSize/2);

			newBlock->next = current->next;
			current->next = newBlock;

			if (eIndex == 0) {
				current=newBlock;
			}

			else {
				current = current->next;
			}
			numBlocks++;
		}
		for (int i = current->size(); i > eIndex; i--) { 
			current->at(i) = current->at(i-1);
		}

		current->at(eIndex) = value;
		numElements++;
	} else {
		throw out_of_range("Invalid index for insertion:" + index);
	}
}

void HybridList::erase (int index) {
	if (index >= 0 && index < numElements) {
		int bIndex = index/blockSize;
		int eIndex = index % blockSize;

		HybridListNode* current = head;
		for (int i = 0; i < bIndex; i++) { 
			current = current->next;
		}
		for (int i = eIndex; i < current->size() - 1; i++) {
			current->at(i) = current->at(i+1);
		}
		if (current->size() == 0 && numBlocks > 1) {
			HybridListNode* prev = head;
			for (int i = 0; i < bIndex; i++) { 
				prev = prev->next;
			}
			prev->next = current->next;
			delete current;
			numBlocks--;
		}
	} else {
		throw out_of_range("Invalid index for erasure: " + index);
	}
}

void HybridList::clear() {
	HybridListNode* curNode = head, * nextNode = nullptr;
	// Iterate through each node starting from the head and delete it
	while (curNode != nullptr) {
		nextNode = curNode->next;
		delete curNode;
		curNode = nextNode;
	}
	head = tail = nullptr;
	numElements = numBlocks = 0;
}
