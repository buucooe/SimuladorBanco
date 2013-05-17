package archivo;

import java.io.*;
import cuenta_persona_banco.Cuenta;

@SuppressWarnings("serial")
public class ArchivoCuenta extends ManejoArchivo
{
	@SuppressWarnings("resource")
	@Override
	public void escribirArchivo(Cuenta cuenta)
	{
		try 
		{
			String filename = path+"//Cuenta-" + cuenta.getNumeroCuenta()+ ".bact";
		    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		    oos.writeObject(cuenta);
		} 
		catch (Exception e) 
		{
	        System.out.println("Ha ocurrido un error al guardar su operación:"+ e);
		}
	}
	
	@SuppressWarnings("resource")
	@Override
	public Cuenta leerArchivo(Cuenta cuenta)
	{
		Cuenta cuentaTemp=null;
		try
		{
			String filename = path+"//Cuenta-" + cuenta.getNumeroCuenta()+ ".bact";
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
			cuentaTemp = (Cuenta)ois.readObject();
		} 
		catch (Exception e) 
		{
			System.out.println("Ha ocurrido un error al leer su operación:"+ e);
		}
		return cuentaTemp;
	}
}
