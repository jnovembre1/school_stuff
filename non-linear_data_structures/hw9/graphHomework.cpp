#include <iostream>
#include <fstream>
#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <sstream>

using namespace std;

class Graph {
private:
    unordered_map<int, unordered_set<int> > adjList;

public:
    void addEdge(int u, int v) {
        adjList[u].insert(v);
        adjList[v].insert(u); 
    }

    double averageDegree() {
        if (adjList.empty()) return 0.0;

        double totalDegree = 0;
        for (const auto& pair : adjList) {
            totalDegree += pair.second.size();
        }
        return totalDegree / adjList.size();
    }

    int vertices(int threshold) {
        int count = 0;
        for (const auto& pair : adjList) {
            if (pair.second.size() >= threshold) {
                count++;
            }
        }
        return count;
    }
};

int main() {
    ifstream infile("10574177.txt");
    if (!infile) {
        cerr << "Error: Unable to open the file.\n";
        return 1;
    }

    Graph graph;
    string line;
    while (getline(infile, line)) {
        stringstream ss(line);
        int u, v;
        ss >> u >> v;
        graph.addEdge(u, v);
    }

    infile.close();

    double avgDegree = graph.averageDegree();
    cout << "Average degree over all vertices: " << avgDegree << endl;

    int numVerticesWithDegreeGE100 = graph.vertices(100);
    cout << "Number of vertices with degree >= 100: " << numVerticesWithDegreeGE100 << endl;

    return 0;
}


//Problem 3 ALGORITHM PSUEDOCODE
/*
function isConnected(Graph graph):
1. Let V be set of vertices in graph
2. choose arbitrary vertex s from V
3. perform BFS starting from s to reachable vertices
4. V' be set of vertices visited during search
5. if V' = V, return true (graph is connected)
6. otherwise, false (not connected)
worst case time complexity is O(V+E) where V is num vertices, and E is number of edges
since number of edges is smaller than O(V^2), overall time complexity can be
simplified to O(V). in a connected graph, number of edges is proportional to num vertices
therefore, time complexity is linear to number of vertices.




*/