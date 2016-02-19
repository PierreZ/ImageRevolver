package fr.isen.steam.utils;


import fr.isen.steam.business.impl.ImageRevolverBusinessImpl;
import fr.isen.steam.dao.impl.ImageRevolverDAOImpl;

import fr.isen.steam.enumeration.TypeRevolver;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import org.junit.Before;

import static org.mockito.Mockito.*;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by pierrezemb on 19/02/2016.
 * Good help over here !
 * https://springframework.guru/mocking-unit-tests-mockito/
 */

public class ImageRevolverBusinessImplTest {

    @Mock
    private ImageRevolverBusinessImpl business;

    @Autowired
    private ImageRevolverDAOImpl dao;

    private String testPath= "src/main/resources/test/revolver";
    private String EmptyTestPath= "src/main/resources/test/revolver_empty";

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);

        dao = new ImageRevolverDAOImpl();
        dao.setRootPath(testPath);

    }

    @Test
    public void testMockCreation(){
        assertNotNull(business);
    }

    @Test
    public void testMultipleImage() throws SteamException {
        HashMap<String, byte[]> daoResult = new HashMap<>();
        try {
            daoResult.put("white.png", Files.readAllBytes(Paths.get(testPath+"/white.png")));
            daoResult.put("white2.png", Files.readAllBytes(Paths.get(testPath+"/white.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        when(business.getDAO(TypeRevolver.MAIN)).thenReturn(daoResult);
        business.setImageResolverDaoimpl(dao);

        // Loading images
        business.loadImages(TypeRevolver.MAIN);

        verify(business).loadImages(TypeRevolver.MAIN);
    }

    @Test
    public void testNoimages() throws SteamException {
        HashMap<String, byte[]> daoResult = new HashMap<>();

        when(business.getDAO(TypeRevolver.MAIN)).thenReturn(daoResult);
        dao.setRootPath(EmptyTestPath);
        business.setImageResolverDaoimpl(dao);

        // Loading images
        business.loadImages(TypeRevolver.MAIN);

        verify(business).loadImages(TypeRevolver.MAIN);
    }

}

