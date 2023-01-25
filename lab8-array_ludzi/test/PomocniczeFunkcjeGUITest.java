import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static GUI.PomocniczeFunkcjeGUI.*;
import static org.junit.jupiter.api.Assertions.*;

class PomocniczeFunkcjeGUITest {

    @Test
    void czyjestSamintTest() {
        String niesamint = "5ksdf";
        String samint = "499040";

        //gdy nie jest sama liczba
        Assertions.assertFalse(czyjestSamint(niesamint,0,10));

        //gdy sama liczba miesci sie w zakresie
        Assertions.assertTrue(czyjestSamint(samint,-10,1000000));

        //gdy liczba nie miesci sie w zakresie
        Assertions.assertFalse(czyjestSamint(samint,-10,100));
    }

    @Test
    void czyjestSamStringTest() {
        String niesamstring = "ksdf5";
        String samstring = "asdjklZAAA";

        //dla nie samego stringa
        Assertions.assertFalse(czyjestSamString(niesamstring));

        //dla samego stringa
        Assertions.assertTrue(czyjestSamString(samstring));
    }

    @Test
    void dajIntaOdStringaTest() {
        //zawsze wykonuje ta metode po sprawdzeniu ze jest sam int

        String string = "20";
        Assertions.assertEquals(20,dajIntaOdStringa(string));
    }
}