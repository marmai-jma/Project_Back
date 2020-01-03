package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.application.RecommendationService;
import com.bnpparibas.bddf.projet.media.exposition.dto.RecommendationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RecommendationResource {
    @Autowired
    private RecommendationService recommendationService;

        @RequestMapping(method= RequestMethod.GET, path={"/recommendations"})
        public List<RecommendationDTO> listAllRecommendations(){
            return (this.recommendationService.listAll());
        }
}
