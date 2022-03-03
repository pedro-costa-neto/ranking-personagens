package pedro.costa.neto.ranking.personagens.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pedro.costa.neto.ranking.personagens.domains.Personagem;
import pedro.costa.neto.ranking.personagens.services.PersonagemService;

@RestController
public class PersonagemResource {

	@Autowired
	private PersonagemService servico;
	
	@GetMapping(value = "/personagem/todos")
	public ResponseEntity<List<Personagem>> listar() {
		List<Personagem> personagens = servico.buscarTodos();
		return new ResponseEntity<>(personagens, HttpStatus.OK);
	}
	
	@PostMapping(value = "/personagem")
	public ResponseEntity<String> salvar(@RequestBody Personagem obj) {
		servico.salvarOuAtualizar(obj);
		return new ResponseEntity<>("Personagem salvo!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/personagem/{codigo}")
	public ResponseEntity<String> atualizar(@PathVariable UUID codigo, @RequestBody Personagem obj) {
		obj.setCodigo(codigo);
		servico.salvarOuAtualizar(obj);
		return new ResponseEntity<>("Personagem atualizado!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/personagem/{codigo}")
	public ResponseEntity<String> excluir(@PathVariable UUID codigo) {
		servico.excluir(codigo);
		return new ResponseEntity<>("Personagem excluido!", HttpStatus.OK);
	}
}
