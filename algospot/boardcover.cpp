#include <iostream>
#include <vector>

using namespace std;

int c, h, w;
const int coverType[4][3][2] = {
    { {0, 0}, {1, 0}, {1, 1} },
    { {0, 0}, {1, 0}, {1, -1} },
    { {0, 0}, {1, 0}, {0, 1} },
    { {0, 0}, {0, 1}, {1, 1} }
};

bool possibleToFill(int x, int y, const vector< vector<char> >& board, int shapeNum) {
    if (x > h - 2) return false;
    for (int i = 0; i < 3; ++i) {
        int nx = x + coverType[shapeNum][i][0];
        int ny = y + coverType[shapeNum][i][1];

        if (ny >= w || ny < 0) return false;
        if (board[nx][ny] == '#') return false;
    }
    return true;
}

void fillBoard(int x, int y, vector< vector<char> >& board, int shapeNum) {
    for (int i = 0; i < 3; ++i) {
        int nx = x + coverType[shapeNum][i][0];
        int ny = y + coverType[shapeNum][i][1];

        board[nx][ny] = '#';
    }
}

void unfillBoard(int x, int y, vector< vector<char> >& board, int shapeNum) {
    for (int i = 0; i < 3; ++i) {
        int nx = x + coverType[shapeNum][i][0];
        int ny = y + coverType[shapeNum][i][1];

        board[nx][ny] = '.';
    }
}

int coverBoard(int x, int y, vector< vector<char> > board) {
    if (x >= h) return 1;
    if (y >= w) return coverBoard(x + 1, 0, board);
    if (board[x][y] == '#') return coverBoard(x, y + 1, board);

    int ret = 0;
    for (int i = 0; i < 4; ++i) {
        if (possibleToFill(x, y, board, i)) {
            fillBoard(x, y, board, i);
            ret += coverBoard(x, y + 1, board);
            unfillBoard(x, y, board, i);
        }
    }
    return ret;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> c;

    for (int T = 0; T < c; ++T) {
        cin >> h >> w;

        vector< vector<char> > board(h, vector<char>(w));

        int emptyCount = 0;
        string input;
        for (int i = 0; i < h; ++i) {
            cin >> input;
            for (int j = 0; j < w; ++j) {
                board[i][j] = input[j];
                if (board[i][j] == '.') emptyCount++;
            }
        }

        int ret;
        if (emptyCount % 3 != 0) {
            ret = 0;
        } else {
            ret = coverBoard(0, 0, board);
        }

        cout << ret << '\n';
    }
}
