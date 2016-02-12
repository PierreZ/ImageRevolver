package fr.isen.steam.utils;

import fr.isen.steam.ImageRevolverApplication;
import fr.isen.steam.dao.impl.ImageRevolverDAOImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Set;


/**
 * Created by pierrezemb on 09/02/2016.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ImageRevolverDAOImpl.class)
public class ImageRevolverDAOImplTests {

    @Autowired
    ImageRevolverDAOImpl dao;

    /**
     * Should containers
     ├── MAIN
     │   ├── email-secure.png
     │   └── email.png
     └── PROMO
         └── email-unsecure.png
     */
    private final String TestPath = "/Users/pierrezemb/Desktop/test";

    @Test
    public void getImagesMAIN() throws SteamException {

        // Testing MAIN with 2 images
        dao.setRootPath(TestPath);
        Map<String, byte[]> mymap = dao.loadImagesMain();

        Set<String> keys = mymap.keySet();

        Assert.assertEquals(mymap.size(),2);

        Assert.assertTrue(keys.contains("email-secure.png"));
        Assert.assertTrue(keys.contains("email.png"));
    }
    @Test
    public void getImagesPROMO() throws SteamException {

        // Testing MAIN with 2 images
        dao.setRootPath(TestPath);
        // Testing PROMO with 1 image
        Map<String, byte[]> mymap = dao.loadImagesPromo();

        Set<String> keys = mymap.keySet();

        Assert.assertTrue(keys.contains("email-unsecure.png"));
        Assert.assertEquals(mymap.size(),1);
    }
}
