#include <iostream>

using namespace std;

int main() {
    int T;
    cin >> T;

    int a, b;
    while (T--) {
        cin >> a >> b;

        int mod = a % 10;
        for (int i = 0; i < b - 1; ++i) {
            mod *= a;
            mod %= 10;
        }

        mod = mod == 0 ? 10 : mod;
        cout << mod << '\n';
    }
    return 0;
}