package pedro.costa.neto.ranking.personagens.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedro.costa.neto.ranking.personagens.domains.Personagem;

@Service
public class ClassificacaoService {
	
	@Autowired
	private PersonagemService personagemService;
	
	public List<Personagem> obterPersonagens() {
		return personagemService.obterPersonagensAleatorios(2);
	}
	
	public List<Personagem> obterRanking() {
		return personagemService.obterRanking();
	}

	public void classificar(UUID codigoClassificado, UUID codigoNaoClassificado) {
		var personagemA = personagemService.buscarPorCodigo(codigoClassificado);
		var personagemB = personagemService.buscarPorCodigo(codigoNaoClassificado);
		
		var calculo = new RatingEloService(10, personagemA.getClassificacao(), personagemB.getClassificacao(), 1, 0);
		
		personagemA.setClassificacao(calculo.getNovaClassificacaoA());
		personagemB.setClassificacao(calculo.getNovaClassificacaoB());
		
		personagemService.salvarOuAtualizar(personagemA);
		personagemService.salvarOuAtualizar(personagemB);
	}
}
