#include <iostream>
#include <vector>

using namespace std;

const int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
const int FRONT = -1, BACK = 1, INF = 1234567890;
int m, n;
int cnt = INF;
vector< vector<int> > answer;

void flip(int x, int y, vector< vector<int> > &board, vector< vector<int> > &history, int mode) {
    history[x][y] += mode;
    board[x][y] *= -1;
    for (int i = 0; i < 4; ++i) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
        board[nx][ny] *= -1;
    }
}

bool isAllFront(const vector< vector<int> > &board) {
    for (int i = 0; i < n; ++i) {
        if (board[m - 1][i] == BACK) return false;
    }
    return true;
}

void search(int k, vector< vector<int> > &board, vector< vector<int> > &history) {
    if (k == n) {
        vector< vector<int> > temp = board;
        vector< vector<int> > ch = history;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (temp[i - 1][j] == BACK) {
                    flip(i, j, temp, ch, 1);
                }
            }
        }

        if (isAllFront(temp)) {
            int flipCnt = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    flipCnt += ch[i][j];
                }
            }

            if (flipCnt > cnt) return;

            if (flipCnt < cnt) {
                answer = ch;
                cnt = flipCnt;
                return;
            }

            bool flag = false;
            bool change = false;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (!flag && answer[i][j] != ch[i][j]) {
                        if (answer[i][j] > ch[i][j]) change = true;
                        flag = true;
                    }
                }
            }
            if (change) {
                answer = ch;
                cnt = flipCnt;
            }
        }
        return;
    }

    search(k + 1, board, history);

    flip(0, k, board, history, 1);
    search(k + 1, board, history);
    flip(0, k, board, history, -1);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> m >> n;

    vector< vector<int> > board(m, vector<int>(n, 0));
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> board[i][j];
            if (board[i][j] == 0) board[i][j] = FRONT;
        }
    }

    vector< vector<int> > history(m, vector<int>(n, 0));

    search(0,board, history);

    if (cnt != INF) {
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cout << answer[i][j] << ' ';
            }
            cout << '\n';
        }
    } else {
        cout << "IMPOSSIBLE";
    }

    return 0;
}