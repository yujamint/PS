#include <iostream>
#include <vector>
#include <memory.h>

using namespace std;

const int MAX = 100000;
const int MAX_D = 17;

int n, m;
vector< vector<int> > graph;
int depth[MAX];
int parent[MAX][MAX_D];

void makeTreeByDFS(int cur) {
    for (int next : graph[cur]) {
        if (depth[next] == -1) {
            parent[next][0] = cur;
            depth[next] = depth[cur] + 1;
            makeTreeByDFS(next);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cout.tie(nullptr);
    cin.tie(nullptr);

    cin >> n;

    graph = vector< vector<int> >(n, vector<int>());
    for (int i = 0; i < n - 1; ++i) {
        int a, b;
        cin >> a >> b;
        a--; b--;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    memset(parent, -1, sizeof(parent));
    memset(depth, -1, sizeof(depth));
    depth[0] = 0;
    // 트리 생성
    makeTreeByDFS(0);

    // parent 배열 채우기
    for (int j = 0; j < MAX_D - 1; ++j) {
        for (int i = 1; i < n; ++i) {
            if (parent[i][j] != -1)
                parent[i][j + 1] = parent[parent[i][j]][j];
        }
    }

    cin >> m;
    for (int i = 0; i < m; ++i) {
        int a, b;
        cin >> a >> b;
        a--; b--;
        if (depth[a] < depth[b]) swap(a, b);
        int diff = depth[a] - depth[b];

        for (int j = 0; diff; ++j) {
            if (diff % 2) a = parent[a][j];
            diff /= 2;
        }

        if (a != b) {
            for (int j = MAX_D - 1; j >= 0; --j) {
                if (parent[a][j] != -1 && parent[a][j] != parent[b][j]) {
                    a = parent[a][j];
                    b = parent[b][j];
                }
            }
            a = parent[a][0];
        }

        cout << a + 1 << '\n';
    }

    return 0;
}
