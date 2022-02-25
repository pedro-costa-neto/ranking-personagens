package pedro.costa.neto.ranking.personagens.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Ranking personagens")
	              .description("Ranqueamento de personagens utilizando a formula rating elo")
	              .version("v0.0.1")
	              .license(new License().name("MIT").url("https://github.com/pedro-costa-neto/ranking-personagens")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Ranking personagens documentação")
	              .url("https://github.com/pedro-costa-neto/ranking-personagens"));
	  }
}
