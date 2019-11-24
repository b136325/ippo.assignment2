package ippo.assignment2.services;

import ippo.assignment2.models.Player;

import java.io.IOException;

/**
 * @since 0.1.7
 */
public interface IService {
    public Player get(Boolean showImages) throws IOException;
}
