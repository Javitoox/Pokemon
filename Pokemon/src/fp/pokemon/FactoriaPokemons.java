package fp.pokemon;

import fp.utiles.Checkers;
//debe crear un metodo el cual atraves de una linea de fichero cree un pokemon y otro el cual a partir de un fichero cree la pokedex.
//debe intentar por cuenta la clase ficheros o si prefiere hacerlo de otra forma mejor tambien, es recomendable que lo intente usted y 
//luego mire la solucion.
import fp.utiles.Ficheros;

public class FactoriaPokemons {
	private static Pokemon parsearPokemon(String linea) {
		String [] trozos=linea.split(",");
		Checkers.check("Formato incorrecto", trozos.length==13);
		Integer id=Integer.parseInt(trozos[0].trim());
		String nombre=trozos[1].trim();
		String tipo1=trozos[2].trim();
		String tipo2=trozos[3].trim();
		Integer total=Integer.parseInt(trozos[4].trim());
		Integer hp=Integer.valueOf(trozos[5].trim());
		Integer ataque=Integer.parseInt(trozos[6].trim());
		Integer defensa=Integer.parseInt(trozos[7].trim());
		Integer ataqueEspecial=Integer.parseInt(trozos[8].trim());
		Integer defensaEspecial=Integer.parseInt(trozos[9].trim());
		Integer velocidad=Integer.parseInt(trozos[10].trim());
		Integer generacion=Integer.parseInt(trozos[11].trim());
		Boolean legendario=Boolean.parseBoolean(trozos[12].trim());
		return new Pokemon(id,nombre,tipo1,tipo2,total,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,generacion,legendario);
	}
	public static Pokedex leerPokedex(String path) {
		return new Pokedex(Ficheros.leeFichero(path).map(linea->parsearPokemon(linea)));
	}

}
