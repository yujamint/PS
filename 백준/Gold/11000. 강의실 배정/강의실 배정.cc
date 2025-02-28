#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int n;

bool compare(pair<int,int> a, pair<int,int> b) {
    if (a.first == b.first) return a.second < b.second;
    return a.first < b.first;
}

int main() {
    cin >> n;

    vector< pair<int, int> > classes;
    int s, e;
    for (int i = 0; i < n; i++) {
        cin >> s >> e;
        classes.emplace_back(s, e);
    }
    sort(classes.begin(), classes.end(), compare);

    priority_queue<int> pq;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        pair<int,int> cur = classes[i];
        int start = cur.first, end = cur.second;

        if (pq.empty()) {
            pq.push(-1 * end);
            cnt++;
        }
        else {
            int minEnd = pq.top();
            if (start >= -1 * minEnd) {
                pq.pop();
                pq.push(-1 * end);
            }
            else {
                pq.push(-1 * end);
                cnt++;
            }
        }
    }

    cout << cnt;

    return 0;
}