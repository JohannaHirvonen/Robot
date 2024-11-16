import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MainTest {
    private static Scanner scan;

    private void mockScannerInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        scan = new Scanner(in);
    }

    @Test
    void testSetup() {
        mockScannerInput(String.valueOf("20 31"));
        Floor actual = Main.setup(scan);
        assertEquals(20, actual.getWidth());
        assertEquals(31, actual.getDept());
    }

    @Test
    void testSetupNegativeFloorSize() {
        mockScannerInput("-2 0");
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            Main.setup(scan);
        });
        assertEquals("The floor needs to have a size bigger than zero", e.getMessage());
    }

    @Test
    void testSetStartingPoint() {
        Floor floor = new Floor(10, 10);
        mockScannerInput("0 5 N");
        Position actual = Main.setStartingPoint(scan, floor);

        assertEquals(0, actual.getX());
        assertEquals(5, actual.getY());
        assertEquals('N', actual.getDirection());
    }

    @Test
    void testSetStartingPointOutsideFloorBounds() {
        Floor floor = new Floor(10, 10);
        mockScannerInput("10 7 N");
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            Main.setStartingPoint(scan, floor);
        });
        assertEquals("You are not on the floor (current position: 10 7)", e.getMessage());
    }

    @Test
    void testSetStartingPointInvalidDirection() {
        Floor floor = new Floor(10, 10);
        mockScannerInput("0 5 G");
        Error e = assertThrows(AssertionError.class, () -> {
            Main.setStartingPoint(scan, floor);
        });
        assertEquals("G is not a valid direction.", e.getMessage());
    }

    @Test
    void testSetStartingPointSeveralDirectionCharacters() {
        Floor floor = new Floor(10, 10);
        mockScannerInput("0 5 NOWHERE");
        Position actual = Main.setStartingPoint(scan, floor);

        assertEquals(0, actual.getX());
        assertEquals(5, actual.getY());
        assertEquals('N', actual.getDirection());
    }

    @Test
    void testMove() {
        Floor mockFloor = new Floor(10, 10);
        Position mockPosition = new Position(5, 5, 'N', mockFloor);
        mockScannerInput("RFLFFLFLLLFRFF");
        Main.move(scan, mockPosition);

        assertEquals(7, mockPosition.getX());
        assertEquals(8, mockPosition.getY());
        assertEquals('E', mockPosition.getDirection());
    }

    @Test
    void testMoveOutsideFloorBounds() {
        Floor mockFloor = new Floor(2, 2);
        Position mockPosition = new Position(1, 1, 'N', mockFloor);
        mockScannerInput("RFLFF");
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            Main.move(scan, mockPosition);
        });

        assertEquals("You are not on the floor (current position: 2 1)", e.getMessage());
    }

    @AfterAll
    @SuppressWarnings("unused")
    private static void closeScanner() {
        scan.close();
    }

}