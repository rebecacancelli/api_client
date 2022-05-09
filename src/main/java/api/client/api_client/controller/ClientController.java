package api.client.api_client.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.client.api_client.domain.dto.ClientDto;
import api.client.api_client.domain.dto.ResponseDto;
import api.client.api_client.domain.entity.Client;
import api.client.api_client.domain.service.ClientService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @PostMapping //http:localhost:8080/client/
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto saveClient(@Valid @RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping(value="/list") // http:localhost:8080/client/list
    public List<ClientDto> getAllCient() {
        return clientService.getAllClientOrderByName();
    }

    @GetMapping(value = "/{id}")
    public ClientDto getUserById(@PathVariable Long id) {
    return clientService.getClientById(id);  
  }

    @PutMapping
    public ResponseDto updateClient(@Valid @RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping(value="/{id}")
    public ResponseDto deleteClient(@PathVariable Long id ) {
        return clientService.deleteClient(id);
    }







}
