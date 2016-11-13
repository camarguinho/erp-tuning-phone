package br.com.tuning.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tuning.phone.entity.Client;
import br.com.tuning.phone.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> getAllClients(){
		return repository.findAll();
	}
	
	public Client getClientById(Integer id){
		return repository.findOne(id);
	}
	
	public Client saveClient(Client client){
		return repository.save(client);
	}
	
	public void deleteClient(Client client){
		repository.delete(client);
	}

}
