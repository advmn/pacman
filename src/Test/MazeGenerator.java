package Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
    private final int[][] maze;
    private final int rows;
    private final int cols;
    private final Random random = new Random();

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMaze();
        makeRandomWallsEmpty();
    }

    private void generateMaze() {
        Stack<Point> stack = new Stack<>();
        Point current = new Point(0, 0);
        maze[current.y][current.x] = 1;

        do {
            List<Point> neighbours = getNeighbours(current);
            if (!neighbours.isEmpty()) {
                Point chosen = neighbours.get((int) (Math.random() * neighbours.size()));
                if (chosen.y == current.y) {
                    maze[current.y][Math.min(current.x, chosen.x) + 1] = 1;
                } else {
                    maze[Math.min(current.y, chosen.y) + 1][current.x] = 1;
                }

                maze[chosen.y][chosen.x] = 1;
                stack.push(current);
                current = chosen;
            } else {
                current = stack.pop();
            }
        } while (!stack.isEmpty());
    }

    private void makeRandomWallsEmpty() {
        int totalCells = rows * cols;
        double emptyCellsTarget = totalCells / 5.5;

        while (emptyCellsTarget > 0) {
            int x = random.nextInt(cols);
            int y = random.nextInt(rows);


            if (maze[y][x] == 1) {
                maze[y][x] = 0;
                emptyCellsTarget--;
            }
        }
    }

    private List<Point> getNeighbours(Point p) {
        List<Point> neighbours = new ArrayList<>();

        if (p.y > 1 && maze[p.y - 2][p.x] == 0) neighbours.add(new Point(p.x, p.y - 2));
        if (p.y < rows - 2 && maze[p.y + 2][p.x] == 0) neighbours.add(new Point(p.x, p.y + 2));
        if (p.x > 1 && maze[p.y][p.x - 2] == 0) neighbours.add(new Point(p.x - 2, p.y));
        if (p.x < cols - 2 && maze[p.y][p.x + 2] == 0) neighbours.add(new Point(p.x + 2, p.y));

        return neighbours;
    }

    public int[][] getMaze() {
        return maze;
    }
}

