package fr.isen.steam.business;

import fr.isen.steam.enumeration.TypeRevolver;

import java.util.Map;

/**
 * Created by pierrezemb on 05/02/2016.
 * Interface for Business
 */
public interface ImageResolverBusiness {

    /**
     *
     * @param typeRevolver type of Data
     * @return Map of data
     */
    Map<String, String> loadImages(final TypeRevolver typeRevolver);
}
