package pedro.costa.neto.ranking.personagens.domains;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Personagem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", updatable = false, unique = true, nullable = false)
	private UUID codigo;
	
	@Column(name = "nome", nullable = false, length = 35)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 150)
	private String descricao;
	
	@Column(name = "empresa", nullable = true, length = 35)
	private String empresa;
	
	@Column(name = "classificacao", nullable = false)
	private Double classificacao;
	
	public boolean isClassificado() {
		return classificacao != null;
	}
}
