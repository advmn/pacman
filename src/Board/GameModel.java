package Board;

import Buttons.GameOverMenu;

import javax.swing.table.AbstractTableModel;
import java.util.Random;
import javax.swing.SwingUtilities;

public class GameModel extends AbstractTableModel {
    private Object[][] grid;
    private int points;
    private Random random = new Random();
    private boolean boostActive;
    private int boostMoveCounter;
    private int moveCounter1;
    private int moveCounter2;

    public GameModel(int rows, int cols) {
        MazeGenerator mazeGenerator = new MazeGenerator(rows, cols);
        int[][] maze = mazeGenerator.getMaze();
        grid = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = maze[i][j] == 0 ? 0 : 1;
            }
        }

        grid[rows / 2][cols / 2] = 2;
        spawnGhosts();
        points = 0;
        boostActive = false;
        boostMoveCounter = 0;
        moveCounter1 = 0;
        moveCounter2 = 0;
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
            if (grid[newPacmanRow][newPacmanCol].equals(0)) {
                points++;
                grid[pacmanRow][pacmanCol] = 3;
                grid[newPacmanRow][newPacmanCol] = 2;
                if (isBoostActive()) {
                    int boostedPacmanRow = newPacmanRow + dy;
                    int boostedPacmanCol = newPacmanCol + dx;
                    if (boostedPacmanRow >= 0 && boostedPacmanRow < grid.length && boostedPacmanCol >= 0 && boostedPacmanCol < grid[0].length) {
                        if (grid[boostedPacmanRow][boostedPacmanCol].equals(0)) {
                            points++;
                            grid[newPacmanRow][newPacmanCol] = 3;
                            grid[boostedPacmanRow][boostedPacmanCol] = 2;
                            newPacmanRow = boostedPacmanRow;
                            newPacmanCol = boostedPacmanCol;
                        }
                    }
                    boostMoveCounter++;
                    if (boostMoveCounter >= 5) {
                        setBoostActive(false);
                        boostMoveCounter = 0;
                    }
                }
                fireTableDataChanged();
            } else if (grid[newPacmanRow][newPacmanCol].equals(3)) {
                grid[pacmanRow][pacmanCol] = 3;
                grid[newPacmanRow][newPacmanCol] = 2;
                fireTableDataChanged();
            } else if (grid[newPacmanRow][newPacmanCol].equals(6)) {
                setBoostActive(true);
                grid[pacmanRow][pacmanCol] = 3;
                grid[newPacmanRow][newPacmanCol] = 2;
                fireTableDataChanged();
            } else if (grid[newPacmanRow][newPacmanCol].equals(4) || grid[newPacmanRow][newPacmanCol].equals(5)) {
                endGame();
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
                if (grid[newGhostRow][newGhostCol].equals(2)) {
                    endGame();
                } else {
                    if (ghostNumber == 4) {
                        moveCounter1++;
                        if (moveCounter1 >= 10) {
                            grid[ghostRow][ghostCol] = grid[ghostRow][ghostCol].equals(3) ? 3 : 6;
                            moveCounter1 = 0;
                        } else {
                            grid[ghostRow][ghostCol] = grid[ghostRow][ghostCol].equals(3) ? 3 : 0;
                        }
                    } else if (ghostNumber == 5) {
                        moveCounter2++;
                        if (moveCounter2 >= 10) {
                            grid[ghostRow][ghostCol] = grid[ghostRow][ghostCol].equals(3) ? 3 : 6;
                            moveCounter2 = 0;
                        } else {
                            grid[ghostRow][ghostCol] = grid[ghostRow][ghostCol].equals(3) ? 3 : 0;
                        }
                    }
                    grid[newGhostRow][newGhostCol] = ghostNumber;
                    fireTableDataChanged();
                }
            }
        }
    }

    private void spawnGhosts() {
        for (int i = 0; i < 2; i++) {
            int row, col;
            do {
                row = random.nextInt(grid.length);
                col = random.nextInt(grid[0].length);
            } while (grid[row][col].equals(1) || grid[row][col].equals(2));
            grid[row][col] = i + 4;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        grid[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public boolean isBoostActive() {
        return boostActive;
    }

    public void setBoostActive(boolean boostActive) {
        this.boostActive = boostActive;
    }

    private void endGame() {
        System.out.println("Game Over! Your score: " + points);

        SwingUtilities.invokeLater(() -> {
            GameOverMenu gameOverMenu = new GameOverMenu(points);
            gameOverMenu.setVisible(true);
        });
    }

    public int getPoints() {
        return points;
    }
}



