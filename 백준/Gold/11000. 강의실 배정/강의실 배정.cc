#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int n;

bool compare(pair<int,int> a, pair<int,int> b) {
    if (a.second == b.second) return a.first > b.first;
    return a.second > b.second;
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
            pq.push(start);
            cnt++;
        }
        else {
            int minStart = pq.top();
            if (end <= minStart) {
                pq.pop();
                pq.push(start);
            }
            else {
                pq.push(start);
                cnt++;
            }
        }
    }

    cout << cnt;

    return 0;
}