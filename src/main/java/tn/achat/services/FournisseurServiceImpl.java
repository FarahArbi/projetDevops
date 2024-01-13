package tn.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.achat.entities.DetailFournisseur;
import tn.achat.entities.Fournisseur;
import tn.achat.entities.SecteurActivite;
import tn.achat.repositories.DetailFournisseurRepository;
import tn.achat.repositories.FournisseurRepository;
import tn.achat.repositories.ProduitRepository;
import tn.achat.repositories.SecteurActiviteRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		return null;
	}


	public Fournisseur addFournisseur(Fournisseur f /*Master*/) {
		return null;
	}
	
	 // private DetailFournisseur  saveDetailFournisseur(Fournisseur f){
		// DetailFournisseur df = f.getDetailFournisseur();
	//	detailFournisseurRepository.save(df);
	//	return df;
	// }

	public Fournisseur updateFournisseur(Fournisseur f) {
		return null;	}

	@Override
	public void deleteFournisseur(Long fournisseurId) {
		fournisseurRepository.deleteById(fournisseurId);

	}

	@Override
	public Fournisseur retrieveFournisseur(Long fournisseurId) {

		Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);
		return fournisseur;
	}

	@Override
	public void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur) {
		
		
	}

	

}