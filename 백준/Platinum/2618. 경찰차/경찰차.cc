#include <iostream>
#include <vector>
#include <memory.h>

using namespace std;

int n, w, cache[1001][1001];
vector< pair<int, int> > cases;
vector<int> history;

int calculateDist(int fromX, int fromY, int toX, int toY) {
    return abs(toX - fromX) + abs(toY - fromY);
}

int solve(int aCase, int bCase) {
    if (aCase == w - 1 || bCase == w - 1) return 0;

    int &ret = cache[aCase + 1][bCase + 1];
    if (ret != -1) return ret;

    ret = 0;

    int curCaseId = max(aCase, bCase);
    int nextCaseId = curCaseId + 1;
    pair<int, int> nextCase = cases[nextCaseId];

    pair<int, int> curA = aCase == -1 ? make_pair(1, 1) : cases[aCase];
    pair<int, int> curB = bCase == -1 ? make_pair(n, n) : cases[bCase];

    int na = calculateDist(curA.first, curA.second, nextCase.first, nextCase.second) + solve(nextCaseId, bCase);
    int nb = calculateDist(curB.first, curB.second, nextCase.first, nextCase.second) + solve(aCase, nextCaseId);
    return ret = min(na, nb);
}

void printPath(int aCase, int bCase) {
    if (aCase == w - 1 || bCase == w - 1) return;

    int nextCaseId = max(aCase, bCase) + 1;
    pair<int, int> nextCase = cases[nextCaseId];

    pair<int, int> curA = aCase == -1 ? make_pair(1, 1) : cases[aCase];
    pair<int, int> curB = bCase == -1 ? make_pair(n, n) : cases[bCase];

    int na = calculateDist(curA.first, curA.second, nextCase.first, nextCase.second) + cache[nextCaseId + 1][bCase + 1];
    int nb = calculateDist(curB.first, curB.second, nextCase.first, nextCase.second) + cache[aCase + 1][nextCaseId + 1];

    if (na > nb) {
        cout << 2 << '\n';
        printPath(aCase, nextCaseId);
        return;
    }
    cout << 1 << '\n';
    printPath(nextCaseId, bCase);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    cin >> n >> w;

    history = vector<int>(w);
    cases = vector< pair<int, int> >(w);
    int x, y;
    for (int i = 0; i < w; ++i) {
        cin >> x >> y;
        cases[i] = make_pair(x, y);
    }

    memset(cache, -1, sizeof(cache));

    int result = solve(-1, -1);
    cout << result << '\n';
    printPath(-1, -1);
    return 0;
}
