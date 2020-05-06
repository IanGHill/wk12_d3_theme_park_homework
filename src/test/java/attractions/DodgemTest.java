package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor littleJimmy;
    Visitor mrTall;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        littleJimmy = new Visitor(10, 124, 20);
        mrTall = new Visitor(25, 220, 50);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void canGetDefaultPrice() {
        assertEquals(4.5, dodgems.defaultPrice(), 0.1);
    }

    @Test
    public void HalfPriceForKids() {
        assertEquals(2.25, dodgems.priceFor(littleJimmy), 0.1);
    }

    @Test
    public void FullPriceForOver12s() {
        assertEquals(4.5, dodgems.priceFor(mrTall), 0.1);
    }
}
