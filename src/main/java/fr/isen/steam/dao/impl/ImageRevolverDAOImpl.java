package fr.isen.steam.dao.impl;

import fr.isen.steam.dao.ImageRevolverDAO;
import fr.isen.steam.utils.SteamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pierrezemb on 05/02/2016.
 * This class is the DAO of ImageRevolver.
 * Handling File system
 */
public class ImageRevolverDAOImpl implements ImageRevolverDAO {

    /**
     * Logger
      */
    final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Path and root path
      */
   // private String rootPath = "/src/img/revolver/";
    private String rootPath = "/Users/pierrezemb/Desktop/yolo";



    // array of supported extensions
    static final String[] EXTENSIONS = new String[]{
            "gif", "png", "bmp", "jpg", "jepg" // and other formats you need
    };

    /**
     * Wrapper of loadImages from MAIN typeRevolver
     * @return results of loadImages(), see below
     */
    @Override
    public Map<String, byte[]> loadImagesMain() {
        return this.loadImages(rootPath + "/MAIN/");
    }

    /**
     * Wrapper of loadImages from PROMO typeRevolver
     * @return results of loadImages(), see below
     */
    @Override
    public Map<String, byte[]> loadImagesPromo() {
        return this.loadImages(rootPath + "/PROMO/");
    }

    /**
     * This function is crawling the right directory for images.
     * @param path of directory
     * @return Map<String, byte[]> of files. Key is name, value is content of file
     * @throws SteamException
     */
    private Map<String, byte[]> loadImages(final String path) throws SteamException {

        Map<String, byte[]> myMap = new HashMap();
        File dir = new File(String.valueOf(path));
        try {
            // Checking if there's some images
            if (dir.list(IMAGE_FILTER).length == 0){
                // Getting white image
                myMap.put("white.png", Files.readAllBytes(Paths.get(rootPath + "/white.png")));
            } else {
                for (final File f : dir.listFiles(IMAGE_FILTER)) {

                    if (logger.isDebugEnabled()) {
                        logger.debug(f.toString());
                    }
                    myMap.put(f.getName().toString(), Files.readAllBytes(Paths.get(f.toString())));

                }
            }
        } catch (IOException e){
            throw new SteamException("Error while adding file to map: ", e);
        }
        return myMap;
    }

    /**
     * filter to identify images based on their extensions
     */
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    /**
     * @return RootPath
     */
    public String getRootPath() {
        return rootPath;
    }

    /**
     * Setting path for Testing
     * @param rootPath
     */
    public void setRootPath(final String rootPath) {
        this.rootPath = rootPath;
    }
}
