#include <string>
#include <vector>
#include <queue>
#include <iostream>

typedef long long ll;

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {    
    int n = queue1.size() + queue2.size();
    
    queue<int> q1, q2;
    ll sum1 = 0, sum2 = 0;
    for (auto &num : queue1) {
        sum1 += num;
        q1.push(num);
    }
    for (auto &num : queue2) {
        sum2 += num;
        q2.push(num);
    }
    ll total = sum1 + sum2;
    
    if (total % 2 == 1)
        return -1;
    
    int cnt = 0;
    while (!q1.empty() && !q2.empty() && cnt < 3 * n) {
        if (sum1 > sum2) {
            int num = q1.front();
            q1.pop();
            q2.push(num);
            
            sum1 -= num;
            sum2 += num;
        }
        
        else if (sum1 < sum2) {
            int num = q2.front();
            q2.pop();
            q1.push(num);
            
            sum1 += num;
            sum2 -= num;
        }
        
        else {
            return cnt;
        }
        
        cnt++;
    }
    
    return -1;
}