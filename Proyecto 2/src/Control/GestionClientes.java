package Control;

import java.util.ArrayList;

import Entidades.Cliente;

public class GestionClientes {

	public GestionClientes() {
		// TODO Auto-generated constructor stub
	}

	public void listaClientes(ArrayList<Cliente>listaClientes) {
		Cliente cliente1 = new Cliente(9898, 77864, "Pedro", "Arbelaez", "Calle 78 #80", 315678547);
		Cliente cliente2 = new Cliente(4563, 10870, "Ivan", "Pelaez", "Cra 7 #76", 310987908);
		
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
	}
}
