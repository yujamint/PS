#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n, d;
vector< pair<int, int> > lines;

bool cmp(pair<int, int> a, pair<int, int> b) {
    if (a.second == b.second)
        return a.first < b.first;
    return a.second < b.second;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    cin >> n;

    int a, b;

    for (int i = 0; i < n; ++i) {
        cin >> a >> b;
        lines.emplace_back(min(a, b), max(a, b));
    }
    cin >> d;

    priority_queue<int> pq;

    sort(lines.begin(), lines.end(), cmp);

    int answer = 0;
    for (int i = 0; i < n; ++i) {
        int start = lines[i].first;
        int end = lines[i].second;

        if (end - start > d) continue;
        pq.push(-start);

        while (!pq.empty()) {
            if (-pq.top() + d < end) pq.pop();
            else {
                answer = max(answer, (int)pq.size());
                break;
            }
        }

    }

    cout << answer;
}
