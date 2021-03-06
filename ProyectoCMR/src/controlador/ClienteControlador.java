package controlador;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;

public class ClienteControlador {
	private List<Cliente> data;
	private String[] listOpciones = {"Agregar","Modificar","Eliminar","Buscar","Listar"};
	private String[] clienteFormulario = {"Codigo","Nombres","Apellido Paterno","Apellido Materno","Correo electr�nico","DNI","Tel�fono","Fecha Contacto"};
	
	public ClienteControlador() {
		data = new ArrayList<Cliente>();
	}
	public boolean agregar(String p_codigo, String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno,
			String p_eMail, String p_DNI, String p_telefono, String p_fechaContacto) {
		Cliente p = new Cliente();
		p.setCodigo(p_codigo);
		p.setNombres(p_nombres);
		p.setApellidoPaterno(p_apellidoPaterno);
		p.setApellidoMaterno(p_apellidoMaterno);
		p.setEMail(p_eMail);
		p.setDNI(p_DNI);
		p.setTelefono(p_telefono);
		p.setFechaContacto(p_fechaContacto);
		data.add(p);
		return true;
	}

	public boolean buscar(String p_campo, String p_valor) {
		if (p_campo.equals("nombres")) {
			for (Cliente p : data) {
				if (p.getNombres().equals(p_valor))
					return true;
			}
		}
		return false;
	}
	public boolean listar() {
		System.out.println(Cliente.cabecera());
		for (Cliente p : data) {
			System.out.println(p);
		}
		return true;
	}
	
	public void menu() {
        try
        {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String read_opcion = "";
	    int numero = 0;
		do {
			System.out.println("Instituto Benedicto XVI");
			System.out.println("=======================");
			System.out.println("Menu de Clientes\n");
			
			numero = 0;
			for (String opciones : listOpciones) {
				System.out.println(++numero + ". "+opciones);
			}
			System.out.println("0. Salir");
			System.out.println("Ingrese su opcion : ");
			read_opcion = in.readLine();
		    numero = Integer.parseInt(read_opcion);
		    numero = Integer.parseInt(read_opcion);
		    switch (numero) {
		    case 1:
		    	agregarFormulario();
		    	break;
		    case 5:
		    	listar();
		    	break;
		    case 0:
		    	break;
		    default:
		    	break;
		    }
		} while (numero != 0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	public void formulario() {
		int numero = 0;
		for (String formulario : clienteFormulario) {
			System.out.println(++numero + ". "+formulario);
		}
		System.out.println("0. Salir");
	}
	
	public void agregarFormulario() {
        try
        {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numero = 0;
		String dato = "";
		Cliente p = new Cliente();
		for (String formulario : clienteFormulario) {
			
			++numero;
			System.out.println("Ingrese " + numero + ". "+formulario+" : ");
			dato = in.readLine();
			switch (numero) {
				case 1: 
					p.setCodigo(dato);
					break;
				case 2:
					p.setNombres(dato);
					break;
				case 3:
					p.setApellidoPaterno(dato);
					break;
				case 4:
					p.setApellidoMaterno(dato);
					break;
				case 5:
					p.setEMail(dato);
					break;
				case 6:
					p.setDNI(dato);
					break;
				case 7:
					p.setTelefono(dato);
					break;
				case 8:
					p.setFechaContacto(dato);
					break;
				default:
					break;
			}
		}
		data.add(p);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

	}
}
