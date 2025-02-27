#include <string>
#include <vector> 
#include <queue>
#include <memory.h>
#include <iostream>

using namespace std;

const int INF = 10000001;
int len, minSummit = 50001, minIntensity = INF;
vector<vector<pair<int, int>>> graph;
bool isSummit[50001], isGate[50001];

struct cmp {
    bool operator()(pair<int,int> a, pair<int,int> b) {
        if (a.second == b.second) return a.first > b.first;
        return a.second > b.second;
    }
};

void dijkstra(vector<int> gates) {
    // pair: node, gate부터 node까지의 최소 intensity
    priority_queue<pair<int,int>, vector<pair<int,int>>, cmp> pq;
    vector<int> intensity(len + 1, INF);
    for (auto &gate : gates) {
        pq.push(make_pair(gate, 0));
        intensity[gate] = 0;
    }
    
    while (!pq.empty()) {
        pair<int, int> t = pq.top();
        int cur = t.first, curIntensity = t.second;
        pq.pop();
        
        if (curIntensity > minIntensity) continue;
        if (curIntensity > intensity[cur]) continue;
        
        if (isSummit[cur]) {
            if (minIntensity > curIntensity || (minIntensity == curIntensity && minSummit > cur)) {
                minIntensity = curIntensity;
                minSummit = cur;
            } 
            continue;
        }
        
        for (auto &edge : graph[cur]) {
            int next = edge.first, nextIntensity = edge.second;
            if (isGate[next]) continue;
            if (intensity[next] > max(curIntensity, nextIntensity)) {
                intensity[next] = max(curIntensity, nextIntensity);
                pq.push(make_pair(next, intensity[next]));
            }
        }
    }
    
    // return intensity;
}

vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    len = n;
    for (auto &summit : summits) {
        isSummit[summit] = true;
    }
    for (auto &gate : gates) {
        isGate[gate] = true;
    }
    
    // 1. 그래프 만들기
    graph = vector<vector<pair<int, int>>>(len + 1);
    for (auto &path : paths) {
        int from = path[0];
        int to = path[1];
        int cost = path[2];
        
        graph[from].emplace_back(to, cost);
        graph[to].emplace_back(from, cost);
    }
    
    // 2. 출입구 순회
    // int minIntensity = INF;
    // int prevSummit = 50001;
    vector<int> answer(2);
    dijkstra(gates);

    return {minSummit, minIntensity};
}