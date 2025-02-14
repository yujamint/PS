#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector< vector<string> > arr;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    arr = vector< vector<string> >(n);
    for (int i = 0; i < n; ++i) {
        int foodCount;
        cin >> foodCount;
        vector<string> temp(foodCount);
        for (int j = 0; j < foodCount; ++j) {
            cin >> temp[j];
        }
        arr[i] = temp;
    }

    sort(arr.begin(), arr.end());

    for (int i = 0; i < n; ++i) {
        vector<string> prev = i > 0 ? arr[i - 1] : vector<string>();
        vector<string> foods = arr[i];
        bool flag = true;
        for (int j = 0; j < foods.size(); ++j) {
            if (flag && prev.size() > j && prev[j] == foods[j]) continue;
            flag = false;
            cout << string(j * 2, '-') << foods[j] << '\n';
        }
    }

    return 0;
}
