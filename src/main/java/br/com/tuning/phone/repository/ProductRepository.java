package br.com.tuning.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tuning.phone.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
