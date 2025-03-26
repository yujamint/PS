#include <iostream>

using namespace std;

#define FOR(i, N) for (int i = 0; i < N; ++i)

int n, m, words[500];
double firstWord[500], nextWord[500][500], classifier[500][500];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    cin >> n >> m;
    FOR(i, n) cin >> words[i];
    FOR(i, n) cin >> firstWord[i];
    FOR(i, n) FOR(j, n) cin >> nextWord[i][j];
    FOR(i, n) FOR(j, n) cin >> classifier[i][j];


    return 0;
}

/*

2 2
Hello World

1.0 0.0

Hello 0.1 0.9
World 0.6 0.4

Hello 0.7 0.3
World 0.3 0.7

5 3
I am a boy buy

1.0 0.0 0.0 0.0 0.0

I   0.1 0.6 0.1 0.1 0.1
am  0.1 0.1 0.6 0.1 0.1
a   0.1 0.1 0.1 0.6 0.1
boy 0.2 0.2 0.2 0.2 0.2
buy 0.2 0.2 0.2 0.2 0.2

I   0.8 0.1 0.0 0.1 0.0
am  0.1 0.7 0.0 0.2 0.0
a   0.0 0.1 0.8 0.0 0.1
boy 0.0 0.0 0.0 0.5 0.5
buy 0.0 0.0 0.0 0.5 0.5

4 I am a buy
4 I I a boy
4 I am am boy

목표: 분류기의 output이 주어졌을 때, input일 확률이 가장 높은 것을 구하기


 */