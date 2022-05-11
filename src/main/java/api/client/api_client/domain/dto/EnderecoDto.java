package api.client.api_client.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    String cep;
    String rua;
    String bairro;
    Integer numero;
    String cidade;
    String UF;
}
