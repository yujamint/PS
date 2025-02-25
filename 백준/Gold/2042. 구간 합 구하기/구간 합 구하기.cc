#include <iostream>

using namespace std;

typedef long long ll;

int n, m, k, sz = 1;
ll arr[1000001];
ll tree[1000000 * 4 + 1];

// Top Down 방식
ll init(int start, int end, int node) {
    if (start == end) return tree[node] = arr[start];
    int mid = (start + end) / 2;
    return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
}

ll update1(int start, int end, int node, int idx, ll val) {
    if (idx < start || idx > end) return tree[node];
    if (start == end) return tree[node] = val;

    int mid = (start + end) / 2;
    return tree[node] = update1(start, mid, node * 2, idx, val) + update1(mid + 1, end, node * 2 + 1, idx, val);
}

// Bottom Up 방식
void construct() {
    for (int i = sz; i < sz + n; ++i) {
        tree[i] = arr[i - sz + 1];
    }

    for (int i = sz - 1; i > 0; --i) {
        tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
}

void update2(int idx, ll val) {
    idx += sz;
    tree[idx] = val;

    while (idx > 1) {
        idx /= 2;
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }
}

// 공통
ll sum(int start, int end, int node, int left, int right) {
    // 범위를 완전히 벗어나면
    if (left > end || right < start) return 0;
    // 범위에 완전히 속하면
    if (left >= start && right <= end) return tree[node];

    // 범위에 일부만 속하면
    int mid = (left + right) / 2;
    return sum(start, end, node * 2, left, mid) + sum(start, end, node * 2 + 1, mid + 1, right);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m >> k;

    while (sz < n) {
        sz <<= 1;
    }

    for (int i = 1; i <= n; ++i) {
        cin >> arr[i];
    }

    init(1, n, 1);
    // construct();

    int cnt = m + k;
    int a, b;
    ll c;
    while (cnt--) {
        cin >> a >> b >> c;

        if (a == 1) update1(1, n, 1, b, c);
        // if (a == 1) update2(b - 1, c);
        if (a == 2) cout << sum(b, c, 1, 1, n) << '\n';
    }

    return 0;
}
