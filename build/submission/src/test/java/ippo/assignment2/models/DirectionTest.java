package ippo.assignment2.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class DirectionTest {

    @Test
    private void assertTrue(String back_is_a_required_direction, boolean back) {
        assertTrue("BACK is a required Direction", Direction.valueOf("BACK").equals(1));
    }
}
