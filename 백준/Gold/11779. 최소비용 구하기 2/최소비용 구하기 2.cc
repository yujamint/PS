#include <iostream>
#include <limits.h>
#include <queue>
#include <functional>
#include <memory.h>
#include <stack>

using namespace std;

const int INF = INT_MAX;
int n, m;
vector< vector< pair<int, int> > > graph;

struct cmp {
    bool operator()(pair<int, int> a, pair<int, int> b) {
        return a.first > b.first;
    }
};

void dijkstra(int node, int to) {
    int dist[n + 1];
    for (int i = 0; i <= n; ++i) dist[i] = INF;
    dist[node] = 0;

    int path[n + 1];
    memset(path, -1, sizeof(path));
    path[node] = node;

    priority_queue< pair<int, int>, vector< pair<int, int> >, cmp > pq;
    pq.push(make_pair(0, node));

    bool visited[n + 1];
    memset(visited, 0, sizeof(visited));
    while (!pq.empty()) {
        pair<int, int> cur = pq.top();
        pq.pop();
        int d = cur.first, now = cur.second;
        if (visited[now]) continue;
        visited[now] = true;

        for (auto &edge : graph[now]) {
            int next = edge.first, nextD = edge.second;
            if (dist[next] > nextD + d) {
                dist[next] = nextD + d;
                pq.push(make_pair(dist[next], next));
                path[next] = now;
            }
        }
    }

    cout << dist[to] << '\n';

    stack<int> stack;
    while (to != node) {
        stack.push(to);
        to = path[to];
    }
    stack.push(node);
    cout << stack.size() << '\n';
    while (!stack.empty()) {
        cout << stack.top() << ' ';
        stack.pop();
    }
}

int main() {
    cin >> n >> m;

    int from, to, cost;
    graph = vector< vector< pair<int, int> > >(n + 1);
    for (int i = 0; i < m; ++i) {
        cin >> from >> to >> cost;
        graph[from].emplace_back(to, cost);
    }

    int start, end;
    cin >> start >> end;

    dijkstra(start, end);

    return 0;
}