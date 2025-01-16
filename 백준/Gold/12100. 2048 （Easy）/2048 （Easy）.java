import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5번의 움직임으로 얻을 수 있는 최댓값을 구해야 한다.
움직일 방향의 선택지는 왼쪽, 오른쪽, 위, 아래 4개다.
그러므로 경우의 수는 4^5로 1,024개이다.
그렇게 크지 않은 수이기 때문에 완전 탐색을 통해 시도한다.

블록 이동 규칙
- 움직이려는 방향 쪽부터 합쳐진다.
- 위 규칙에 따라, 움직이는 방향의 끝부터 반대 방향으로 진행하며 수를 합친다.
    ex) 오른쪽으로 이동한다면 오른쪽 끝에 있는 블록부터 왼쪽 끝 블록을 확인하는 식으로 합치기
 */

public class Main {

    static int n, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        DFS(0, board);

        System.out.println(max);
    }

    private static void DFS(int cnt, int[][] board) {
        if (cnt == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        DFS(cnt + 1, moveLeft(board));
        DFS(cnt + 1, moveRight(board));
        DFS(cnt + 1, moveUp(board));
        DFS(cnt + 1, moveDown(board));
    }

    private static int[][] moveLeft(int[][] board) {
        int[][] movedBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, movedBoard[i], 0, n);
        }

        for (int row = 0; row < n; row++) {
            int lastIdx = 0;
            int lastValue = movedBoard[row][lastIdx];
            for (int col = 1; col < n; col++) {
                int cur = movedBoard[row][col];
                if (cur == 0) continue;

                if (lastValue == 0) {
                    movedBoard[row][lastIdx] = cur;
                    lastValue = cur;
                    movedBoard[row][col] = 0;
                    continue;
                }

                if (cur == lastValue) {
                    movedBoard[row][lastIdx] = lastValue + cur;
                    movedBoard[row][col] = 0;
                    lastValue = 0;
                    lastIdx++;
                }

                else  {
                    movedBoard[row][++lastIdx] = cur;
                    lastValue = cur;
                    if (lastIdx != col) movedBoard[row][col] = 0;
                }
            }
        }
        return movedBoard;
    }

    private static int[][] moveRight(int[][] board) {
        int[][] movedBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, movedBoard[i], 0, n);
        }

        for (int row = 0; row < n; row++) {
            int lastIdx = n - 1;
            int lastValue = movedBoard[row][lastIdx];
            for (int col = n - 2; col >= 0; col--) {
                int cur = movedBoard[row][col];
                if (cur == 0) continue;

                if (lastValue == 0) {
                    movedBoard[row][lastIdx] = cur;
                    lastValue = cur;
                    movedBoard[row][col] = 0;
                    continue;
                }

                if (cur == lastValue) {
                    movedBoard[row][lastIdx] = lastValue + cur;
                    movedBoard[row][col] = 0;
                    lastValue = 0;
                    lastIdx--;
                }

                else  {
                    movedBoard[row][--lastIdx] = cur;
                    lastValue = cur;
                    if (lastIdx != col) movedBoard[row][col] = 0;
                }

            }
        }
        return movedBoard;
    }

    private static int[][] moveUp(int[][] board) {
        int[][] movedBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, movedBoard[i], 0, n);
        }

        for (int col = 0; col < n; col++) {
            int lastIdx = 0;
            int lastValue = movedBoard[lastIdx][col];
            for (int row = 1; row < n; row++) {
                int cur = movedBoard[row][col];
                if (cur == 0) continue;

                if (lastValue == 0) {
                    movedBoard[lastIdx][col] = cur;
                    lastValue = cur;
                    movedBoard[row][col] = 0;
                    continue;
                }

                if (cur == lastValue) {
                    movedBoard[lastIdx][col] = lastValue + cur;
                    movedBoard[row][col] = 0;
                    lastValue = 0;
                    lastIdx++;
                }

                else  {
                    movedBoard[++lastIdx][col] = cur;
                    lastValue = cur;
                    if (lastIdx != row) movedBoard[row][col] = 0;
                }
            }
        }
        return movedBoard;
    }

    private static int[][] moveDown(int[][] board) {
        int[][] movedBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, movedBoard[i], 0, n);
        }

        for (int col = 0; col < n; col++) {
            int lastIdx = n - 1;
            int lastValue = movedBoard[lastIdx][col];
            for (int row = n - 2; row >= 0; row--) {
                int cur = movedBoard[row][col];
                if (cur == 0) continue;

                if (lastValue == 0) {
                    movedBoard[lastIdx][col] = cur;
                    lastValue = cur;
                    movedBoard[row][col] = 0;
                    continue;
                }

                if (cur == lastValue) {
                    movedBoard[lastIdx][col] = lastValue + cur;
                    movedBoard[row][col] = 0;
                    lastValue = 0;
                    lastIdx--;
                }

                else  {
                    movedBoard[--lastIdx][col] = cur;
                    lastValue = cur;
                    if (lastIdx != row) movedBoard[row][col] = 0;
                }
            }
        }
        return movedBoard;
    }
}
