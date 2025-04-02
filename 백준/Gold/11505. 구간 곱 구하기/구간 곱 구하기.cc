#include <iostream>
#include <vector>

using namespace std;

#define FOR(i, N) for (int i = 0; i < N; i++)

typedef long long ll;

const int MOD = 1000000007;
int n, m, k, sz;
vector<int> arr;
vector<ll> tree;


void construct() {
    sz = 1;
    while (sz < n) sz <<= 1;
    tree = vector<ll>(sz * 2 + 1, 1);

    FOR(i, n) tree[i + sz] = arr[i];

    for (int i = sz - 1; i >= 1; --i) {
        tree[i] = tree[i * 2] * tree[i * 2 + 1] % MOD;
    }
}

void update(int idx, int val) {
    idx += sz;
    tree[idx] = val;

    while (idx > 1) {
        idx >>= 1;
        tree[idx] = tree[idx * 2] * tree[idx * 2 + 1] % MOD;
    }
}

ll calc(int left, int right, int node, int nodeL, int nodeR) {
    if (left > nodeR || right < nodeL) return 1;
    if (left <= nodeL && nodeR <= right) return tree[node] % MOD;

    int mid = (nodeL + nodeR) / 2;
    ll leftNode = calc(left, right, node * 2, nodeL, mid);
    ll rightNode = calc(left, right, node * 2 + 1, mid + 1, nodeR);
    return leftNode * rightNode % MOD;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m >> k;
    arr = vector<int>(n);
    FOR(i, n) cin >> arr[i];

    construct();

    int cnt = m + k;
    int a, b, c;
    while (cnt--) {
        cin >> a >> b >> c;
        if (a == 1) update(b - 1, c);
        else cout << calc(b, c, 1, 1, sz) << '\n';
    }

    return 0;
}