package Control;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import Entidades.Artista;
import Entidades.Obra;

public class GestionObras {

	public GestionObras() {
		// TODO Auto-generated constructor stub
	}

	public void listaObras(ArrayList<Obra>listaObras, ArrayList<Artista>listaArtistas) {
		Obra obra1 = new Obra(1234567, "Arbol feliz", new GregorianCalendar(2000, 10-1, 4), 48000, "15 x 25");
		Obra obra2 = new Obra(5678910, "Arbol triste", new GregorianCalendar(2000, 5-1, 9), 73000, "25 x 25");
		
		Artista artista1 = new Artista(1029, 98765, "Camilo", "Fernandez", new GregorianCalendar(1988, 9-1, 24), 312455654);
		Artista artista2 = new Artista(3948, 65486, "Juan Fernando", "Gomez", new GregorianCalendar(1981, 2-1, 9), 210987666);
		
		obra1.agregarArtista(artista1);
		artista1.agregarObra(obra1);
		obra2.agregarArtista(artista2);
		artista2.agregarObra(obra2);
		
		listaObras.add(obra1);
		listaObras.add(obra2); 
		
		listaArtistas.add(artista1);
		listaArtistas.add(artista2);
	}
}
