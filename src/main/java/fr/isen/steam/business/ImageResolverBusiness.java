package fr.isen.steam.business;

import fr.isen.steam.enumeration.TypeRevolver;

import java.util.Map;

/**
 * Created by pierrezemb on 05/02/2016.
 */
public interface ImageResolverBusiness {

    Map<String, String> loadImages(TypeRevolver typeRevolver);
}
