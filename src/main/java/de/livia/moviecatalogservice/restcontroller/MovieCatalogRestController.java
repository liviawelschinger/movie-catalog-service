package de.livia.moviecatalogservice.restcontroller;

import de.livia.moviecatalogservice.model.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Hardcoded (Dummy) REST API
 */
@RestController
@RequestMapping("/catalog") //when calls "/catalog", load up the class CatalogItem (resource)
public class MovieCatalogRestController {


    // http://localhost:8080/catalog/foo or http://localhost:8080/catalog/abc
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog (@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("The Devil Wears Prada", "A smart but sensible new graduate " +
                        "lands a job as an assistant to Miranda Priestly, " +
                        "the demanding editor-in-chief of a high fashion magazine.", 4)
        );

    }
}
