package br.edu.utfpr.pb.lojaweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "livro")
@Data
@NoArgsConstructor // cria o construtor vazio pelo lombok
@AllArgsConstructor // cria o construtor com todos os parâmetros
@EqualsAndHashCode(of= {"id"})
@ToString
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "o campo 'título' deve ser preenchido" )
	@Column(length = 254, nullable = false)
	private String titulo;	
	
	@NotEmpty(message = "o campo 'autor' deve ser preenchido" )
	@Column(length = 254, nullable = false)
	private String Autor;	
	
	
	@ManyToOne
	@JoinColumn(name = "editora_id", referencedColumnName = "id")
	private Editora editora;
	
	@ManyToOne
	@JoinColumn(name = "assunto_id", referencedColumnName = "id")
	private Assunto assunto;
	
	private String descricao;
	
	@Column(length = 1024, nullable = true)
	private String imagem;
	
	
}
