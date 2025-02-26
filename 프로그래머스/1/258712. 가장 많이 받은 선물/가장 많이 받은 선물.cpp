#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

/*
두 사람이 선물을 주고받은 기록이 있다면, 
    - 이번 달까지 더 많은 선물을 준 사람이 다음 달에 선물 하나 받는다.
두 사람이 선물을 주고받은 기록이 없거나 수가 같다면, 
    - 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물 하나 받는다.
    * 선물 지수: (자신이 친구들에게 준 선물의 수) - (받은 선물의 수)
    - 선물 지수도 같다면 다음 달에 선물을 주고받지 않는다.
    
선물 내역을 순회하며
1. 선물 지수 증감
2. history[][]
 */
map<string, int> giftScoreByName;
map<string, int> friendsIdx;
int history[50][50], count[50];

int solution(vector<string> friends, vector<string> gifts) {
    int n = friends.size();
    
    for (int i = 0; i < n; ++i) {
        friendsIdx.insert({friends[i], i});
    }
    
    string from, to;
    istringstream iss;
    for (auto &gift : gifts) {
        iss = istringstream(gift);
        getline(iss, from, ' ');
        getline(iss, to, ' ');
        
        if (giftScoreByName.find(from) != giftScoreByName.end()) 
            giftScoreByName[from]++;
        else
            giftScoreByName.insert({from, 1});
        
        if (giftScoreByName.find(to) != giftScoreByName.end())
            giftScoreByName[to]--;
        else 
            giftScoreByName.insert({to, -1});
        
        int fromIdx = friendsIdx[from];
        int toIdx = friendsIdx[to];
        
        history[fromIdx][toIdx]++;
        history[toIdx][fromIdx]--;
    }
    
    for (int i = 0; i < n; ++i) {
        string iName = friends[i];
        int iScore = giftScoreByName[iName];
        for (int j = 0; j < n; ++j) {
            // 선물 주고받은 기록 없거나, 같을 때
            if (history[i][j] == 0)  {
                string jName = friends[j];
                int jScore = giftScoreByName[jName];
                if (iScore > jScore) count[i]++;
            }
            // 선물 주고받은 기록 있을 때
            else {
                if (history[i][j] > history[j][i]) count[i]++;
            }
        }
    }
    
    int answer = 0;
    for (int i = 0; i < n; ++i) {
        answer = max(answer, count[i]);
    }
    
    return answer;
}