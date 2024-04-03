#include "IndexedBST.h"
#include <iostream>


Node* IndexedBST::search(double desiredKey) {
    Node* cur = root;
    while (cur != nullptr) {
        // Return the node if the key matches
        if (cur->key == desiredKey) {
            return cur;
        }

        // Navigate to the left if the search key is 
        // less than the node's key.
        else if (desiredKey < cur->key) {
            cur = cur->left;
        }

        // Navigate to the right if the search key is 
        // greater than the node's key.
        else {
            cur = cur->right;
        }
    }

    // The key was not found in the tree.
    return nullptr;
}

Node* IndexedBST::at(int index) {
    Node* cur = root;
    while (cur != nullptr) {
        if (index == cur->leftSize)
            return cur;     // Found
        else if (index < cur->leftSize)
            cur = cur->left;    // index is in left subtree
        else {
            // index is in right subtree
            index = index - cur->leftSize - 1;
            cur = cur->right;
        }
    }

    return nullptr;
}

void IndexedBST::insert(Node* node) {
    
    if (root == nullptr) {
        root = node;
        return;
    }

    Node* current = root;
    Node* parent = nullptr;
    bool insertedLeft = false;

    while (current != nullptr) {
        parent = current;

        if (node->key < current->key) { 
            current->leftSize++;
            current = current->left;
            insertedLeft=true;
        }

        else {
            current = current->right;
            insertedLeft=false;
        }
    }
    node->parent = parent;
    if (insertedLeft) {
        parent->left = node;
    }
    else {
        parent->right = node;
    }
        

}

bool IndexedBST::remove(double key) {
    Node* current = root;
    Node* parent = nullptr;
    bool isLeftChild = false;

    while (current != nullptr && current->key != key) {
        
        parent = current;
        if (key < current->key) {
            current = current->left;
            isLeftChild = true;
            
        }
        else {
            current = current->right;
            isLeftChild = false;
        }
    }

    if (current==nullptr) {
        return false;
    }

    if (current->left == nullptr && current-> right == nullptr) { 
        
        if (current == root) {
            root = nullptr;
        }
        else {
            if (isLeftChild) {
                parent->left = nullptr;
                current->leftSize--;
            }
            else {
                parent-> right = nullptr;
            }
        }
        delete current;
    }
    else if (current-> left == nullptr) {
        
        if (current==root) {
            root = current->right;

        }
        else if (isLeftChild) {
            parent->left = current->right;
            current->leftSize--;

        }
        else {
            parent->right = current->right;

        }
        current->right->parent = parent;
        delete current;
    }
    else if (current->right == nullptr) {
        if (current == root) {
            root = current->left;
        }
        else if (isLeftChild) {
            parent->left = current->left;
            current->leftSize--;
        

        }
        else {
            parent->right = current->left;
        }
        current->left->parent = parent;
        delete current;
    }
    else {
        Node* successor = current->right;
        while (successor->left != nullptr) {
            successor = successor->left;
        }
        
        double successorKey = successor->key;
        remove(successorKey);
        current-> key = successorKey;
        
    }
    return true;
}
