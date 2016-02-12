package fr.isen.steam.business.impl;

import fr.isen.steam.enumeration.TypeRevolver;
import fr.isen.steam.business.ImageResolverBusiness;
import fr.isen.steam.dao.impl.ImageRevolverDAOImpl;
import fr.isen.steam.utils.SteamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pierrezemb on 05/02/2016.
 * Implementation of ImageResolverBusiness. Will call ImageRevolverDAO
 */

@Component
public class ImageResolverBusinessImpl implements ImageResolverBusiness {

    // Logger
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Map<String, String> loadImages(TypeRevolver typeRevolver) {

        ImageRevolverDAOImpl imageResolverDaoimpl = new ImageRevolverDAOImpl();

        Map<String, byte[]> myRawMap = new HashMap();

        switch (typeRevolver) {
            case MAIN:
                myRawMap = imageResolverDaoimpl.loadImagesMain();
                break;
            case PROMO:
                myRawMap = imageResolverDaoimpl.loadImagesPromo();
                break;
            // Default will be OTHER
            default:
                throw new SteamException("Actuellement non supporté");
        }

        Map<String, String> myMap = new HashMap();

        myRawMap.forEach((k, v) ->
                myMap.put(k,getImageData(v))
        );
        return myMap;
    }

    private String getImageData(final byte[] image){
        String base64 = Base64Utils.encodeToString(image);
        base64 = "data:image/png;base64,"+base64;
        return base64;
    }
}
