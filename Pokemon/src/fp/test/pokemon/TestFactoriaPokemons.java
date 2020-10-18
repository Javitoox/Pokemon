package fp.test.pokemon;

import java.util.stream.Collectors;

import fp.pokemon.FactoriaPokemons;
import fp.pokemon.Pokedex;

public class TestFactoriaPokemons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFactoria();

	}
	private static void testFactoria() {
		Pokedex pokedex=FactoriaPokemons.leerPokedex("data/Pokemon.csv");
		System.out.println(pokedex.getPokemons().stream().limit(5).collect(Collectors.toList()));
	}

}
