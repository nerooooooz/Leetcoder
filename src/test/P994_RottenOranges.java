package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0 = empty
 * 1 = fresh
 * 2 = rotten
 */
public class P994_RottenOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int fresh = 0;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] currentIdx = queue.poll();
                int x = currentIdx[0];
                int y = currentIdx[1];

                // then check fresh around it and add to queue
                for (int[] dir: direction) {
                    int dirX = x + dir[0];
                    int dirY = y + dir[1];
                    if (dirX < m && dirX >= 0 && dirY < n && dirY >= 0 && grid[dirX][dirY] == 1) {
                        grid[dirX][dirY] = 2;
                        fresh--;
                        queue.add(new int[]{dirX, dirY});
                    }
                }
            }
            ans++;
        }
        return fresh > 0 ? -1 : ans;
    }
}
