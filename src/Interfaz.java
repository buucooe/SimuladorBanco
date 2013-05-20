import java.util.Scanner;
import archivo.ManejoArchivo;
import cuenta_persona_banco.*;

public class Interfaz 
{
	protected Persona persona;
	private Debito debito;
	private Credito credito;
	private Hipoteca hipoteca;
	private Cheques cheques;
	private Banco banco;
	
	
	protected void generarMenu()
	{
		String usuario, nombre, numeroCuenta;
		Scanner leer = new Scanner(System.in);
		int opcion = 0,
			periodoMeses = 0;
		double tasaInteres;
		
		do
		{
			System.out.println("################# Banco Lobuki #################");
			System.out.println("1. Menu manejador de cuentas");
			System.out.println("2. Menu manejador de personas");
			System.out.println("3. Iniciar sesion");
			System.out.println("0. Salir");
			System.out.print("Opcion: ");
			opcion = leer.nextInt();
			
			switch(opcion)
			{
				case 1:
					do
					{
						System.out.println("1. Crear una cuenta");
						System.out.println("2. Asignar una cuenta existente a un cliente");
						System.out.println("3. Eliminar una cuenta");
						System.out.println("4. Generar reporte PDF");
						System.out.println("5. Generar reporte HTML");
						System.out.println("0. Atras");
						System.out.print("Opcion: ");
						opcion = leer.nextInt();
						
						if(opcion == 0)
						{
							break;
						}
						else
						{
							System.out.println("Numero de cliente: ");
							usuario = leer.next();
							try
							{
								persona = new Cliente();
								persona.setUsuario(usuario);
							} catch(Exception e)
							{
								System.err.println("Err: No se ha dado de alta este cliente");
								break;
							}
							
						}
						
						switch(opcion)
						{
							case 1:
								do
								{
									System.out.println("1. Debito");
									System.out.println("2. Credito");
									System.out.println("3. Hipoteca");
									System.out.println("4. Cheques");
									System.out.println("0. Atras");
									System.out.println("Opcion: ");
									opcion = leer.nextInt();
									switch(opcion)
									{
										case 1:
											debito = new Debito();
											debito.setNumeroCuenta();
											System.out.println("entre");
											persona = new Cliente();
											persona.setCuenta(debito);
											System.out.println(persona.getNumerosCuenta());
											break;
										case 2:
											credito = new Credito();
											try
											{
												banco.aprobar(credito);
											} catch(Exception e)
											{
												System.err.println("Err: Se necesitan crear empleados y gerentes");
												break;
											}
											credito.setNumeroCuenta();
											break;
										case 3:
											try
											{
												System.out.println("Periodo de la hipoteca [meses] :");
												periodoMeses = leer.nextInt();
												System.out.println("Tasa de interes");
												tasaInteres = leer.nextDouble();
												hipoteca = new Hipoteca(periodoMeses, tasaInteres);
											} catch(Exception e)
											{
												System.err.println("Utiliza numeros");
												opcion = 0;
												break;
											}
											try
											{
												banco.aprobar(hipoteca);
											} catch(Exception e)
											{
												System.err.println("Err: Se necesitan crear empleados y gerentes");
												break;
											}
											hipoteca.setNumeroCuenta();
											break;
										case 4:
											cheques = new Cheques();
											cheques.setNumeroCuenta();
											break;
									}
								} while(opcion != 0);
								opcion = 1;
							case 2:
								//No se q onda aqui, hay q ver.
								try
								{
									//persona.setCuenta(numeroCuenta);
								}
								catch(Exception e)
								{
									System.err.println("Err: Se necesitan crear empleados y gerentes");
									break;
								}
								System.out.println(persona.getNumerosCuenta());
								break;
							case 3:
								//Eliminar una cuenta
								break;
							case 4:
								//Generar reporte pdf
								break;
							case 5:
								//Generar reporte html
								break;
						}
					} while (opcion != 0);
					opcion = 1;
				case 2:
					do
					{
						System.out.println("1. Dar de alta un cliente");
						System.out.println("2. Dar de alta un gerente nivel 1");
						System.out.println("3. Dar de alta un gerente nivel 2");
						System.out.println("4. Dar de alta un empleado");
						System.out.println("5. Eliminar un usuario");
						System.out.println("0. Atras");
						opcion = leer.nextInt();
						switch(opcion)
						{
							case 1:
								persona = new Cliente();
								System.out.println("Nombre del cliente: ");
								nombre = leer.next();
								persona.setNombre(nombre);
								System.out.println("Usuario: ");
								usuario = leer.next();
								persona.setUsuario(usuario);
								break;
							case 2:
								persona = new Gerente(1);
								System.out.println("Nombre del gerente: ");
								nombre = leer.next();
								persona.setNombre(nombre);
								System.out.println("Usuario: ");
								usuario = leer.next();
								persona.setUsuario(usuario);
								break;
							case 3:
								persona = new Gerente(2);
								System.out.println("Nombre del gerente: ");
								nombre = leer.next();
								persona.setNombre(nombre);
								System.out.println("Usuario: ");
								usuario = leer.next();
								persona.setUsuario(usuario);
								break;
							case 4:
								persona = new Empleado();
								System.out.println("Nombre del empleado: ");
								nombre = leer.next();
								persona.setNombre(nombre);
								System.out.println("Usuario: ");
								usuario = leer.next();
								persona.setUsuario(usuario);
								break;
								
						}
					} while(opcion != 0);
					opcion = 1;
				case 3:
					break;
				case 4: 
					break;
				case 0:
					break;
				default:
					System.out.println("Opcion no válida");
					break;
			}
		} while(opcion != 0);
	}
	
}
