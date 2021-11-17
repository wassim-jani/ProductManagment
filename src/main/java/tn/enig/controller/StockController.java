package tn.enig.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.IGestionMagasin;
import tn.enig.dao.IGestionProduit;
import tn.enig.model.Magasin;
import tn.enig.model.Produit;



@Controller
public class StockController {

	
	@Autowired
	private IGestionMagasin magasin;
	private IGestionProduit produit;
	
	
	public void setMagasin(IGestionMagasin magasin) {
		this.magasin = magasin;
	}
	
	
	public void setProduit(IGestionProduit produit) {
		this.produit = produit;
	}

	
	@GetMapping("/home")
	public String fn1(Model m) {
		List<Magasin> allMagasin=magasin.findAll();
		List<Produit> allProduit=produit.findAll();
		m.addAttribute("listAllproduit", allProduit);
		m.addAttribute("listAllMagasin", allMagasin);
		return "home";
	}
	
	@GetMapping("/addProduct")
	public String fn2(Model m) {
		List<Magasin> allMagasin=magasin.findAll();
		Produit p=new Produit();
		m.addAttribute("Product", p);
		m.addAttribute("listAllMagasin", allMagasin);
		return"addProduct";
		
	}
	
	@PostMapping("/update")
	public String fn3(Model m,@ModelAttribute("Product") Produit prod) {
		produit.save(prod);
		return"redirect:/addProduct";
	}
	
	
	@GetMapping("/listeProduits/{id}")
	public String fn1(Model m,@PathVariable int id) {
		List<Produit> list=produit.getProduitById(id);
		m.addAttribute("listProduct", list);
		return"productList";
		
	}
	
}
