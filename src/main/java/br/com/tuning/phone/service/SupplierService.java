package br.com.tuning.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tuning.phone.entity.Supplier;
import br.com.tuning.phone.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<Supplier> getAllProducts(){
		return supplierRepository.findAll();
	}
	
	public Supplier getSupplierById(Integer id){
		return supplierRepository.getOne(id);
	}
	
	public Supplier saveSupplier(Supplier supplier){
		return supplierRepository.save(supplier);
	}
	
	public void deleteSupplier(Supplier supplier){
		supplierRepository.delete(supplier);
	}
	
}
