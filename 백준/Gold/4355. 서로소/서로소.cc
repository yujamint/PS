#include <iostream>

using namespace std;

int main() {
    int n;
    while (true) {
        cin >> n;
        if (n == 0) break;
        if (n == 1) {
            cout << 0 << '\n';
            continue;
        }
        int answer = n;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i != 0) continue;
            answer -= answer / i;
            while (n % i == 0) n /= i;
        }
        if (n > 1) {
            answer -= answer / n;
        }
        cout << answer << '\n';
    }

    return 0;
}