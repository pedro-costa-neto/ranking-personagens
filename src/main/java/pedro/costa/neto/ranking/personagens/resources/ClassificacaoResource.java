package pedro.costa.neto.ranking.personagens.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pedro.costa.neto.ranking.personagens.domains.Personagem;
import pedro.costa.neto.ranking.personagens.services.ClassificacaoService;

@RestController
public class ClassificacaoResource {

	@Autowired
	private ClassificacaoService servico;
	
	@GetMapping
	public ResponseEntity<List<Personagem>> listar() {
		List<Personagem> personagens = servico.obterPersonagens();
		return new ResponseEntity<>(personagens, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> salvar(
			@RequestParam(value="classificado") UUID codClassificado,
			@RequestParam(value="naoclassificado") UUID codNaoClassificado) {
		servico.classificar(codClassificado, codNaoClassificado);
		return new ResponseEntity<>("Classificado", HttpStatus.OK);
	} 
}
