package api.client.api_client.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import api.client.api_client.domain.dto.ClienteDto;
import api.client.api_client.domain.dto.ResponseDto;
import api.client.api_client.domain.entity.Cliente;
import api.client.api_client.domain.enumeration.Status;
import api.client.api_client.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClienteRepository clienteRepository;

    public ResponseDto saveCliente(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        responseDto.setMessage("Usuário incluído com sucesso...");
        responseDto.setStatus(Status.SUCESS.value());
        return responseDto;
    }

    public List<ClienteDto> getAllClienteOrderByName() {
        List<ClienteDto> listAllClienteDto = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listAllClienteDto;
    }

    public ClienteDto getClienteById(Long id) {
        return modelMapper.map(clienteRepository.findById(id).get(), ClienteDto.class);

    }

    public ResponseDto updateCliente(Cliente cliente) {
        
        if (cliente.getId() > 0 && clienteRepository.existsById(cliente.getId())) {
            clienteRepository.save(cliente);
            responseDto.setMessage("Usuário alterado com sucesso...");
            responseDto.setStatus(Status.SUCESS.value());
        } else {
            responseDto.setMessage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }
    
    public ResponseDto deleteCliente(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clienteRepository.deleteById(id);
            responseDto.setMessage("Usuário deletado com sucesso...");
            responseDto.setStatus(Status.SUCESS.value());
        } else {
            responseDto.setMessage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

}
