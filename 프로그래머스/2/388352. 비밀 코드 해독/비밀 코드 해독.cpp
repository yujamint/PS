#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int answer = 0;
vector<vector<int>> question;
vector<int> answers;

void check(unordered_set<int>& set) {
    bool flag = true;
    for (int i = 0; i < question.size(); i++) {
        vector<int> q = question[i];
        int cnt = 0;
        for (auto &num : q) {
            if (set.find(num) != set.end()) cnt++;
        }
        if (cnt != answers[i]) {
            flag = false;
            break;
        }
    }
    
    if (flag) answer++;
}

void combination(int &n, int idx, unordered_set<int> &set) {
    if (set.size() == 5) {
        check(set);
        return;
    }
    for (int next = idx + 1; next <= n; next++) {
        set.insert(next);
        combination(n, next, set);
        set.erase(next);
    }
}

int solution(int n, vector<vector<int>> q, vector<int> ans) {
    question = q;
    answers = ans;
    unordered_set<int> set;
    combination(n, 0, set);
    return answer;
}