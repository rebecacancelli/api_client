package api.client.api_client.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import api.client.api_client.domain.dto.ClientDto;
import api.client.api_client.domain.dto.ResponseDto;
import api.client.api_client.domain.entity.Client;
import api.client.api_client.domain.enumeration.Status;
import api.client.api_client.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClientRepository clientRepository;

    public ResponseDto saveClient(Client client) {
        responseDto.setId(clientRepository.save(client).getId());
        responseDto.setMessage("Usuário incluído com sucesso...");
        responseDto.setStatus(Status.SUCESS.value());
        return responseDto;
    }

    public List<ClientDto> getAllClientOrderByName() {
        List<ClientDto> listAllClientDto = clientRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
                .map(Client -> modelMapper.map(Client, ClientDto.class))
                .collect(Collectors.toList());
        return listAllClientDto;
    }

    public ClientDto getClientById(Long id) {
        return modelMapper.map(clientRepository.findById(id).get(), ClientDto.class);

    }

    public ResponseDto updateClient(Client client) {
        
        if (client.getId() > 0 && clientRepository.existsById(client.getId())) {
            clientRepository.save(client);
            responseDto.setMessage("Usuário alterado com sucesso...");
            responseDto.setStatus(Status.SUCESS.value());
        } else {
            responseDto.setMessage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }
    
    public ResponseDto deleteClient(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clientRepository.deleteById(id);
            responseDto.setMessage("Usuário deletado com sucesso...");
            responseDto.setStatus(Status.SUCESS.value());
        } else {
            responseDto.setMessage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

}
