#include <iostream>
#include <cmath>

using namespace std;

typedef long long ll;

int L, U;

ll calc(int n) {
    ll ret;

    if (n < 10) {
        ret = 0;
        for (int i = 1; i <= n; ++i) ret += i;
        return ret;
    }

    int first = n;
    int ct = 0;
    ret = 0;

    while (first > 9) {
        first /= 10;
        ct++;
    }
    ll k = calc(pow(10, ct) - 1);

    for (int i = 0; i < first; ++i) {
        ret += i * pow(10, ct) + k;
    }

    int other = n - first * pow(10, ct);
    ret += (calc(other) + (other + 1) * first);

    return ret;
}

int main() {
    cin >> L >> U;
    cout << calc(U) - calc(L - 1);
}

