import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    Angle a = new Angle(360, 2, 3);
    Angle b = new Angle(360, 0, 0);
    Angle c = new Angle(400, 1, 2);
    Angle d = new Angle(70, 80, 2);
    Angle e = new Angle(50, 35, 70);
    Angle f = new Angle(50, 30, 20);
    double rez1 = 181820;
    double rez2 = 1296000;

    @Test
    void testEveryPath() {
        RuntimeException ex;
        //1 2.1 2.2 15 16 nemame exception za ako listata e null

        //1 2.1 2.2 3 9 10 12 16
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(List.of(a)));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));

        //1 2.1 2.2 3 9 10 11 14 2.3 2.2 15 16
        //assertEquals(rez2, SILab2.function(List.of(b)));


        //1 2.1 2.2 3 9 13 16
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(List.of(c)));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));

        //1 2.1 2.2 3 4 5 16
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(List.of(d)));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        //1 2.1 2.2 3 4 6 7 16
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(List.of(e)));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));

        //1 2.2 2.2 3 4 6 8 14 2.3 2.2 15 16
        //assertEquals(rez1, SILab2.function(List.of(f)));


    }

    @Test
    void multipleConditionsTest() {
        //(deg >= 0 && deg < 360)
        //T&&T
        //T&&F
        //F&&T
        //F&&F
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(List.of(a)));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));

        //(min < 0 || min > 59)
        //T || X
        //F || T
        //F || F
        ex= assertThrows(RuntimeException.class, () -> SILab2.function(List.of(d)));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        //(sec < 0 || sec > 59)
        //T || X
        //F || T
        //F || F
        ex= assertThrows(RuntimeException.class, () -> SILab2.function(List.of(e)));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));

        //(min == 0 && sec == 0)
        //T&&T
        //T&&F
        //F&&T
        //F&&F
        ex= assertThrows(RuntimeException.class, () -> SILab2.function(List.of(c)));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));


    }
}
