#include <iostream>

using namespace std;

int t;
bool exists;
int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
char arr[5][5];

void findWord(char arr[][5], int x, int y, string target, string cur) {
    if (exists) return;
    if (cur.length() == target.length()) {
        if (cur == target) {
            exists = true;
        }
        return;
    }

    for (int i = 0; i < 8; ++i) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 5 || ny >= 5 || nx < 0 || ny < 0) continue;

        findWord(arr, nx, ny, target, cur + arr[nx][ny]);
    }
}

bool hasWord(int x, int y, const string &word) {
    if (x >= 5 || y >= 5 || x < 0 || y < 0) return false;

    if (arr[x][y] != word[0]) return false;

    if (word.length() == 1) return true;

    for (int i = 0; i < 8; ++i) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (hasWord(nx, ny, word.substr(1))) {
            return true;
        }
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> t;

    for (int T = 0; T < t; ++T) {
        int n;
        string target;
        for (auto & i : arr) {
            cin >> i;
        }

        cin >> n;


        for (int i = 0; i < n; ++i) {
            cin >> target;

            exists = false;

            for (int i = 0; i < 5; ++i) {
                if (exists) break;
                for (int j = 0; j < 5; ++j) {
                    if (hasWord(i, j, target)) {
                        exists = true;
                        break;
                    }
                }
            }
            string res = exists ? "YES" : "NO";
            cout << target << " " << res << '\n';
        }

    }

    return 0;
}
