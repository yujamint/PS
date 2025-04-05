#include <iostream>
#include <vector>

using namespace std;

int m, q;
vector<int> arr;
vector< vector<int> > sparseTable;

void init() {
    vector<int> zero = arr;
    sparseTable.push_back(zero);

    int idx = 1;
    while ((1 << idx) < 500000) {
        vector<int> temp(m + 1, 0);
        vector<int> prev = sparseTable[idx - 1];
        for (int i = 1; i <= m; ++i) {
            temp[i] = prev[prev[i]];
        }
        sparseTable.push_back(temp);
        idx++;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    cin >> m;
    arr = vector<int>(m + 1, 0);
    for (int i = 1; i <= m; ++i) {
        cin >> arr[i];
    }

    cin >> q;

    init();
    int n, x;
    while (q--) {
        cin >> n >> x;

        int idx = 0;
        while ((1 << idx) <= n) {
            if (1 << idx & n) x = sparseTable[idx][x];
            idx++;
        }
        cout << x << '\n';
    }

    return 0;
}
