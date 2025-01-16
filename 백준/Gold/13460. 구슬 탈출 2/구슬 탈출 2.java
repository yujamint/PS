import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    char[][] board;
    int count;

    public Pair(char[][] board, int count) {
        this.board = board;
        this.count = count;
    }
}

/*
    1. 초기 상태의 게임판 Queue에 담기
    2. Queue에서 꺼내서 상하좌우로 기울이기
    3. 기울였을 때의 게임판 Queue에 담기
    4. 2~3 반복하다가 빨간 구슬만 구멍에 들어가 있으면 count 반환
        - 구멍에 빠진 구슬은 게임판에서 제거함으로써 구멍에 빠졌는지 여부 확인
        - 빨간색, 파란색 구슬이 동시에 빠지는 케이스 고려하기
        - 10번 내로 안 나오면 -1 반환
     */

public class Main {

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private static final char BLUE = 'B';
    private static final char RED = 'R';

    static int n, m;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        System.out.println(BFS(board));
    }

    private static int BFS(char[][] board) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(board, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (isBeadInHole(cur.board, BLUE)) {
                continue;
            }

            if (isBeadInHole(cur.board, RED)) {
                return cur.count;
            }

            if (cur.count == 10) {
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                char[][] nextBoard = move(cur.board, dir);
                queue.offer(new Pair(nextBoard, cur.count + 1));
            }
        }
        return -1;
    }

    private static char[][] copyOf(char[][] board) {
        char[][] copyBoard = new char[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, m);
        }
        return copyBoard;
    }

    private static boolean isBeadInHole(char[][] board, char color) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == color) {
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] move(char[][] originalBoard, int dir) {
        char[][] board = copyOf(originalBoard);
        boolean disappeared;
        switch (dir) {
            case UP:
                for (int i = 1; i < n - 1; i++) {
                    for (int j = 1; j < m - 1; j++) {
                        disappeared = false;
                        if (board[i][j] == RED || board[i][j] == BLUE) {
                            int x = i;
                            while (x > 1 && (board[x - 1][j] == '.' || board[x - 1][j] == 'O')) {
                                x--;
                                if (board[x][j] == 'O') {
                                    board[i][j] = '.';
                                    disappeared = true;
                                    break;
                                }
                            }
                            if (!disappeared && x != i) {
                                board[x][j] = board[i][j];
                                board[i][j] = '.';
                            }
                        }
                    }
                }
                break;

            case DOWN:
                for (int i = n - 2; i > 0; i--) {
                    for (int j = 1; j < m - 1; j++) {
                        disappeared = false;
                        if (board[i][j] == RED || board[i][j] == BLUE) {
                            int x = i;
                            while (x < n - 2 && (board[x + 1][j] == '.' || board[x + 1][j] == 'O')) {
                                x++;
                                if (board[x][j] == 'O') {
                                    board[i][j] = '.';
                                    disappeared = true;
                                    break;
                                }
                            }
                            if (!disappeared && x != i) {
                                board[x][j] = board[i][j];
                                board[i][j] = '.';
                            }
                        }
                    }
                }
                break;

            case LEFT:
                for (int j = 1; j < m - 1; j++) {
                    for (int i = 1; i < n - 1; i++) {
                        if (board[i][j] == RED || board[i][j] == BLUE) {
                            disappeared = false;
                            int y = j;
                            while (y > 1 && (board[i][y - 1] == '.' || board[i][y - 1] == 'O')) {
                                y--;
                                if (board[i][y] == 'O') {
                                    board[i][j] = '.';
                                    disappeared = true;
                                    break;
                                }
                            }
                            if (!disappeared && y != j) {
                                board[i][y] = board[i][j];
                                board[i][j] = '.';
                            }
                        }
                    }
                }
                break;

            case RIGHT:
                for (int j = m - 2; j > 0; j--) {
                    for (int i = 1; i < n - 1; i++) {
                        disappeared = false;
                        if (board[i][j] == RED || board[i][j] == BLUE) {
                            int y = j;
                            while (y < m - 2 && (board[i][y + 1] == '.' || board[i][y + 1] == 'O')) {
                                y++;
                                if (board[i][y] == 'O') {
                                    board[i][j] = '.';
                                    disappeared = true;
                                    break;
                                }
                            }
                            if (!disappeared && y != j) {
                                board[i][y] = board[i][j];
                                board[i][j] = '.';
                            }
                        }
                    }
                }
                break;
        }

        return board;
    }
}
