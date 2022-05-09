package api.client.api_client.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import api.client.api_client.domain.dto.AddressDto;
import api.client.api_client.domain.dto.ResponseDto;
import api.client.api_client.domain.entity.Address;
import api.client.api_client.domain.enumeration.Status;
import api.client.api_client.domain.repository.AddressRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    AddressRepository addressRepository;

    public ResponseDto saveAddress(Address address) {
        responseDto.setId(addressRepository.save(address).getId());
        responseDto.setMessage("Usuário incluído com sucesso...");
        responseDto.setStatus(Status.SUCESS.value());
        return responseDto;
    }

    public List<AddressDto> getAllAddressOrderByCep() {
        List<AddressDto> listAllAddressDto = addressRepository.findAll(Sort.by(Sort.Direction.ASC, "cep")).stream()
                .map(Address -> modelMapper.map(Address, AddressDto.class))
                .collect(Collectors.toList());
        return listAllAddressDto;
    }

    public AddressDto getAddressById(Long id) {
        return modelMapper.map(addressRepository.findById(id).get(), AddressDto.class);
    }

    public ResponseDto updateaddress(Address address) {
        
        if (address.getId() > 0 && addressRepository.existsById(address.getId())) {
            addressRepository.save(address);
            responseDto.setMessage("Usuário alterado com sucesso...");
            responseDto.setStatus(Status.SUCESS.value());
        } else {
            responseDto.setMessage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }
    
    public ResponseDto deleteAddress(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            addressRepository.deleteById(id);
            responseDto.setMessage("Endereço deletado com sucesso...");
            responseDto.setStatus(Status.SUCESS.value());
        } else {
            responseDto.setMessage("ID do address inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

}
