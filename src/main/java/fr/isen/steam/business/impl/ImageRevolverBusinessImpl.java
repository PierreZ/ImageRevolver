package fr.isen.steam.business.impl;

import fr.isen.steam.dao.ImageRevolverDAO;
import fr.isen.steam.enumeration.TypeRevolver;
import fr.isen.steam.business.ImageResolverBusiness;
import fr.isen.steam.utils.SteamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pierrezemb on 05/02/2016.
 * Implementation of ImageResolverBusiness. Will call ImageRevolverDAO
 */

@Component
public class ImageRevolverBusinessImpl implements ImageResolverBusiness {

    /**
     * Logger
     */
    final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * DAO
     */
    @Autowired
    private ImageRevolverDAO imageResolverDAO;

    /**
     *
     * @param typeRevolver type of Data
     * @return The final map of files that will be jsonnify
     */
    @Override
    public Map<String, String> loadImages(final TypeRevolver typeRevolver) {

        System.out.println("dans load");
        Map<String, byte[]> fromDao = getDAO(typeRevolver);

        Map<String, String> myMap = new HashMap();

        fromDao.forEach((k, v) ->
                myMap.put(k, getImageData(v))
        );
        return myMap;
    }

    /**
     * Get dao from DAO
     * @param typeRevolver
     * @return map of file in byte format
     */
    public Map<String, byte[]> getDAO(final TypeRevolver typeRevolver){

        switch (typeRevolver) {
            case MAIN:
                return imageResolverDAO.loadImagesMain();
            case PROMO:
                return imageResolverDAO.loadImagesMain();
            // Default will be OTHER
            default:
                throw new SteamException("Actuellement non supporté");
        }
    }

    /**
     * @param image content of image
     * @return Return base64 content
     */
    public String getImageData(final byte[] image){
        String base64 = Base64Utils.encodeToString(image);
        base64 = "data:image/png;base64," + base64;
        return base64;
    }

    /**
     *
     * @return instance of DAO
     */
    public ImageRevolverDAO getimageResolverDAO() {
        return imageResolverDAO;
    }

    /**
     *
     * @param imageResolverDAO instance of DOA
     */
    public void setImageResolverDao(final ImageRevolverDAO imageResolverDAO) {
        this.imageResolverDAO = imageResolverDAO;
    }
}
