package pedro.costa.neto.ranking.personagens.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedro.costa.neto.ranking.personagens.domains.Personagem;
import pedro.costa.neto.ranking.personagens.repositories.PersonagemRepository;

@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemRepository repositorio;
	
	public List<Personagem> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Personagem buscarPorCodigo(UUID codigo) {
		return repositorio.findById(codigo).get();
	}
	
	public List<Personagem> obterPersonagensAleatorios(int limite) {
		return repositorio.obterPersonagensAleatorios(limite);
	}
	
	public void salvarOuAtualizar(Personagem obj) {
		repositorio.save(obj);
	}
	
	public void excluir(UUID codigo) {
		Personagem obj = repositorio.findById(codigo).get();
		repositorio.delete(obj);
	}
}
