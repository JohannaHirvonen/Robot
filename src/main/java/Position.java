
public class Position {
    
    private static final String VALID_DIRECTIONS = "NESW";
    private int x;
    private int y;
    private char direction;
    private final Floor floor;

    public static char checkDirection(String input) {
        if (input.length() > 1) {
            System.out.println("Only one character valid for direction input. Choosing the first one");
        }
        String inputDirection = input.toUpperCase().substring(0, 1);
        if (!VALID_DIRECTIONS.contains(inputDirection)) {
            throw new AssertionError(inputDirection + " is not a valid direction.");
        }
        return inputDirection.charAt(0);
    }

    public Position(int x, int y, char direction, Floor floor) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.floor = floor;
    }

    public void move(String commandString) {
        for (int i = 0; i < commandString.length(); i++) {
            switch (commandString.charAt(i)) {
                case 'R' ->
                    turnRight();
                case 'L' ->
                    turnLeft();
                case 'F' ->
                    moveForward();
                default -> {
                    throw new AssertionError(commandString.charAt(i) + " is not a valid command.");
                }
            }
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N' ->
                direction = 'E';
            case 'E' ->
                direction = 'S';
            case 'S' ->
                direction = 'W';
            case 'W' ->
                direction = 'N';
            default ->
                throw new AssertionError(direction  + " is not a valid direction.");
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N' ->
                direction = 'W';
            case 'W' ->
                direction = 'S';
            case 'S' ->
                direction = 'E';
            case 'E' ->
                direction = 'N';
            default ->
            throw new AssertionError(direction  + " is not a valid direction.");
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N' ->
                y++;
            case 'E' ->
                x++;
            case 'S' ->
                y--;
            case 'W' ->
                x--;
            default ->
                throw new AssertionError(direction  + " is not a valid direction.");
        }
        floor.checkBoundaries(x, y);
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
