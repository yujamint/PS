#include <iostream>
#include <vector>

using namespace std;

int n;
vector< pair<int, int> > impurities;
vector< vector<int> > board;

pair<int, int> countJewelAndImpurities(int sx, int sy, int ex, int ey) {
    int jewelCount = 0, impuritiesCount = 0;
    for (int i = sx; i <= ex; ++i) {
        for (int j = sy; j <= ey; ++j) {
            if (board[i][j] == 1) impuritiesCount++;
            else if (board[i][j] == 2) jewelCount++;
        }
    }
    return make_pair(jewelCount, impuritiesCount);
}

int chop(int sx, int sy, int ex, int ey, bool isPrevVertical) {
    pair<int, int> ji = countJewelAndImpurities(sx, sy, ex, ey);
    int jewelCount = ji.first, impuritiesCount = ji.second;
    if (jewelCount != impuritiesCount + 1) return 0;
    if (jewelCount == 1) return 1;

    int res = 0;
    for (auto &p : impurities) {
        int x = p.first, y = p.second;

        if (sx > x || ex < x || sy > y || ey < y) continue;
        if (isPrevVertical && (sx == x || ex == x)) continue;
        if (!isPrevVertical && (sy == y || ey == y)) continue;

        if (isPrevVertical) { // 가로로 자르기
            // 불순물과 같은 행에 보석 존재한다면 pass
            bool flag = false;
            for (int i = sy; i <= ey; ++i)
                if (board[x][i] == 2) flag = true;
            if (flag) continue;

            int sub1 = chop(sx, sy, x - 1, ey, false);
            if (sub1 == 0) continue;
            int sub2 = chop(x + 1, sy, ex, ey, false);
            res += sub1 * sub2;
        } else { // 세로로 자르기
            // 불순물과 같은 열에 보석 존재한다면 패스
            bool flag = false;
            for (int i = sx; i <= ex; ++i)
                if (board[i][y] == 2) flag = true;
            if (flag) continue;

            int sub1 = chop(sx, sy, ex, y - 1, true);
            if (sub1 == 0) continue;
            int sub2 = chop(sx, y + 1, ex, ey, true);
            res += sub1 * sub2;
        }
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    cin >> n;

    board = vector< vector<int> >(n, vector<int>(n, 0));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> board[i][j];
            if (board[i][j] == 1) impurities.emplace_back(i, j);
        }
    }

    int res = chop(0, 0, n - 1, n - 1, true);
    res += chop(0, 0, n - 1, n - 1, false);

    int answer = res == 0 ? -1 : res;

    cout << answer << '\n';

    return 0;
}
