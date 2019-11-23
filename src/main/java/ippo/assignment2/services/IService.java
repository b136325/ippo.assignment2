package ippo.assignment2.services;

import ippo.assignment2.models.Player;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @since 0.1.7
 */
public interface IService {
    public Player get() throws IOException;
}
