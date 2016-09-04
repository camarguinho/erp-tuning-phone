package br.com.tuning.phone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product saveProduct(Product product){
		return productRepository.save(product);
	}
	
	public void deleteProduct(Product product){
		productRepository.delete(product);
	}
	
}
