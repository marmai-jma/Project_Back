package com.bnpparibas.bddf.projet.media.application;

import com.bnpparibas.bddf.projet.media.domain.Category;
import com.bnpparibas.bddf.projet.media.domain.Type;
import com.bnpparibas.bddf.projet.media.domain.User;
import com.bnpparibas.bddf.projet.media.domain.UserRepository;
import com.bnpparibas.bddf.projet.media.exposition.dto.MediaLightDTO;
import com.bnpparibas.bddf.projet.media.exposition.dto.RecommendationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class RecommendationService {
    // @Autowired
    // private UserRepository userRepository;

    private RecommendationDTO reco1 = new RecommendationDTO(1,"Star Wars Episode 4 - La guerre des étoiles",Category.FILM,Type.SF,100);
    private RecommendationDTO reco2 = new RecommendationDTO(2,"Donjons et Dragons",Category.MUSIQUE,Type.ELECTRO,90);
    private RecommendationDTO reco3= new RecommendationDTO(3, "Donjons et Dragons", Category.JEU, Type.FANTASY,80);
    private RecommendationDTO reco4= new RecommendationDTO(4, "Star Wars Episode 4 - La guerre des étoiles", Category.FILM, Type.SF, 75);
    private RecommendationDTO reco5= new RecommendationDTO(5, "Equinoxe", Category.MUSIQUE, Type.ELECTRO,60);
    private RecommendationDTO reco6= new RecommendationDTO(6,"Donjons et Dragons", Category.JEU, Type.FANTASY,50);

    private List<RecommendationDTO> listReco = new ArrayList<RecommendationDTO>(){
        {
            add(reco1);
            add(reco2);
            add(reco3);
            add(reco4);
            add(reco5);
            add(reco6);
        }
    };

    // retourner une liste de reco et non de recoDTO dans version non test.
    public List<RecommendationDTO> listAll(){
        return listReco;
    }

}
