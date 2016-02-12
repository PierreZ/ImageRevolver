package fr.isen.steam.dao;

import java.util.Map;

/**
 * Created by pierrezemb on 05/02/2016.
 * Interface for DAO. Implemention is in impl package
 */
public interface ImageRevolverDAO {

    Map<String, byte[]> loadImagesMain();
    Map<String, byte[]> loadImagesPromo();
}
