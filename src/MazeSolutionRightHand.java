@SuppressWarnings("serial")
public class MazeSolutionRightHand {
  private static Maze m = new Maze();

  static int[][] maze;
  static int goalX, goalY;

  public static void main(String[] args) {
    int width = 20;
    int height = 20;
    goalX = width - 1;
    goalY = height - 2;
    maze = m.generateMaze(width, height);
    walk(1, 0, 1);
  }

  public static boolean wall(int x, int y) {
    return maze[x][y] == m.WALL;
  }

  public static void walk(int x, int y, int direction) {
    maze[x][y] = m.PLAYER;
    m.draw(maze);
    maze[x][y] = m.OLD_PATH_DONE;

    if (x == goalX && y == goalY) {
      return;
    }

    if (x == 1 && y == 0 && direction != 1) {
      System.out.println("There is no way out :(");
      return;
    }

    // Do we have a wall on the right hand side?
    if (direction == 0 && wall(x - 1, y) || direction == 1 && wall(x, y + 1)
        || direction == 2 && wall(x + 1, y) || direction == 3 && wall(x, y - 1)) {
      // Is there an obstacle directly in front of us?
      if (direction == 0 && wall(x, y + 1) || direction == 1 && wall(x + 1, y)
          || direction == 2 && wall(x, y - 1) || direction == 3 && wall(x - 1, y)) {
        System.out.println("There is an obstacle, turning to " + ((direction + 1) % 4));
        // We can turn counterclockwise, having the obstacle on our
        // right-hand side.
        walk(x, y, ((direction + 1) % 4));
      } else {
        // We walk straigt on
        switch (direction) {
          case 0:
            walk(x, y + 1, direction);
            break;
          case 1:
            walk(x + 1, y, direction);
            break;
          case 2:
            walk(x, y - 1, direction);
            break;
          case 3:
          default:
            walk(x - 1, y, direction);
        }
      }
    } else {
      // There is no wall on the right side, so we walk to the right side
      // and turn until we have a wall on the right side
      switch (direction) {
        case 0:
          walk(x - 1, y, (direction + 3) % 4);
          break;
        case 1:
          walk(x, y + 1, (direction + 3) % 4);
          break;
        case 2:
          walk(x + 1, y, (direction + 3) % 4);
          break;
        case 3:
        default:
          walk(x, y - 1, (direction + 3) % 4);
      }
    }
  }
}
