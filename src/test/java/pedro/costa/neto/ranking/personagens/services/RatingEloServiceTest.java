package pedro.costa.neto.ranking.personagens.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class RatingEloServiceTest {
	
	@ParameterizedTest(name = "{index} | Nova pontuação A: {5} | Nova pontuação B: {6}")
	@CsvSource({
		"10, 1000, 1000, 1, 0, 1005, 995",
		"10, 1000, 1000, 0, 1, 995, 1005",
		"10, 1000, 1000, 1, 1, 1000, 1000"
	})
	public void validarCalculoDePontuacao(ArgumentsAccessor args) {
		var k = Integer.valueOf(args.getString(0));
		var rankingA = Double.valueOf(args.getString(1));
		var rankingB = Double.valueOf(args.getString(2));
		var pontuacaoA = Integer.valueOf(args.getString(3));
		var pontuacaoB = Integer.valueOf(args.getString(4));
		var novaPontuacaoA = Double.valueOf(args.getString(5));
		var novaPontuacaoB = Double.valueOf(args.getString(6));
		var obj = new RatingEloService(k, rankingA, rankingB, pontuacaoA, pontuacaoB);
		
		assertEquals(novaPontuacaoA, obj.getNovaClassificacaoA(), 0.001);
		assertEquals(novaPontuacaoB, obj.getNovaClassificacaoB(), 0.001);
	}
}
