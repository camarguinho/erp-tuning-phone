package br.com.tuning.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tuning.phone.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
