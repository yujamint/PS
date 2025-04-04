#include <iostream>
#include <memory.h>

typedef long long ll;

using namespace std;

int n, k, mod, tenPow[51], modCache[15], len[15];
string arr[15];
ll cache[1 << 15][100];

// x를 k로 나눈 나머지
int rem(string x) {
    int tmp = 0;
    for (int i = 0; i < x.size(); ++i) {
        tmp *= 10;
        tmp += x[i] - '0';
        tmp %= mod;
    }
    return tmp;
}

ll solve(int status, ll v) {
    if (status == (1 << n) - 1) return v == 0;

    ll &ret = cache[status][v];
    if (ret != -1) return ret;
    ret = 0;

    for (int i = 0; i < n; ++i) {
        if (status & 1 << i) continue;
        ret += solve(status | (1 << i), (v * tenPow[len[i]] + modCache[i]) % mod);
    }
    return ret;
}

ll gcd(ll a, ll b) {
    while (a % b != 0) {
        ll temp = a;
        a = b;
        b = temp % b;
    }
    return b;
}

int main() {
    cin >> n;

    ll all = 1;
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
        all *= (i + 1);
    }

    cin >> mod;

    // 10의 거듭제곱을 k로 나눴을 때의 나머지 전처리
    tenPow[0] = 1 % mod;
    for (int i = 1; i < 51; ++i)
        tenPow[i] = (tenPow[i - 1] * 10) % mod;

    // 집합의 수를 k로 나눴을 때의 나머지 전처리
    for (int i = 0; i < n; ++i) {
        len[i] = arr[i].size();
        modCache[i] = rem(arr[i]);
    }

    memset(cache, -1, sizeof(cache));
    ll p = solve(0, 0);
    if (p == 0) cout << 0 << '/' << 1;
    else {
        ll g = gcd(p, all);
        cout << p / g << '/' << all / g;
    }

    return 0;
}