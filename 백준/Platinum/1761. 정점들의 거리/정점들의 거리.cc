#include <iostream>
#include <vector>
#include <memory.h>

using namespace std;

typedef pair<int, int> pii;

const int MAX = 40000;
const int MAX_D = 16;

int n, m;
vector< vector<pii> > graph;
int parent[MAX][MAX_D];
int dist[MAX][MAX_D];
int depth[MAX];

void makeTreeByDFS(int cur) {
    for (pii p : graph[cur]) {
        int next = p.first;
        int d = p.second;
        if (depth[next] == -1) {
            depth[next] = depth[cur] + 1;
            parent[next][0] = cur;
            dist[next][0] = d;
            makeTreeByDFS(next);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    cin >> n;
    graph = vector< vector<pii> >(n, vector<pii>());
    for (int i = 0; i < n - 1; ++i) {
        int u, v, d;
        cin >> u >> v >> d;
        u--; v--;
        graph[u].emplace_back(v, d);
        graph[v].emplace_back(u, d);
    }

    memset(parent, -1, sizeof(parent));
    memset(dist, -1, sizeof(dist));
    memset(depth, -1, sizeof(depth));
    depth[0] = 0;
    // 트리 구성
    makeTreeByDFS(0);

    // parent, dist 희소 테이블 구성
    for (int j = 0; j < MAX_D - 1; ++j) {
        for (int i = 1; i < n; ++i) {
            if (parent[i][j] != -1) {
                parent[i][j + 1] = parent[parent[i][j]][j];
                dist[i][j + 1] = dist[i][j] + dist[parent[i][j]][j];
            }
        }
    }

    cin >> m;
    for (int i = 0; i < m; ++i) {
        int u, v;
        cin >> u >> v;
        u--; v--;
        int d = 0;

        // 높이 맞추기
        if (depth[u] < depth[v]) swap(u, v);
        int diff = depth[u] - depth[v];

        for (int j = 0; diff; ++j) {
            if (diff % 2) {
                d += dist[u][j];
                u = parent[u][j];
            }
            diff /= 2;
        }

        if (u != v) {
            for (int j = MAX_D - 1; j >= 0; --j) {
                if (parent[u][j] != -1 && parent[u][j] != parent[v][j]) {
                    d += dist[u][j] + dist[v][j];
                    u = parent[u][j];
                    v = parent[v][j];
                }
            }
            d += dist[u][0] + dist[v][0];
        }
        cout << d << '\n';
    }


    return 0;
}