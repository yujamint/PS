#include <iostream>
#include <cstdio>
#include <unordered_map>
#include <cctype>
#include <vector>

using namespace std;

/*
1. 윷판에 존재하는 29개의 위치 표현
    - 각 위치에는 최대 4개의 말이 존재할 수 있다.
2. 윷판 이동 구현
    - 아군 말 업기
    - 상대 말 잡기
3. 윷판 출력
    - 말 없으면 '.'으로 표현
4. Map에 각 말의 위치 저장

지름길 아닌 곳을 0~20으로 표현
지름길 들어서면 다른 범위로 표현하기
ex1) 뒷밭에서 지름길 들어서면 뒷모도~날밭을 36~41로 표현
        - 41 넘으면 완주 처리
ex2) 앞밭에서 지름길 들어서면 앞모도~찔밭을 26~31로 표현
        - 밭은 28으로 표현되고, 28에 도착하게 되면 10 더하기
        - 찔밭은 31으로 표현되고, 31에 도착하게 되면 16 빼기
 */

unordered_map<char, int> piecePosition;
unordered_map< int, vector<char> > board;
int n;

int countMove(string yuts) {
    int count = 0;
    for (int i = 0; i < 4; ++i) {
        if (yuts[i] == 'F') count++;
    }
    return count == 0 ? 5 : count;
}

void init() {
    // 말 위치 초기화
    for (int i = 65; i < 69; ++i) {
        piecePosition.insert(make_pair(i, 0));
        piecePosition.insert(make_pair(i + 32, 0));
    }

    // 윷판 초기화
    for (int i = 0; i <= 41; ++i) {
        vector<char> v;
        board.insert(make_pair(i, v));
    }
}

void move(char piece, int moveCnt) {
    int pos = piecePosition[piece];

    vector<char> prevPieces = pos == 0 ? vector<char>(1, piece) : board[pos];

    board[pos].clear();

    // 앞밭일 경우
    if (pos == 5) pos = 25;
    // 뒷밭일 경우
    else if (pos == 10) pos = 35;

    pos += moveCnt;
    if (pos >= 31 && pos <= 35) pos = 15 + pos % 31;
    pos = pos == 28 ? 38 : pos;
    pos = pos == 31 ? 15 : pos;
    pos = pos == 41 ? 20 : pos;

    // 도착한 경우
    if ((pos > 20 && pos <= 25) || pos > 41)
        for (auto &p : prevPieces) piecePosition.erase(p);
    else {
        // 기존에 같이 있던 말들 함께 이동
        if (board[pos].empty()) board[pos] = prevPieces;
        else {
            // 업기 처리
            if ((isupper(piece) && isupper(board[pos][0])) || (islower(piece) && islower(board[pos][0]))) {
                for (auto &p : prevPieces) board[pos].push_back(p);
            }
            // 잡기 처리
            else {
                for (auto &p : board[pos]) piecePosition[p] = 0;
                board[pos] = prevPieces;
            }
        }
        for (auto &p : prevPieces) piecePosition[p] = pos;
    }

}

void printBoard() {
    for (int i = 10; i >= 5; --i) {
        if (i != 5)printf("%c%c----", board[i][0], board[i][1]);
        else printf("%c%c\n", board[i][0], board[i][1]);
    }
    for (int i = 10; i >= 5; --i) {
        if (i != 5)printf("%c%c    ", board[i][2], board[i][3]);
        else printf("%c%c\n", board[i][2], board[i][3]);
    }
    printf("| \\                          / |\n");
    printf("|  \\                        /  |\n");
    printf("|   \\                      /   |\n");
    printf("|    %c%c                  %c%c    |\n", board[36][0], board[36][1], board[26][0], board[26][1]);
    printf("%c%c   %c%c                  %c%c   %c%c\n", board[11][0], board[11][1], board[36][2], board[36][3], board[26][2], board[26][3], board[4][0], board[4][1]);
    printf("%c%c     \\                /     %c%c\n", board[11][2], board[11][3], board[4][2], board[4][3]);
    printf("|       \\              /       |\n");
    printf("|        \\            /        |\n");
    printf("|         %c%c        %c%c         |\n", board[37][0], board[37][1], board[27][0], board[27][1]);
    printf("|         %c%c        %c%c         |\n", board[37][2], board[37][3], board[27][2], board[27][3]);
    printf("%c%c          \\      /          %c%c\n", board[12][0], board[12][1], board[3][0], board[3][1]);
    printf("%c%c           \\    /           %c%c\n", board[12][2], board[12][3], board[3][2], board[3][3]);
    printf("|             \\  /             |\n");
    printf("|              %c%c              |\n", board[38][0], board[38][1]);
    printf("|              %c%c              |\n", board[38][2], board[38][3]);
    printf("|             /  \\             |\n");
    printf("%c%c           /    \\           %c%c\n", board[13][0], board[13][1], board[2][0], board[2][1]);
    printf("%c%c          /      \\          %c%c\n", board[13][2], board[13][3], board[2][2], board[2][3]);
    printf("|         %c%c        %c%c         |\n", board[29][0], board[29][1], board[39][0], board[39][1]);
    printf("|         %c%c        %c%c         |\n", board[29][2], board[29][3], board[39][2], board[39][3]);
    printf("|        /            \\        |\n");
    printf("|       /              \\       |\n");
    printf("%c%c     /                \\     %c%c\n", board[14][0], board[14][1], board[1][0], board[1][1]);
    printf("%c%c   %c%c                  %c%c   %c%c\n", board[14][2], board[14][3], board[30][0], board[30][1], board[40][0], board[40][1], board[1][2], board[1][3]);
    printf("|    %c%c                  %c%c    |\n", board[30][2], board[30][3], board[40][2], board[40][3]);
    printf("|   /                      \\   |\n");
    printf("|  /                        \\  |\n");
    printf("| /                          \\ |\n");
    for (int i = 15; i <= 20; ++i) {
        if (i != 20)printf("%c%c    ", board[i][0], board[i][1]);
        else printf("%c%c\n", board[i][0], board[i][1]);
    }
    for (int i = 15; i <= 20; ++i) {
        if (i != 20)printf("%c%c----", board[i][2], board[i][3]);
        else printf("%c%c\n", board[i][2], board[i][3]);
    }
}

void fillBoard() {
    for (int i = 1; i <= 41; ++i) {
        vector<char> temp(4, '.');
        if (board[i].empty()) {
            board[i] = temp;
            continue;
        }
        bool isUpper = isupper(board[i][0]);
        for (char ch : board[i]) {
            if (isUpper) temp[ch - 65] = ch;
            else temp[ch - 97] = ch;
        }
        board[i] = temp;
    }
}

int main() {
    cin >> n;

    init();

    char piece;
    string yuts;
    while (n--) {
        cin >> piece >> yuts;
        int moveCnt = countMove(yuts);
        move(piece, moveCnt);
    }
    fillBoard();
    printBoard();
    return 0;
}
