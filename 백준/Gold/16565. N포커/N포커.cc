#include <iostream>
#include <memory.h>

using namespace std;

const int MOD = 10007;

int cache[53][53];

int calcComb(int n, int r) {
    if (r == 0 || r == n) return 1;

    if (r > n / 2) r = n - r;

    int &ret = cache[n][r];
    if (ret != -1) return ret;

    return ret = (calcComb(n - 1, r - 1) + calcComb(n - 1, r)) % MOD;
}

int main() {
    int n;
    cin >> n;

    memset(cache, -1, sizeof(cache));

    int res = 0;
    int fourCardCount = 1;
    while (fourCardCount * 4 <= n) {
        int comb = calcComb(13, fourCardCount) * calcComb(52 - 4 * fourCardCount, n - 4 * fourCardCount) % MOD;
        if (fourCardCount % 2 == 1) res += comb;
        else res += MOD - comb;
        res %= MOD;
        fourCardCount++;
    }

    cout << res;

    return 0;
}