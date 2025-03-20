#include <string>
#include <vector>

using namespace std;

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int sunday = 7 - startday;
    int saturday = sunday == 0 ? 6 : sunday - 1;
    int n = schedules.size();
    int answer = 0;
    for (int employee = 0; employee < n; employee++) {
        vector<int> timelog = timelogs[employee];
        int schedule = schedules[employee];
        int eventTime = schedules[employee] + 10;
        if (eventTime % 100 >= 60) eventTime += 40;
        bool flag = true;
        for (int day = 0; day < 7; day++) {
            if (day == sunday || day == saturday) continue;
            if (timelog[day] > eventTime) {
                flag = false;
                break;
            }
        }
        if (flag) answer++;
    }

    return answer;
}