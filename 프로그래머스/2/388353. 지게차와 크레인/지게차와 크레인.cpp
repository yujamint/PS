#include <string>
#include <vector>
#include <iostream>

using namespace std;

#define FOR(i, N) for (int i = 0; i < N; i++)
#define FORs(i, start, N) for (int i = start; i < N; i++)

typedef pair<int, int> pii;

int n, m;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
vector<vector<bool>> possible;

void checkPossible(vector<string> &storage, int x, int y) {
    possible[x][y] = true;
    if (storage[x][y] != '.') return;
    
    FOR (i, 4) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
        
        if (!possible[nx][ny])
            checkPossible(storage, nx, ny);
    }
}

void pick(vector<string> &storage, string &request) {
    vector<pii> targets;
    
    FOR (x, n) FOR (y, m) {
        if (storage[x][y] == '.') continue;
        if (storage[x][y] == request[0] && (possible[x][y] || request.size() > 1)) {
            storage[x][y] = '.';
            targets.push_back(make_pair(x, y));
        }
    
    }
    
    for (auto &p : targets) {
        int x = p.first, y = p.second;
        if (possible[x][y]) {
            checkPossible(storage, x, y);
        }
    }
}

int solution(vector<string> storage, vector<string> requests) {
    n = storage.size();
    m = storage[0].size();
    possible = vector<vector<bool>>(n, vector<bool>(m, false));
    FOR(i, n) FOR(j, m) 
        if (i == 0 || i == n - 1 || j == 0 || j == m -1) possible[i][j] = true;

    for (auto &request : requests) 
        pick(storage, request);
    
    int answer = 0;
    FOR(x, n) FOR(y, m) if (storage[x][y] != '.') answer++;
    
    return answer;
}