package com.esprit.clientservice.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.clientservice.domain.Client;
import com.esprit.clientservice.repository.ClientRepository;


import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}
	 @Override
	    public List<Client> getAllClients() {
	        return clientRepository.findAll();
	    }
	@Override
	public Client updateClient(int id, Client newClient) {
		if (clientRepository.findById(id).isPresent()) {
			Client existingClient = clientRepository.findById(id).get();
			existingClient.setFirstName(newClient.getFirstName());
			existingClient.setLastName(newClient.getLastName());
			

			return clientRepository.save(existingClient);
		} else
			return null;
	}
	
}
