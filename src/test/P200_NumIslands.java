package test;

public class P200_NumIslands {
    public static void main(String[] args) {
        char[][] input = new char[][]
                {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(input));
    }

    public static int numIslands(char[][] grid) {
        int numIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    newIslandCheck(grid, visited, i, j);
                    numIslands ++;
                }
            }
        }
        return numIslands;
    }

    public static void newIslandCheck(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        newIslandCheck(grid, visited, i - 1, j);
        newIslandCheck(grid, visited, i + 1, j);
        newIslandCheck(grid, visited, i, j - 1);
        newIslandCheck(grid, visited, i, j + 1);
    }
}
