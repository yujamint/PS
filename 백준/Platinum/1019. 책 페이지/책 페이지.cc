#include <iostream>

using namespace std;

int digit[10];

void count(int n, int exp) {
    while (n > 0) {
        digit[n % 10] += exp;
        n /= 10;
    }
}

void calc(int A, int B) {
    int exp = 1;

    while (A <= B) {
        while (A % 10 != 0 && A <= B) {
            count(A, exp);
            A++;
        }

        if (A > B) return;

        while (B % 10 != 9 && A <= B) {
            count(B, exp);
            B--;
        }

        int diff = B / 10 - A / 10 + 1;
        for (int i = 0; i < 10; ++i) {
            digit[i] += diff * exp;
        }

        A /= 10;
        B /= 10;
        exp *= 10;
    }
}


int main() {
    int n;
    cin >> n;

    calc(1, n);
    for (int i = 0; i < 10; ++i) {
        cout << digit[i] << ' ';
    }
    return 0;
}