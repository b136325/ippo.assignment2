package ippo.assignment2.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    public void hasBackDirection() {
        assertEquals(Direction.NORTH.ordinal(), 0);
    }

    @Test
    public void hasForwardDirection() {
        assertEquals(Direction.EAST.ordinal(), 1);
    }

    @Test
    public void hasLeftDirection() {
        assertEquals(Direction.SOUTH.ordinal(), 2);
    }

    @Test
    public void hasRightDirection() {
        assertEquals(Direction.WEST.ordinal(), 3);
    }
}
