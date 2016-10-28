package br.com.tuning.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tuning.phone.entity.Product;
import br.com.tuning.phone.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(Integer id){
		return productRepository.findOne(id);
	}
	
	public Product saveProduct(Product product){
		return productRepository.save(product);
	}
	
	public void deleteProduct(Product product){
		productRepository.delete(product);
	}
	
}
