package Test;

import javax.swing.table.AbstractTableModel;
import java.util.Random;

public class GameModel extends AbstractTableModel {
    private Object[][] grid;
    private int points;
    private Random random = new Random();
    private int moveCounter1 = 0;  // Counter for first ghost
    private int moveCounter2 = 0;  // Counter for second ghost
    private int boostCounter = 0;  // Counter for boost mode

    public GameModel(int rows, int cols) {
        MazeGenerator mazeGenerator = new MazeGenerator(rows, cols);
        int[][] maze = mazeGenerator.getMaze();
        grid = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = maze[i][j] == 0 ? 0 : 1; // 1 for wall, 0 for path
            }
        }
        grid[rows / 2][cols / 2] = 2; // Initial position of Pacman
        // Spawn ghosts at random positions
        while (true) {
            int ghostRow = random.nextInt(rows);
            int ghostCol = random.nextInt(cols);
            if (grid[ghostRow][ghostCol].equals(0)) {
                grid[ghostRow][ghostCol] = 4;
                break;
            }
        }
        while (true) {
            int ghostRow = random.nextInt(rows);
            int ghostCol = random.nextInt(cols);
            if (grid[ghostRow][ghostCol].equals(0)) {
                grid[ghostRow][ghostCol] = 5;
                break;
            }
        }
        points = 0;
    }

    @Override
    public int getRowCount() {
        return grid.length;
    }

    @Override
    public int getColumnCount() {
        return grid[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return grid[rowIndex][columnIndex];
    }

    public void movePacman(int dx, int dy) {

        int pacmanRow = -1;
        int pacmanCol = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(2)) {
                    pacmanRow = i;
                    pacmanCol = j;
                    break;
                }
            }
        }
        int newPacmanRow = pacmanRow + dy;
        int newPacmanCol = pacmanCol + dx;
        if (newPacmanRow >= 0 && newPacmanRow < grid.length && newPacmanCol >= 0 && newPacmanCol < grid[0].length) {
            if (!grid[newPacmanRow][newPacmanCol].equals(1)) {
                if (grid[newPacmanRow][newPacmanCol].equals(0)) {
                    points++;
                    System.out.println("Points: " + points);
                }
                grid[pacmanRow][pacmanCol] = 3; // Path Pacman has walked on
                grid[newPacmanRow][newPacmanCol] = 2;
                fireTableDataChanged();
            }
        }
        // Check if Pacman has been caught by a ghost
        if (grid[newPacmanRow][newPacmanCol].equals(4) || grid[newPacmanRow][newPacmanCol].equals(5)) {
            System.out.println("Game over! Final score: " + points);
            System.exit(0);
        }

        // If Pacman steps on a boost point
        if (grid[newPacmanRow][newPacmanCol].equals(6)) {
            boostCounter = 5;  // Activate boost mode for 5 moves
            System.out.println("Boost activated!");
        }

        // If boost mode is on
        if (boostCounter > 0) {
            int nextPacmanRow = newPacmanRow + dy;
            int nextPacmanCol = newPacmanCol + dx;
            if (nextPacmanRow >= 0 && nextPacmanRow < grid.length && nextPacmanCol >= 0 && nextPacmanCol < grid[0].length) {
                if (!grid[nextPacmanRow][nextPacmanCol].equals(1)) {
                    if (grid[nextPacmanRow][nextPacmanCol].equals(0)) {
                        points++;
                        System.out.println("Points: " + points);
                    }
                    grid[newPacmanRow][newPacmanCol] = 3;  // Path Pacman has walked on
                    grid[nextPacmanRow][nextPacmanCol] = 2;
                    fireTableDataChanged();
                    boostCounter--;  // Decrease boost mode counter
                }
            }
        }

        moveGhost(4);
        moveGhost(5);
    }

    private void moveGhost(int ghostNumber) {
        int ghostRow = -1;
        int ghostCol = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(ghostNumber)) {
                    ghostRow = i;
                    ghostCol = j;
                    break;
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int newDirection = random.nextInt(4);
        int newGhostRow = ghostRow + directions[newDirection][0];
        int newGhostCol = ghostCol + directions[newDirection][1];
        if (newGhostRow >= 0 && newGhostRow < grid.length && newGhostCol >= 0 && newGhostCol < grid[0].length) {
            if (!grid[newGhostRow][newGhostCol].equals(1) && !grid[newGhostRow][newGhostCol].equals(4) && !grid[newGhostRow][newGhostCol].equals(5)) {
                if (ghostNumber == 4) {
                    moveCounter1++;
                    if (moveCounter1 >= 10) {
                        grid[ghostRow][ghostCol] = 6;  // Ghost leaves a boost point
                        moveCounter1 = 0;
                    } else {
                        grid[ghostRow][ghostCol] = 0;  // Ghost leaves a path
                    }
                } else if (ghostNumber == 5) {
                    moveCounter2++;
                    if (moveCounter2 >= 10) {
                        grid[ghostRow][ghostCol] = 6;  // Ghost leaves a boost point
                        moveCounter2 = 0;
                    } else {
                        grid[ghostRow][ghostCol] = 0;  // Ghost leaves a path
                    }
                }
                grid[newGhostRow][newGhostCol] = ghostNumber;
                fireTableDataChanged();
            }
        }
    }
}










