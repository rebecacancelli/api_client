package api.client.api_client.domain.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="nome")
    @NotBlank(message="Nome é obrigatório")
    @Length(message="Nome com no máximo 50 caracteres",max=50)
    String nome;

    @Column(name="cpf")
    @NotBlank(message = "CPF é obrigatório")
    @Length(message="CPF 000.000.000-00",max=14)
    @CPF
    String cpf;

    @Column(name="sexo")
    @NotBlank(message = "Sexo é obrigatório")
    @Length(message="F/M",max=1)
    String sexo;

    @Column(name="data_nascimento")
    Date data_nascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id", referencedColumnName = "id")
    Endereco endereco;
}
