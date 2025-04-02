#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> arr;

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        arr.push_back(temp);
    }

    if (n == 1) {
        cout << 'A';
        return 0;
    }

    if (n == 2) {
        if (arr[0] == arr[1]) cout << arr[0];
        else cout << 'A';
        return 0;
    }

    int a = 0;
    if (arr[0] != arr[1]) a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
    int b = arr[1] - arr[0] * a;

    bool flag = true;
    for (int i = 0; i < n - 1; ++i) {
        int next = arr[i] * a + b;
        if (next != arr[i + 1]) {
            cout << 'B';
            return 0;
        }
    }

    cout << arr[n - 1] * a + b;

    return 0;
}