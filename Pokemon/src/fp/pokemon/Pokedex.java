package fp.pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//en esta clase debe crear un atributo llamado pokedex de tipo List<Pokemon>. Cree también un constructor a partir de stream y el metodo
//añadir pokemon. A continuacion estarán todos los métodos con sus respectivos enunciados que debe completar. Es recomendable que los haga
//sin mirar y luego mire la solución.Nunca hay una única solución.

public class Pokedex {
	private List<Pokemon> pokemons;
	public Pokedex() {
		this.pokemons=new ArrayList<>();
	}
	public Pokedex(Stream<Pokemon> st) {
		this.pokemons=st.collect(Collectors.toList());
	}
	
	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	public void añadirPokemon(Pokemon p) {
		this.pokemons.add(p);
	}
	@Override
	public String toString() {
		return "Pokedex [pokemons=" + pokemons + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pokemons == null) ? 0 : pokemons.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokedex other = (Pokedex) obj;
		if (pokemons == null) {
			if (other.pokemons != null)
				return false;
		} else if (!pokemons.equals(other.pokemons))
			return false;
		return true;
	}
	//devuelve una lista con los pokemons de la generacion pasada por parametro
	public List<Pokemon> pokemonsDeGeneracion(Integer generacion){
		return this.pokemons.stream().filter(p->p.getGeneracion().equals(generacion)).collect(Collectors.toList());
	}
	//calcula la media de ataque especial de los pokemons legendarios
	public Double mediaAtaqueEspecialLegendarios() {
		return this.pokemons.stream().filter(p->p.getLegendario()).mapToInt(p->p.getAtaqueEspecial()).average().orElse(0.0);
	}
	//calcula un diccionario en el que las claves sean las generaciones y los valores es el pokemon con mas ataque fisico
	// de cada generacion
	public Map<Integer,String> calculaPokemonConMasAtaqueFisicoPorGeneracion (){
		return this.pokemons.stream().collect(Collectors.groupingBy(Pokemon::getGeneracion,Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparing(p->p.getAtaque())),p->p.get().getNombre())));
	}
	//calcula un diccionario en el que las claves son todos los tipos(tipo1) de pokemon y por valores queremos ordenar aleatoriamente los 
	//pokemons de cada tipo para despues escojer el primero y de este pokemon queremos obtener su nombre(es decir se coje un 
	//por valor un pokemon(su nombre solo aleatoriamente)
	public Map<String,String> pokemonAleatorioPorTipo1(){
		return this.pokemons.stream().collect(Collectors.groupingBy(p->p.getTipo1(),Collectors
				.collectingAndThen(Collectors.toList(),lista->lista.stream().findAny().get().getNombre()))); 
	}
	//calcula el porcentaje de pokemons que solo tienen el tipo1, es decir, el tipo2 es una cadena vacía(debe devolver el 
	//porcentaje sobre 100)
	public Double numeroPokemonsSoloDeUnTipo() {
		Long result= this.pokemons.stream().filter(p->p.getTipo2().equals("")).count();
		return (result.doubleValue()/this.pokemons.size())*100;
	}
	//dada una lista de tipos pasada por parametro,calcule un diccionario en el que las claves son cada uno de estos tipos y su valor
	//asociado es las veces que aparece repetido como tipo1 en la pokedex(como frecuencia queremos devolver un integer)
	public Map<String,Integer> frecuenciaPorTipo(List<String> tipos){
		List<String> tiposPokedex=this.pokemons.stream().map(p->p.getTipo1()).collect(Collectors.toList());
		return tipos.stream().collect(Collectors.toMap(tipo->tipo, tipoPokedex->Collections.frequency(tiposPokedex, tipoPokedex)));
	}
	//calcula un map cuyas claves sean la generacion del y los valores los pokemons de cada generacion
	public Map<Integer,List<Pokemon>> pokemonsPorGeneracion(){
		return this.pokemons.stream().collect(Collectors.groupingBy(p->p.getGeneracion()));
	}
	//calcule un diccionario ordenado cuyas claves sean las generaciones y como valor asociado queremos
	//el ataque especial del pokemon de cada generacion con mayor ataque especial pero con la restriccion de que solo sea de tipo 
	//fuego. En el caso de que este pokemon no exista devuelve null.El SortedMap debe estar ordenado por los valores del diccionario
	//(por el ataque especial del pokemon)
	public SortedMap<Integer,Integer> pokemonMasAtaqueEspecialDeFuegoPorGeneracion(){
		Map<Integer,Integer> diccionario= this.pokemons.stream().filter(p->p.getTipo1().equals("Fire") && p.getTipo2().equals(""))
				.collect(Collectors.groupingBy(Pokemon::getGeneracion,Collectors.collectingAndThen(Collectors.maxBy(Comparator
						.comparing(p->p.getAtaqueEspecial())),p->p.orElse(null).getAtaqueEspecial())));
		SortedMap<Integer,Integer> result=new TreeMap<>(Comparator.comparing(x->diccionario.get(x)));
		result.putAll(diccionario);
		return result;
	}
	//calcula el Pokemon legendario con mayor total
	public Pokemon mejorPokemonLegendario() {
		return this.pokemons.stream().filter(p->p.getLegendario()).max(Comparator.comparing(p->p.getTotal())).orElse(null);
	}
	
	

}
