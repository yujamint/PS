#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    cin >> n;

    vector< pair<int, int> > arr(n);
    int from, to;
    for (int i = 0; i < n; ++i) {
        cin >> from >> to;
        arr[i] = make_pair(from, to);
    }
    sort(arr.begin(), arr.end());

    int sum = 0;
    int a = arr[0].first, b = arr[0].second;
    for (int i = 1; i < n; ++i) {
        if (arr[i].first <= b) {
            b = max(b, arr[i].second);
        }
        else {
            sum += b - a;
            a = arr[i].first;
            b = arr[i].second;
        }
    }
    sum += b - a;

    cout << sum;

    return 0;
}