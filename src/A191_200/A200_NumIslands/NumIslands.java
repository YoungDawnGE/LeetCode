package A191_200.A200_NumIslands;

/**
 * Created by GYC
 * 2020/8/13 14:47
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class NumIslands {
    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};//下右上左
    //NB啊我自己写出来了
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if (height == 0) return 0;
        int width = grid[0].length;
        boolean[][] used = new boolean[height][width];//默认是false
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    dfs(used, grid, i, j, height-1, width-1);//这个dfs会将所有连通的1对应的used置为true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * DFS状态变量
     * @param used 是否被访问过
     * @param grid 岛屿
     * @param i 当前位置
     * @param j 当前位置
     * @param height i的上界
     * @param width j的上界
     */
    private void dfs(boolean[][] used, char[][] grid, int i, int j, int height, int width) {
        if (i > height || j > width || i<0 || j<0) return;//0边界也要考虑 之前我给忘记了
        if (grid[i][j]=='0') return;
        if (used[i][j]) return;

        //先将used[I][J]置为true，回溯的时候不用再改成false
        used[i][j] = true;

        for (int k = 0; k < DIRECTIONS.length; k++) {
            dfs(used, grid, i + DIRECTIONS[k][0], j + DIRECTIONS[k][1], height, width);
        }
    }

    public static void main(String[] args) {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}};
        System.out.println(new NumIslands().numIslands(input));
    }
}
