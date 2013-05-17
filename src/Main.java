import java.util.List;

import cuenta_persona_banco.*;
import archivo.*;
public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Interfaz in = new Interfaz();
		//in.generarMenu();
		
		Cuenta c = new Debito();
		c.setNumeroCuenta("1292");
		Operacion op = new Operacion();
		Persona p = new Cliente();
		p.setNombre("Paul");
		p.setUsuario("ak");
		op.depositar(1000, c, p);
	}

}
