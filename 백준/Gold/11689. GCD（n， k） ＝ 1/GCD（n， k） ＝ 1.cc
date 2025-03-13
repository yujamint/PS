#include <iostream>

using namespace std;

typedef long long ll;

int main() {
    ll n;
    cin >> n;

    ll answer = n;
    for (ll i = 2; i * i <= n; ++i) {
        if (n % i != 0) continue;
        answer -= answer / i;
        while (n % i == 0) n /= i;
    }
    if (n > 1) {
        answer -= answer / n;
    }
    cout << answer;
    return 0;
}