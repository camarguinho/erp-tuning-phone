package br.com.tuning.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tuning.phone.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
