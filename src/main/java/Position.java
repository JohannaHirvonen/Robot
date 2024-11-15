


public class Position {

    private int x;
    private int y;
    private char direction;

    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move(String commandString) {
        for (int i = 0; i < commandString.length(); i++) {
            switch (commandString.charAt(i)) {
                case 'R' -> turnRight();
                case 'L' -> turnLeft();
                case 'F' -> moveForward();
                default -> {
                    System.out.println(commandString.charAt(i));
                    throw new AssertionError();
                }
            }
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N' -> direction = 'E';
            case 'E' -> direction = 'S';
            case 'S' -> direction = 'W';
            case 'W' -> direction = 'N';
            default -> throw new AssertionError();
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N' -> direction = 'W';
            case 'W' -> direction = 'S';
            case 'S' -> direction = 'E';
            case 'E' -> direction = 'N';
            default -> throw new AssertionError();
        }    
    }

    private void moveForward() {
        switch (direction) {
            case 'N' -> y++;
            case 'E' -> x++;
            case 'S' -> y--;
            case 'W' -> x--;
            default -> throw new AssertionError();
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public char getDirection() {
        return direction;
    }
}
