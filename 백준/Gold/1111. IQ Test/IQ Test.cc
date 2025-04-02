#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int n;
vector<int> arr;
unordered_set<int> answer;

void check(int idx, const int &a, const int &b) {
    int next = arr[idx] * a + b;

    if (idx == n - 1) {
        answer.insert(next);
        return;
    }

    if (next == arr[idx + 1]) check(idx + 1, a, b);
}

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

    int first = arr[0];
    for (int a = -500000; a <= 500000; ++a) {
        if (answer.size() > 1) break;

        int A = first * a;
        int b = arr[1] - A;
        check(0, a, b);
    }

    if (answer.size() > 1) cout << 'A';
    else if (answer.empty()) cout << 'B';
    else cout << *answer.begin();

    return 0;
}