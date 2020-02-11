package com.esprit.clientservice.controller;


import com.esprit.clientservice.domain.Client;
import com.esprit.clientservice.service.ClientService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") String id,
    										@RequestBody Client client){
		return new ResponseEntity<>(clientService.updateClient(id, client), HttpStatus.OK);
	}
	

	@GetMapping()
    ResponseEntity<List<Client>> findAllProjets() {

            List<Client> clients = clientService.getAllClients();
            if (!clients.isEmpty()) {
                return ResponseEntity.ok(clients);
            }

        return ResponseEntity.notFound().build();

    }

  
  
}
