package br.com.tuning.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tuning.phone.entity.Product;
import br.com.tuning.phone.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(Integer id){
		return repository.findOne(id);
	}
	
	public Product saveProduct(Product product){
		return repository.save(product);
	}
	
	public void deleteProduct(Product product){
		repository.delete(product);
	}
	
}
