package archivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import cuenta_persona_banco.Cuenta;

public class ArchivoBanco extends ManejoArchivo
{
	@Override
	public void escribirArchivo(Cuenta cuenta)//listo
	{
		List<String> op = cuenta.operaciones;
		try
		{
    		String data = op.get(op.size()-1);
    		File file =new File(path+"\\banco_log.csv");

    		if(!file.exists())
    		{
    			file.createNewFile();
    		}
 
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	    bufferWritter.write(data);
    	    bufferWritter.close();
 
    	}
		catch(IOException e)
		{
    		e.printStackTrace();
    	}
		
	}
	
	@Override
	public Cuenta leerArchivo(Cuenta cuenta)//listo
	{
		Path readme = Paths.get(path+"\\banco_log.csv");
		List<String> lines;
		try 
		{
			lines = Files.readAllLines(readme, StandardCharsets.UTF_8);
			cuenta.operaciones=lines;
		} 
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
		return cuenta;
	}
	
}
