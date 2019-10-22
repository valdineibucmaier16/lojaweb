package br.edu.utfpr.pb.lojaweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "fornecedor")
@Data
@NoArgsConstructor // cria o construtor vazio pelo lombok
@AllArgsConstructor // cria o construtor com todos os parâmetros
@EqualsAndHashCode(of= {"id"})
@ToString
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cnpj;
	
	private String logradouro;
	
	private String endereco;
	
	private Long numero;
	
	private String bairro;
	
	private String cep;
	
	private String cidade;
	
	private String telefonePrincipal;
	
	private String telefoneSecundario;
	
	private String email;
	
	private String pessoaContato;
	
	
	
	
}
