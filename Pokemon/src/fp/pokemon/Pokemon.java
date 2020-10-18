package fp.pokemon;

import fp.utiles.Checkers;
//Pokemon tiene los siguentes atributos:id,nombre,tipo1,tipo2,total,hp(salud),ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,
//generacion,legendario.Restriccion: Hp(salud),ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,generacion debe ser mayor que
// cero. Propiedad derivada: getEsPrimeraGeneracion--> calcula si un pokemon es de primera generacion. La clase calcula el 
//toString,hashCode y equals a partir del id,nombre y generacion.La clase es comparable por el siguiente orden: total,id,nombre.

public class Pokemon implements Comparable<Pokemon>{
	private Integer id;
	private String nombre,tipo1,tipo2;
	private Integer total,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,generacion;
	private Boolean legendario;
	public Pokemon(Integer id, String nombre, String tipo1, String tipo2, Integer total, Integer hp, Integer ataque,
			Integer defensa, Integer ataqueEspecial, Integer defensaEspecial, Integer velocidad, Integer generacion,
			Boolean legendario) {
		Checkers.check("Formato inválido", total>0 && hp>0 && ataque>0 && defensa>0 && ataqueEspecial>0 && defensaEspecial>0
				&& velocidad>0 && generacion>0);
		this.id = id;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.total = total;
		this.hp = hp;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.generacion = generacion;
		this.legendario = legendario;
	}
	public Boolean getEsPrimeraGeneracion() {
		Boolean result=false;
		if (this.generacion==1) {
			result=true;
		}
		return result;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTipo1() {
		return tipo1;
	}
	public String getTipo2() {
		return tipo2;
	}
	public Integer getTotal() {
		return total;
	}
	public Integer getHp() {
		return hp;
	}
	public Integer getAtaque() {
		return ataque;
	}
	public Integer getDefensa() {
		return defensa;
	}
	public Integer getAtaqueEspecial() {
		return ataqueEspecial;
	}
	public Integer getDefensaEspecial() {
		return defensaEspecial;
	}
	public Integer getVelocidad() {
		return velocidad;
	}
	public Integer getGeneracion() {
		return generacion;
	}
	public Boolean getLegendario() {
		return legendario;
	}
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", generacion=" + generacion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generacion == null) ? 0 : generacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (generacion == null) {
			if (other.generacion != null)
				return false;
		} else if (!generacion.equals(other.generacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public int compareTo(Pokemon p) {
		// TODO Auto-generated method stub
		Integer result=this.getTotal().compareTo(p.getTotal());
		if (result==0) {
			result=this.getId().compareTo(p.getId());
		}
		if (result==0) {
			result=this.getNombre().compareTo(p.getNombre());
		}
		return result;
	}
	

}
