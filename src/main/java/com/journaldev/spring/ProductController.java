package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Product;
import com.journaldev.spring.service.ProductService;

@Controller
public class ProductController {

	private ProductService productService;
	
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps){
		this.productService = ps;
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProducts());
		return "product";
	}
	
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product p){
		
		if(p.getProductId() == 0){
			this.productService.addProduct(p);
		}else{
			this.productService.updateProduct(p);
		}
		
		return "redirect:/products";
		
	}
	
	@RequestMapping("/remove/product/{id}")
    public String removeProduct(@PathVariable("id") int id){
		
        this.productService.removeProduct(id);
        return "redirect:/products";
    }
 
    @RequestMapping("/edit/product/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }
}
