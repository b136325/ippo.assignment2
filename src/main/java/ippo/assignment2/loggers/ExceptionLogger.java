package ippo.assignment2.loggers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An Exception Logger class containing a 'log' method.
 *
 * @since 0.4.0
 */
public class ExceptionLogger {

    /**
     * A common method for logging exceptions.
     *
     * @param e The exception to be logged.
     *
     * @since 0.4.0
     */
    public void log(Exception e) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
    }
}
