package br.com.lnsfalsim.screenmatch;

import br.com.lnsfalsim.screenmatch.model.DadosSerie;
import br.com.lnsfalsim.screenmatch.service.ConsumoAPI;
import br.com.lnsfalsim.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ConsumoAPI consumoAPI = new ConsumoAPI();
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=e766514");

		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
