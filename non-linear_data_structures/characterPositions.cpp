#include <iostream>
#include <fstream>
#include <queue>

using namespace std;



int main() {
    ifstream file;
    file.open("input.txt");

    int count = 0;
    char c;
    
    cout << "Enter the character to search for: ";
    cin >> c;
    
    char b;
    int index = 0;

    queue<int> q;

    if (!file.is_open()) { 
        std::cout << "Error, file could not be found" << endl;
        exit(EXIT_FAILURE);
    }
    
    
    while (file.get(b)) {
        
        if (b == c) {
            count++;
            q.push(index);
        }
        index++;
    }
    int size = q.size();
    if (size > 0) {
        cout << "The indices of " << c << " are ";
        for (int i = 0; i < size; i++) {
            cout << q.front() << " ";
            q.pop();
        }
    }
    cout << endl;
    cout << "The number of occurences of " << c << " is " << count << endl;
    file.close();
    
    return 0;
}