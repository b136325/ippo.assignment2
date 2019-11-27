package ippo.assignment2.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    public void hasBackDirection() {
        assertEquals(Direction.BACK.ordinal(), 0);
    }

    @Test
    public void hasForwardDirection() {
        assertEquals(Direction.FORWARD.ordinal(), 2);
    }

    @Test
    public void hasLeftDirection() {
        assertEquals(Direction.LEFT.ordinal(), 3);
    }

    @Test
    public void hasRightDirection() {
        assertEquals(Direction.RIGHT.ordinal(), 5);
    }
}
