#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int MOD = 1000000007;

int n;
vector<int> menus;

#define FOR(i, N) for (int i = 0; i < n; i++)

long multiply2(int exp) {
    if (exp == 0) return 1;

    long half = multiply2(exp / 2);

    if (exp % 2 == 0) return half * half % MOD;
    return half * half * 2 % MOD;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    menus = vector<int>(n, 0);
    FOR(i, n) cin >> menus[i];

    sort(menus.begin(), menus.end());

    long answer = 0;
    for (int maxIdx = n - 1; maxIdx >= 0; --maxIdx) {
        long val = menus[maxIdx] % MOD;
        answer += val * (multiply2(maxIdx) - 1);
        answer %= MOD;
    }
    for (int minIdx = 0; minIdx < n; ++minIdx) {
        long val = menus[minIdx] % MOD;
        answer -= val * (multiply2(n - 1 - minIdx) - 1);
        answer = (answer + MOD) % MOD;
    }
    cout << answer;

    return 0;
}