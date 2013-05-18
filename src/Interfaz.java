import java.util.Scanner;
import archivo.ManejoArchivo;
import cuenta_persona_banco.*;

public class Interfaz 
{
	private Scanner leer = new Scanner(System.in);
	private Cliente cliente;
	private Gerente gerente;
	private Empleado empleado;
	private Debito debito;
	private Credito credito;
	private Hipoteca hipoteca;
	private Cheques cheques;
	private int periodo;
	private double tasaInteres;
	private Banco banco;
	
	public void GenerarMenu() 
	{
		if(!this.IniciarSesion())
		{
			System.out.println("entre!");
		}
			
	}
	private	boolean IniciarSesion()
	{
		ManejoArchivo manejoArchivo = new ManejoArchivo();
		//manejoArchivo.escribirArchivo();
		System.out.println("Ingresa tu nombre de usuario: ");
		String usuario = leer.nextLine();
		return true;
	}
	
	public void generarMenu()
	{
		int tipo;
		String nombre, usuario;
		System.out.println(" ################ Banco - Lobuki ################ ");
		System.out.println("1. Registrar usuario");
		System.out.println("2. Registrar gerente");
		System.out.println("3. Registrar empleado");
		System.out.println("4. Crear cuenta");
		System.out.println("5. Iniciar sesion");
		System.out.println("Opcion: ");
		int opcion = leer.nextInt();
		
		switch(opcion)
		{
			case 1:
				System.out.println("Nombre del cliente: ");
				nombre = leer.next();
				this.cliente.setNombre(nombre);
				System.out.println("Nombre de usuario: ");
				usuario = leer.next();
				this.cliente.setUsuario(usuario);
				break;
				
			case 2:
				System.out.println("Nombre del gerente: ");
				nombre = leer.next();
				this.gerente.setNombre(nombre);
				System.out.println("Nombre de usuario: ");
				usuario = leer.next();
				this.gerente.setUsuario(usuario);
				
				break;
				
			case 3:
				System.out.println("Nombre del empleado: ");
				nombre = leer.next();
				this.empleado.setNombre(nombre);
				System.out.println("Nombre de usuario: ");
				usuario = leer.next();
				this.empleado.setUsuario(usuario);
				break;
				
			case 4:
				System.out.println("Tipo de cuenta: ");
				System.out.println("1. Debito");
				System.out.println("2. Credito");
				System.out.println("3. Hipoteca");
				System.out.println("4. Cheques");
				System.out.println("Opcion: ");
				tipo = leer.nextInt();
				switch(tipo)
				{
					case 1:
						this.debito = new Debito();
						break;
					case 2:
						this.credito = new Credito();
						banco.aprobar(this.credito);
						
						break;
					case 3:
						System.out.println("Periodo: ");
						periodo = leer.nextInt();
						tasaInteres = leer.nextDouble();
						this.hipoteca = new Hipoteca(periodo, tasaInteres);
					case 4:
						
						break;
					default:
						System.out.println("Opcion no valida");
						break;
					
				}
				break;
				
			case 5:
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
		}
	}

}
