#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <memory.h>

using namespace std;

struct cmp {
    bool operator()(pair<int, int> a, pair<int, int> b) {
        return a.second > b.second;
    }
};

priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
int n, cnt = 0, p[200000], sz[200000];
bool used[200000];

int find(int x) {
    if (p[x] < 0) return x;
    return p[x] = find(p[x]);
}

void unionn(int x, int y) {
    x = find(x);
    y = find(y);
    
    if (x == y) return;
    
    if (sz[x] < sz[y]) {
        p[x] = y;
        sz[y] += sz[x];
    } else {
        p[y] = x;
        sz[x] += sz[y];
    }
}

int solution(vector<int> stones, int k) {
    memset(p, -1, sizeof(p));
    n = stones.size();
    for (int i = 0; i < n; i++) {
        sz[i] = 1;
        pq.push(make_pair(i, stones[i]));
    }
    
    while (!pq.empty()) {    
        pair<int, int> cur;
        vector<int> usedTemp;
        int idx, num;
        do {
            cur = pq.top();
            pq.pop();
            idx = cur.first, num = cur.second;
            usedTemp.push_back(idx);
        } while (!pq.empty() && pq.top().second == num);
        
        cnt = num;
        
        for (auto &usedIdx : usedTemp) {
            used[usedIdx] = true;
            int usedCnt = 1;
            if (usedIdx - 1 >= 0 && used[usedIdx - 1]) unionn(usedIdx, usedIdx - 1);
            if (usedIdx + 1 < n && used[usedIdx + 1]) unionn(usedIdx, usedIdx + 1);
            if (sz[find(usedIdx)] >= k) {
                return cnt;
            }
        }
    }
    
    return -1;
}