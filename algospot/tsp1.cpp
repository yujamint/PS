#include <iostream>

using namespace std;

int c, n;
double dist[8][8], minSum;
bool visited[8];

void search(int k, int cur, double sum) {
    if (k == n) {
        minSum = min(minSum, sum);
        return;
    }

    for (int next = 0; next < n; ++next) {
        if (visited[next]) continue;
        visited[next] = true;
        search(k + 1, next, sum + dist[cur][next]);
        visited[next] = false;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cout << fixed;
    cout.precision(10);

    cin >> c;

    for (int T = 0; T < c; ++T) {
        cin >> n;
        minSum = 1415 * 8 + 1;
        for (int i = 0; i < n; ++i) {
            visited[i] = false;
            for (int j = 0; j < n; ++j) {
                dist[i][j] = 0;
            }
        }

        double d;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cin >> d;
                dist[i][j] = d;
            }
        }

        for (int start = 0; start < n; ++start) {
            visited[start] = true;
            search(1, start, 0);
            visited[start] = false;
        }

        cout << minSum << '\n';
    }
    return 0;
}