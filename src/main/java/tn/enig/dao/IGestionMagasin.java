package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enig.model.Magasin;
import tn.enig.model.Produit;

public interface IGestionMagasin extends JpaRepository<Magasin, Integer> {
	
	//public List<Magasin> getAllMagasin();
	//public List<Produit> getProduitByMagasin(Magasin m);
	



}
