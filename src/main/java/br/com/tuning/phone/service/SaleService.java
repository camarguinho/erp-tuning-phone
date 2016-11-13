package br.com.tuning.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tuning.phone.entity.Sale;
import br.com.tuning.phone.repository.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> getAllSales(){
		return repository.findAll();
	}
	
	public Sale getSaleById(Integer id){
		return repository.findOne(id);
	}
	
	public Sale saveSale(Sale sale){
		return repository.save(sale);
	}
	
	public void deleteSale(Sale sale){
		repository.delete(sale);
	}

}
