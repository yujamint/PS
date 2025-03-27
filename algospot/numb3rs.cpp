#include <iostream>
#include <vector>

using namespace std;

#define FOR(i, n) for (int i = 0; i < n; i++)

int n, d, p, t;
vector< vector<int> > graph, indegree;
double cache[101][50];

double solve(int days, int village) {
    if (days == 0) {
        if (village == p) return 1;
        return 0;
    }

    double &ret = cache[days][village];
    if (ret != -1) return ret;

    ret = 0;
    for (auto &in : indegree[village]) {
        ret += solve(days - 1, in) / graph[in].size();
    }

    return ret;
}

int main() {
    int T;
    cin >> T;

    cout << fixed;
    cout.precision(8);

    while (T--) {
        cin >> n >> d >> p;
        graph = vector< vector<int> >(n, vector<int>());
        indegree = vector< vector<int> >(n, vector<int>());
        FOR(i, n) FOR(j, n) {
            int input;
            cin >> input;
            if (input) {
                graph[i].push_back(j);
                indegree[j].push_back(i);
            }
        }
        FOR(i, d + 1) FOR(j, n) cache[i][j] = -1;

        cin >> t;
        FOR(i, t) {
            int q;
            cin >> q;
            cout << solve(d, q) << ' ';
        }
        cout <<'\n';
    }

    return 0;
}