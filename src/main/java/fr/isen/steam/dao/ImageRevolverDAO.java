package fr.isen.steam.dao;

import java.util.Map;

/**
 * Created by pierrezemb on 05/02/2016.
 * Interface for DAO. Implemention is in impl package
 */
public interface ImageRevolverDAO {

    /**
     * Loin images from MAIN
     * @return map of files
     */
    Map<String, byte[]> loadImagesMain();

    /**
     * Load images from Promo
     * @return map of files
     */
    Map<String, byte[]> loadImagesPromo();
}
