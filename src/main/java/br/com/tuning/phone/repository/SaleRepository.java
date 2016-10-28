package br.com.tuning.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tuning.phone.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{

}
