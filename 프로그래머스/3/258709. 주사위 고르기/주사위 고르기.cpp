#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int n, maxWin = -1;
bool visited[10];
vector<int> A, B, maxDice;
vector<vector<int>> dices;

void rollADice(int cnt, vector<int> &dice, int sum) {
    if (cnt == dice.size()) {
        A.push_back(sum);
        return;
    }
    
    for (int i = 0; i < 6; i++) {
        rollADice(cnt + 1, dice, sum + dices[dice[cnt]][i]);
    }
}

void rollBDice(int cnt, vector<int> &dice, int sum) {
    if (cnt == dice.size()) {
        B.push_back(sum);
        return;
    }
    
    for (int i = 0; i < 6; i++) {
        rollBDice(cnt + 1, dice, sum + dices[dice[cnt]][i]);
    }
}

void calcSum(vector<int> aDice) {
    // A의 조합에서 나올 수 있는 합 다 구하기 -> 6(n/2)
    A.clear();
    rollADice(0, aDice, 0);
    
    // B의 조합에서 나올 수 있는 합 다 구하기 -> 6(n/2)
    vector<int> bDice;
    set<int> sett;
    for (auto &dice : aDice) {
        sett.insert(dice) ;
    }
    for (int i = 0; i < n; i++) {
        if (sett.count(i) == 0) {
            bDice.push_back(i);
        }
    }
    
    B.clear();
    rollBDice(0, bDice, 0);
}

bool compare() {
    int aWin = 0;
    for (int i = 0; i < A.size(); i++) {
        int cnt = lower_bound(B.begin(), B.end(), A[i]) - B.begin();
        aWin += cnt;
    }
    if (maxWin < aWin) {
        maxWin = aWin;
        return true;
    }
    return false;
}

void combination(int idx, vector<int> aDice) {
    if (aDice.size() == n / 2) {
        calcSum(aDice);
        
        sort(A.begin(), A.end());
        sort(B.begin(), B.end());
        
        if (compare()) {
            maxDice = aDice;
        }
        
        return;
    }
    
    for (int i = idx + 1; i < n; i++) {
        if (visited[i]) continue;
        visited[i] = true;
        aDice.push_back(i);
        combination(i, aDice);
        aDice.pop_back();
        visited[i] = false;
    }
    
}

vector<int> solution(vector<vector<int>> dice) {
    dices = dice;
    n = dice.size();
    vector<int> aDice;
    combination(-1, aDice);
    
    for (int i = 0; i < maxDice.size(); i++) {
        maxDice[i]++;
    }
    return maxDice;
}