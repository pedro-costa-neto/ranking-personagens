package pedro.costa.neto.ranking.personagens.services;

import lombok.Getter;

public class RatingEloService {
	private int k = 0;
	
	@Getter
    private Double novaClassificacaoA;
	
	@Getter
    private Double novaClassificacaoB;

    public RatingEloService(int k, Double classificacaoA, Double classificacaoB, int pontuacaoA, int pontuacaoB) {
        this.k = k;

        Double novaPontuacaoA = validateScore(pontuacaoA, pontuacaoB);
        Double novaPontuacaoB = validateScore(pontuacaoB, pontuacaoA);
        
        Double pontuacaoEsperadaA = pontuacaoEsperada(classificacaoB, classificacaoA);
        novaClassificacaoA = novaClassificacao(classificacaoA, novaPontuacaoA, pontuacaoEsperadaA);

        Double pontuacaoEsperadaB = pontuacaoEsperada(classificacaoA, classificacaoB);
        novaClassificacaoB = novaClassificacao(classificacaoB, novaPontuacaoB, pontuacaoEsperadaB);
    }

    private Double pontuacaoEsperada(Double primeiroValor, Double segundoValor) {
        return 1/(1 + Math.pow(10.00, ((primeiroValor - segundoValor)/400)));
    }

    private Double novaClassificacao(Double avaliacao, Double pontuacao, Double pontuacaoEsperada) {
        return avaliacao + k * (pontuacao - pontuacaoEsperada);
    }

    private Double validateScore(int primeiroValor, int segundoValor) {
        if(primeiroValor > segundoValor) {
            return 1.0;
        } 
        else if(primeiroValor < segundoValor) {
            return 0.0;
        } 
        else {
            return 0.5;
        }
    }
}
