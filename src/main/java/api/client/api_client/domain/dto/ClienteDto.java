package api.client.api_client.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    Long id;
    String nome;
    String cpf;
    String sexo;
    Date data_nascimento;
    EnderecoDto endereco;
}
