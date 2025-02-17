#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    cin >> n;

    vector< pair<int, int> > arr;
    int from, to;
    for (int i = 0; i < n; ++i) {
        cin >> from >> to;
        arr.emplace_back(from, to);
        arr.emplace_back(to, from);
    }
    sort(arr.begin(), arr.end());

    int maxl = 1;
    int b = arr[0].second;
    int cur = 1;
    for (int i = 1; i < arr.size(); ++i) {
        if (arr[i].first > arr[i].second) {
            cur--;
            continue;
        }

        if (arr[i].first < b) {
            b = max(b, arr[i].second);
            cur++;
            maxl = max(maxl, cur);
        }
        else {
            cur++;
            b = arr[i].second;
        }
    }

    cout << maxl;

    return 0;
}
