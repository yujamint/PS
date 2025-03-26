#include <iostream>
#include <vector>

using namespace std;

int t, n, m, s1, s2, answer;
bool *checked, **areFriends;

int countPairs(bool checked[]) {
    int firstFree = -1;
    for (int i = 0; i < n; ++i) {
        if (!checked[i]) {
            firstFree = i;
            break;
        }
    }
    if (firstFree == -1)
        return 1;

    int ret = 0;

    checked[firstFree] = true;
    for (int i = firstFree + 1; i < n; ++i) {
        if (checked[i] || !areFriends[firstFree][i]) continue;
        checked[i] = true;
        ret += countPairs(checked);
        checked[i] = false;
    }
    checked[firstFree] = false;

    return ret;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> t;

    for (int T = 0; T < t; ++T) {
        answer = 0;

        cin >> n >> m;

        checked = new bool[n];
        for (int i = 0; i < n; ++i) {
            checked[i] = false;
        }

        areFriends = new bool*[n];
        for (int i = 0; i < n; ++i) {
            areFriends[i] = new bool[n];
            for (int j = 0; j < n; ++j) {
                areFriends[i][j] = false;
            }
        }

        for (int i = 0; i < m; ++i) {
            cin >> s1 >> s2;
            areFriends[s1][s2] = true;
            areFriends[s2][s1] = true;
        }

        vector<int> v(n);
        for (int i = 0; i < n; ++i) {
            v[i] = i;
        }

        cout << countPairs(checked) << '\n';
    }

    return 0;
}
