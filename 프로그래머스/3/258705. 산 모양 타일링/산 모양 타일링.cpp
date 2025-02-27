#include <string>
#include <vector>
#include <memory.h>
#include <iostream>

/*

// dp[i] = i번째부터 마지막까지 삼각형 또는 마름모로 채우는 경우의 수
// dp[k] =
    1. k번째 타일을 삼각형으로 채우기 -> 한 칸 건너뛰기
    2. k번째 타일과 k+1번째 칸을 마름모로 채우기 -> 두 칸 건너뛰기
    3. k % 2 == 1일 경우, k번째 타일과 위에 얹어진 삼각형을 마름모로 채우기 -> 한 칸 건너뛰기
*/

using namespace std;

const int MOD = 10007;
int len, cache[200001];
vector<int> top;

int tiling(int cur) {
    if (cur == len) return 1;
    
    int &ret = cache[cur];
    if (ret != -1) return ret;
    
    ret = 0;
    ret = (ret + tiling(cur + 1)) % MOD;
    if (cur % 2 == 1 && top[cur / 2]) ret = (ret + tiling(cur + 1)) % MOD;
    if (cur < len - 1) ret = (ret + tiling(cur + 2)) % MOD;
    
    return ret;
}

int solution(int n, vector<int> tops) {
    top = tops;
    len = 2 * n + 1;
    memset(cache, -1, sizeof(cache));
    int answer = tiling(0);
    return answer;
}