package controlador;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.ArrayList;
import java.util.List;

import dominio.Roles;

public class RolesControlador {
	
	private List<Roles> data;
	private String[] listOpciones = {"Agregar","Modificar","Eliminar","Buscar","Listar"};
	private String[] grupoFormulario = {"Codigo","Descripción","Permisos"};

	
	public RolesControlador() {
		data = new ArrayList<Roles>();
	}
	public boolean agregar(String p_codigo, String p_descripcion, String p_permisos) {
		Roles r = new Roles();
		System.out.println("Codigo:" + p_codigo);
		r.setCodigo(p_codigo);
		
		System.out.println("Descripción: " + r.getDescripcion());
		r.setDescripcion(p_descripcion);

		System.out.println("Permisos:" + p_permisos);
		r.setPermisos(p_permisos);

		data.add(r);
		return true;
	}

	public boolean buscar(String p_campo, String p_valor) {
		// TODO Auto-generated method stub
		if (p_campo.equals("codigo")) {
			for (Roles r : data) {
				if (r.getCodigo().equals(p_valor))
					return true;
			}
		}
		return false;
	}

	public boolean listar() {
		System.out.println(Roles.listado());
		for (Roles r : data) {
			System.out.println(r);
		}
		return true;
	}
	public boolean validarDatosRoles(String p_codigo, String p_descripcion,String p_permisos){
		if (p_codigo == null || p_codigo.isEmpty()){
			System.out.println("Debe ingresar código de Rol");
			return false;
        }
		if (p_descripcion == null || p_descripcion.isEmpty()){
			System.out.println("Debe ingresar Descripcion del Rol");
			return false;
        }		
		if (p_permisos == null || p_permisos.isEmpty()){
			System.out.println("Debe ingresar permisos asignados al Rol");
			return false;
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
			System.out.println("Menu Roles de Usuario\n");
			
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
		    case 2:
//		    	agregarFormulario();
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
		for (String formulario : grupoFormulario) {
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
		Roles p = new Roles();
		for (String formulario : grupoFormulario) {
			
			++numero;
			System.out.println("Ingrese " + numero + ". "+formulario+" : ");
			dato = in.readLine();
			switch (numero) {
				case 1: 
					p.setCodigo(dato);
					break;
				case 2:
					p.setDescripcion(dato);
					break;
				case 3:
					p.setPermisos(dato);
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

