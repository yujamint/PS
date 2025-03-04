#include <iostream>
#include <vector>

using namespace std;

const int INF = 1e9 + 1;
int n, m, sz = 1, arr[100001];
vector<int> tree;

void construct() {
    while (sz < n)
        sz <<= 1;

    tree = vector<int>(sz * 2, n);
    for (int i = sz; i < sz + n; ++i)
        tree[i] = i - sz;

    for (int i = sz - 1; i >= 1; --i) {
        if (arr[tree[i * 2]] <= arr[tree[i * 2 + 1]]) tree[i] = tree[i * 2];
        else tree[i] = tree[i * 2 + 1];
    }
}

void update(int i, int v) {
    arr[i] = v;
    i += sz;

    while (i > 1) {
        i /= 2;
        if (arr[tree[i * 2]] <= arr[tree[i * 2 + 1]]) tree[i] = tree[i * 2];
        else tree[i] = tree[i * 2 + 1];
    }
}

int segment(int L, int R, int node, int nodeL, int nodeR) {
    if (nodeL > R || nodeR < L) return n;
    if (L <= nodeL && nodeR <= R) return tree[node];

    int mid = (nodeL + nodeR) / 2;
    int left = segment(L, R, node * 2, nodeL, mid);
    int right = segment(L, R, node * 2 + 1, mid + 1, nodeR);
    if (arr[left] <= arr[right]) return left;
    return right;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; ++i)
        cin >> arr[i];
    arr[n] = INF;

    construct();

    cin >> m;
    int a, b, c;
    while (m--) {
        cin >> a >> b >> c;
        if (a == 1)
            update(b - 1, c);
        else
            cout << segment(b - 1, c - 1, 1, 0, sz - 1) + 1 << '\n';
    }
    return 0;
}