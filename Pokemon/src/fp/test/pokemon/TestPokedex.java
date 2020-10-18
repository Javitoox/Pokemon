package fp.test.pokemon;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.pokemon.FactoriaPokemons;
import fp.pokemon.Pokedex;

public class TestPokedex {
	private static final Pokedex p=FactoriaPokemons.leerPokedex("data/Pokemon.csv");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testpokemonsDeGeneracion();
//		mediaAtaqueEspecialLegendarios();
//		calculaPokemonConMasAtaqueFisicoPorGeneracion();
//		pokemonAleatorioPorTipo1();
//		numeroPokemonsSoloDeUnTipo();
//		frecuenciaPorTipo();
//		pokemonsPorGeneracion();
//		pokemonMasAtaqueEspecialDeFuegoPorGeneracion();
		mejorPokemonLegendario();

	}
	private static void testpokemonsDeGeneracion() {
		System.out.println("--------------------testpokemonsDeGeneracion-----------------------");
		System.out.println(p.pokemonsDeGeneracion(1));
	}
	private static void mediaAtaqueEspecialLegendarios() {
		System.out.println("--------------------mediaAtaqueEspecialLegendarios-----------------------");
		System.out.println(p.mediaAtaqueEspecialLegendarios());
	}
	private static void calculaPokemonConMasAtaqueFisicoPorGeneracion() {
		System.out.println("--------------------calculaPokemonConMasAtaqueFisicoPorGeneracion-----------------------");
		System.out.println(p.calculaPokemonConMasAtaqueFisicoPorGeneracion());
	}
	private static void pokemonAleatorioPorTipo1() {
		System.out.println("--------------------pokemonAleatorioPorTipo1-----------------------");
		System.out.println(p.pokemonAleatorioPorTipo1());
	}
	private static void numeroPokemonsSoloDeUnTipo() {
		System.out.println("--------------------numeroPokemonsSoloDeUnTipo-----------------------");
		System.out.println(p.numeroPokemonsSoloDeUnTipo());
	}
	private static void frecuenciaPorTipo() {
		System.out.println("--------------------frecuenciaPorTipo-----------------------");
		Stream<String> tiposStream=Stream.of("Grass","Electric","Normal","Fire","Ghost");
		List<String> tipos=tiposStream.collect(Collectors.toList());
		System.out.println(p.frecuenciaPorTipo(tipos));
	}
	private static void pokemonsPorGeneracion() {
		System.out.println("--------------------pokemonsPorGeneracion-----------------------");
		System.out.println(p.pokemonsPorGeneracion());
	}
	private static void pokemonMasAtaqueEspecialDeFuegoPorGeneracion() {
		System.out.println("--------------------pokemonMasAtaqueEspecialDeFuegoPorGeneracion-----------------------");
		System.out.println(p.pokemonMasAtaqueEspecialDeFuegoPorGeneracion());
	}
	private static void mejorPokemonLegendario() {
		System.out.println("--------------------mejorPokemonLegendario-----------------------");
		System.out.println(p.mejorPokemonLegendario());
	}

}
