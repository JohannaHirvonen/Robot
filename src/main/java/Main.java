import java.util.Scanner;

/*
 * 1. FloorSize: input two digits, witdth and dept
 * 2. StartingPosition: input two digits (width and dept) and a direction: N, E, S, W
 * 3. Move: input a string of letters (R, L, F) for commanding the robot to turn Right, Left, or move Forward
 *      If the robot moves outside the floor: exit with error
 * 4. Report: After the string array is iterated the robot reports its position as width, dept, direction
 * 
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Robot!");
        try (Scanner scan = new Scanner(System.in)) {
            Floor floor = setup(scan);
            Position position = setStartingPoint(scan, floor);
            Report report = move(scan, position);
            System.out.println(report.toString());
        }
    }

    public static Floor setup(Scanner scan) {
        System.out.println("Please input the width and dept of your world with two numbers:");
        int width = scan.nextInt();
        int dept = scan.nextInt();
        return new Floor(width, dept);
    }

    public static Position setStartingPoint(Scanner scan, Floor floor) {
        System.out.println("Great! Now input your starting position with two numbers");
        int x = scan.nextInt();
        int y = scan.nextInt();
        floor.checkBoundaries(x, y);
        System.out.println("Input the direction you are facing (N = north, S = south, E = east, W = west): ");
        char direction = scan.next().charAt(0);
        return new Position(x, y, direction);
    }

    private static Report move(Scanner scan, Position position) {
        System.out.println("Now input a string of commands for how you want to move around");
        System.out.println("(R = turn right, L = turn left, F = move forward): ");
        String commandString = scan.next();
        position.move(commandString);
        return new Report(position);
    }
}
