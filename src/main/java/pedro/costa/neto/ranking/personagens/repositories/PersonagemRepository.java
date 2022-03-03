package pedro.costa.neto.ranking.personagens.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pedro.costa.neto.ranking.personagens.domains.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, UUID> {
	
	@Query(value = "SELECT * FROM Personagem p ORDER BY RANDOM() LIMIT :limite", nativeQuery = true)
	public List<Personagem> obterPersonagensAleatorios(@Param("limite") int limite);
	
	@Query(value = "SELECT p FROM Personagem p ORDER BY p.classificacao DESC")
	public List<Personagem> obterRanking();
}
