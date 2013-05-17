package archivo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import cuenta_persona_banco.Cuenta;

@SuppressWarnings("serial")
public class ManejoArchivo implements Serializable
{
	protected Cuenta cuenta;
	protected final Path path = Paths.get("C:\\Banco");
	
	protected void unLock(Cuenta cuenta)//Listo
	{
		File archivo = new File(path+"\\"+cuenta.getNumeroCuenta()+".lock");
		if(archivo.exists())
		{
			try 
			{
				Files.delete(archivo.toPath());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			System.out.println("Se borró el archivo: "+archivo.toString());
		}
	}
	
	protected Boolean lock(Cuenta cuenta)//listo
	{
		
		File archivo = new File(path+"\\"+cuenta.getNumeroCuenta()+".lock");
		if(!Files.exists(path))
		{
			try 
			{
				Files.createDirectory(path);
			}
			catch (IOException e) 
			{
			    e.printStackTrace();
			}
		}
		
		if(archivo.exists())
		{
			return false;
		}
		else
		{
			try 
			{
				Files.createFile(archivo.toPath());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			return true;
		}
	}
	
	public void escribirArchivo(Cuenta cuenta)//listo
	{
	}
	
	public Cuenta leerArchivo(Cuenta cuenta)//listo
	{
		return cuenta;
	}
}
