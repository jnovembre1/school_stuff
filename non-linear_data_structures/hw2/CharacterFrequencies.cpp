#include "CharacterFrequencies.h"
#include <iostream>
#include <algorithm>


using namespace std;

int main() {
    string line = "Twinkle twinkle little star, how I wonder what you are.";
    cout << line <<endl;
    CharacterFrequencies lineCharFreq(line);
    
    lineCharFreq.printFrequencies();
    lineCharFreq.readString(line);
    lineCharFreq.printFrequencies();
    lineCharFreq.readString(line);
    cout << endl;
    lineCharFreq.printFrequencies();
    cout << endl;
    lineCharFreq.reset();
    lineCharFreq.readString(line);
    lineCharFreq.printFrequencies();

}

CharacterFrequencies::CharacterFrequencies() {}

CharacterFrequencies::CharacterFrequencies(string line) {
    readString(line);
}

//reads in string from instance/object whatever c++ calls it. counts how much each char shows up
void CharacterFrequencies::readString(string line) {
    for (char c : line) {
        bool found = false;
        for (auto &element : frequencies) {
            if (element.first == c) {
                element.second++;
                found = true;
                break;
            }
        }

        if (!found) {
            frequencies.push_back(make_pair(c, 1));
        }
    }

    
}
//grabs frequencies for each instance
int CharacterFrequencies::getFrequency(char c) {
    for (const auto &element : frequencies) {
        if (element.first == c) {
            return element.second;
        }
    }
    return 0;
}

//resets frequencies for each instance
void CharacterFrequencies::reset() {
    for (auto &element : frequencies) {
        element.second = 0;
    }

}
//prints frequencies instances of each char from string
void CharacterFrequencies::printFrequencies() {
    for (const auto &element : frequencies) {
        if(element.second != 0) {
            cout << element.first << ": " <<element.second << endl;
        }
    }
}