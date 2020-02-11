package com.esprit.clientservice.service;


import java.util.List;

import com.esprit.clientservice.domain.Client;


public  interface ClientService {
	Client addClient(Client client);
	List<Client> getAllClients();
    Client updateClient(String id, Client newClient) ;
   
}
