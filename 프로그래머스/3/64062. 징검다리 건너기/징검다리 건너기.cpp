#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

struct cmp {
    bool operator()(pair<int, int> a, pair<int, int> b) {
        return a.second > b.second;
    }
};

priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
int n, cnt = 0;
bool used[200000];

int solution(vector<int> stones, int k) {
    n = stones.size();
    for (int i = 0; i < n; i++) {
        pq.push(make_pair(i, stones[i]));
    }
    
    if (n == 1) {
        return stones[0];
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
        //
        
        cnt = num;
        
        for (auto &usedIdx : usedTemp) {
            used[usedIdx] = true;
            int usedCnt = 1;
            int left = usedIdx, right = usedIdx;
            while (--left >= 0 && used[left]) usedCnt++;
            while (++right < n && used[right]) usedCnt++;
            if (usedCnt >= k) {
                return cnt;
            }
        }
    }
    
    return -1;
}