package br.com.tuning.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tuning.phone.entity.Supplier;
import br.com.tuning.phone.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository repository;
	
	public List<Supplier> getAllSuppliers(){
		return repository.findAll();
	}
	
	public Supplier getSupplierById(Integer id){
		return repository.getOne(id);
	}
	
	public Supplier saveSupplier(Supplier supplier){
		return repository.save(supplier);
	}
	
	public void deleteSupplier(Supplier supplier){
		repository.delete(supplier);
	}
	
}
