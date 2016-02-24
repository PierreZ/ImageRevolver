package fr.isen.steam.service;

import fr.isen.steam.enumeration.TypeRevolver;
import fr.isen.steam.business.ImageResolverBusiness;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import javax.inject.Inject;

/**
 * Created by pierrezemb on 05/02/2016.
 */

@RestController
@RequestMapping("/api")
public class ImageRevolverService {

    @Inject
    private ImageResolverBusiness business;

    /**
     * Endpoint for health status
     * @return
     */
    @RequestMapping("/health")
    public String health() {
        return "up";
    }

    /**
     * Endpoint for API version
     * @return
     */
    @RequestMapping("/version")
    public String version() {
        return "v1";
    }

    /**
     * Endpoint for getting images
     * @param typeRevolver
     * @return
     */
    @RequestMapping("/images/{typeRevolver}")
    public Map<String, String> getImages(@PathVariable("typeRevolver") TypeRevolver typeRevolver) {
        return this.business.loadImages(typeRevolver);
    }
}
