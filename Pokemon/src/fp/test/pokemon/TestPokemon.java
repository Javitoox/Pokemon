package fp.test.pokemon;

import fp.pokemon.Pokemon;

public class TestPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConstructor();

	}
	private static void testConstructor() {
		Pokemon pokemon=new Pokemon(1,"bulbasur","planta","planta",23,232,323,4,3,435,3443,2,false);
		System.out.println(pokemon);
	}

}
