/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
public class MainTest {

    private void mockScannerInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }


@Test
void testSetup() {
    mockScannerInput(String.valueOf("20 31"));
    Scanner scan = new Scanner(System.in);
    Floor actual = Main.setup(scan);
    assertEquals(20, actual.getWidth());
    assertEquals(31, actual.getDept());
}


}