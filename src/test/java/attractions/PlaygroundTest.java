package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor littleJimmy;
    Visitor mrTall;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        littleJimmy = new Visitor(10, 124, 20);
        mrTall = new Visitor(25, 220, 50);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void isAllowed(){ assertEquals(true, playground.isAllowedTo(littleJimmy));}

    @Test
    public void isNotAllowed(){ assertEquals(false, playground.isAllowedTo(mrTall));}
}
