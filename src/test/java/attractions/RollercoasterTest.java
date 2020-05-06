package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor littleJimmy;
    Visitor mrTall;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        littleJimmy = new Visitor(10, 124, 20);
        mrTall = new Visitor(25, 220, 50);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGetDefaultPrice() {
        assertEquals(8.4, rollerCoaster.defaultPrice(), 0.1);
    }

    @Test
    public void normalPriceForNormalHeight() {
        assertEquals(8.4, rollerCoaster.priceFor(littleJimmy), 0.1);
    }

    @Test
    public void doublePriceForOver200s() {
        assertEquals(16.80, rollerCoaster.priceFor(mrTall), 0.1);
    }

    @Test
    public void isAllowed(){ assertEquals(true, rollerCoaster.isAllowedTo(mrTall));}

    @Test
    public void isNotAllowed(){ assertEquals(false, rollerCoaster.isAllowedTo(littleJimmy));}
}
