package api.client.api_client.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="CEP")
    @NotBlank(message = "CEP é obrigatório")
    @Length(message="00000-000",max=9)
    String cep;

    @Column(name="rua")
    @NotBlank(message = "Rua é obrigatório")
    @Length(message="Nome da Rua",max=50)
    String rua;

    @Column(name="bairro")
    @NotBlank(message = "Bairro é obrigatório")
    @Length(message="Nome do Bairro",max=50)
    String bairro;

    @Column(name="numero")
    Integer numero;

    @Column(name="cidade")
    @NotBlank(message = "Cidade é obrigatório")
    @Length(message="Nome da Cidade",max=50)
    String cidade;
    
    @Column(name="UF")
    @NotBlank(message = "UF é obrigatório")
    @Length(message="XX",max=4)
    String uf;

    @OneToOne(mappedBy = "endereco")
    Cliente cliente;
}
