#include <string>
#include <vector> 
#include <queue>
#include <memory.h>
#include <iostream>

using namespace std;

const int INF = 10000001;
int len;
vector<vector<pair<int, int>>> graph;
bool isSummit[50001], isGate[50001];

struct cmp {
    bool operator()(pair<int,int> a, pair<int,int> b) {
        if (a.second == b.second) return a.first > b.first;
        return a.second > b.second;
    }
};

vector<int> dijkstra(int gate) {
    // pair: node, gate부터 node까지의 최소 intensity
    priority_queue<pair<int,int>, vector<pair<int,int>>, cmp> pq;
    pq.push(make_pair(gate, 0));
    
    vector<int> intensity(len + 1, INF);
    intensity[gate] = 0;
    
    while (!pq.empty()) {
        pair<int, int> t = pq.top();
        int cur = t.first, curIntensity = t.second;
        pq.pop();
        if (isSummit[cur]) break;
        
        for (auto &edge : graph[cur]) {
            int next = edge.first, nextIntensity = edge.second;
            if (isGate[next]) continue;
            if (intensity[next] > max(curIntensity, nextIntensity)) {
                intensity[next] = max(curIntensity, nextIntensity);
                pq.push(make_pair(next, intensity[next]));
            }
        }
    }
    
    return intensity;
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
    int minIntensity = INF;
    int prevSummit = 50001;
    vector<int> answer(2);
    for (auto &gate : gates) {
        vector<int> intensity = dijkstra(gate);
        for (auto &summit : summits) {
            if (minIntensity == intensity[summit] && prevSummit > summit) {
                answer[0] = summit;
                prevSummit = summit;
            }
            if (minIntensity > intensity[summit]) {
                minIntensity = min(minIntensity, intensity[summit]);
                answer[0] = summit;
                answer[1] = minIntensity;
                prevSummit = summit;
            }
        }
    }

    return answer;
}