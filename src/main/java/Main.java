import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
        System.out.println("Hello Robot!");
        Floor floor = setup(scan);
        Position position = setStartingPoint(scan, floor);
        move(scan, position);
        Report report = new Report(position);
        System.out.println(report.toString());
        }
    }

    public static Floor setup(Scanner scan) throws InputMismatchException {
        try {
            System.out.println("Input the width and dept of your world with two numbers:");
            int width = scan.nextInt();
            int dept = scan.nextInt();
            return new Floor(width, dept);
        } catch(InputMismatchException e) {
            throw new InputMismatchException("Floor size parameters have to be numerals.");
        }
    }

    public static Position setStartingPoint(Scanner scan, Floor floor) {
            System.out.println("Input your starting position with two numbers");
            int x = scan.nextInt();
            int y = scan.nextInt();
            floor.checkBoundaries(x, y);
            System.out.println("Input the direction you are facing (N = north, S = south, E = east, W = west): ");
            char direction = Position.checkDirection(scan.next());
            return new Position(x, y, direction, floor);
    }

    public static void move(Scanner scan, Position position) {
            System.out.println("Input a string of commands for how you want to move around");
            System.out.println("(R = turn right, L = turn left, F = move forward): ");
            String commandString = scan.next();
            position.move(commandString);
    }
}
