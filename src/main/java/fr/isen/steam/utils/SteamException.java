package fr.isen.steam.utils;

/**
 * Created by pierrezemb on 09/02/2016.
 *
 * Implementation of Runtime Exception (unchecked)
 */
public class SteamException extends RuntimeException {

    public SteamException() {
        super();
    }
    public SteamException(String s) {
        super(s);
    }
    public SteamException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public SteamException(Throwable throwable) {
        super(throwable);
    }
}
