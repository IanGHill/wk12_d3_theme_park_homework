package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor littleJimmy;
    Visitor mrTall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        littleJimmy = new Visitor(10, 124, 20);
        mrTall = new Visitor(25, 220, 50);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasRating() { assertEquals(5, tobaccoStall.getRating());}

    @Test
    public void isAllowed(){ assertEquals(true, tobaccoStall.isAllowedTo(mrTall));}

    @Test
    public void isNotAllowed(){ assertEquals(false, tobaccoStall.isAllowedTo(littleJimmy));}
}
