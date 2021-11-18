package test;

import java.util.LinkedList;
import java.util.Queue;

public class P130_SurroundRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // add O on boarder to queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (board[i][n-1] == 'O') {
                queue.add(new int[]{i, n-1});
                visited[i][n-1] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
                visited[0][i] = true;
            }
            if (board[m-1][i] == 'O') {
                queue.add(new int[]{m-1, i});
                visited[m-1][i] = true;
            }
        }

        // store all the O connect to O on the boarder
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : direction) {
                    int dirX = dir[0] + x;
                    int dirY = dir[1] + y;
                    if (dirX < m && dirX >= 0 && dirY < n && dirY >= 0 && board[dirX][dirY] == 'O'
                            && !visited[dirX][dirY]) {
                        visited[dirX][dirY] = true;
                        queue.add(new int[]{dirX, dirY});
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
