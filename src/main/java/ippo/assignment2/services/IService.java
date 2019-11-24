package ippo.assignment2.services;

import ippo.assignment2.models.PlayerObservable;

import java.io.IOException;

/**
 * @since 0.1.7
 */
public interface IService {
    public PlayerObservable get(Boolean showImages) throws IOException;
}
