#include <iostream>
#include <cmath>

using namespace std;

const int INF = 1000000001;
int n, m, arr[100001], maxDp[1000][1000], minDp[1000][1000], maxTemp[1000], minTemp[1000];

void initMin() {
    for (int i = 0; i < 1000; ++i) {
        minTemp[i] = INF;
    }

    for (int i = 0; i < 1000; ++i) {
        for (int j = 0; j < 1000; ++j) {
            minDp[i][j] = INF;
        }
    }
}

pair<int, int> findMinMax(int start, int end) {
    int maxx = 0, minn = INF;

    int start100 = ceil((double) start / 100);
    int end100 = floor((double) end / 100);

    // [start, start100 - 1]
    for (int j = start; j <= min(start100 * 100 - 1, end); ++j) {
        maxx = max(maxx, arr[j]);
        minn = min(minn, arr[j]);
    }

    // [start100, end100 - 1]
    if (start100 < end100) {
        maxx = max(maxx, maxDp[start100][end100 - 1]);
        minn = min(minn, minDp[start100][end100 - 1]);
    }

    // [end100, end]
    for (int j = max(end100 * 100, start); j <= end; ++j) {
        maxx = max(maxx, arr[j]);
        minn = min(minn, arr[j]);
    }

    return make_pair(minn, maxx);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    initMin();

    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        cin >> arr[i];
        int r = i / 100;
        maxTemp[r] = max(maxTemp[r], arr[i]);
        minTemp[r] = min(minTemp[r], arr[i]);
    }

    // 100 단위 해상도의 메모이제이션 초기화
    int it = n / 100;
    for (int i = 0; i < it; ++i) {
        for (int j = i; j < it; ++j) {
            if (i == j) maxDp[i][j] = maxTemp[i];
            else maxDp[i][j] = max(maxDp[i][j - 1], maxTemp[j]);

            if (i == j) minDp[i][j] = minTemp[i];
            else minDp[i][j] = min(minDp[i][j - 1], minTemp[j]);
        }
    }

    int start, end;
    for (int i = 0; i < m; ++i) {
        cin >> start >> end;
        pair<int, int> result = findMinMax(start, end);
        cout << result.first << ' ' << result.second << '\n';
    }


    return 0;
}