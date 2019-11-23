package ippo.assignment2.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    public void hasBackDirection() {
        assertEquals(DirectionModel.BACK.ordinal(), 0);
    }

    @Test
    public void hasForwardDirection() {
        assertEquals(DirectionModel.FORWARD.ordinal(), 1);
    }

    @Test
    public void hasLeftDirection() {
        assertEquals(DirectionModel.LEFT.ordinal(), 2);
    }

    @Test
    public void hasRightDirection() {
        assertEquals(DirectionModel.RIGHT.ordinal(), 3);
    }
}
