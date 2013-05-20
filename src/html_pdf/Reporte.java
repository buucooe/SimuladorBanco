package html_pdf;

import com.itextpdf.text.DocumentException;


import archivo.ArchivoCuenta;
import archivo.ManejoArchivo;
import cuenta_persona_banco.Cuenta;

public class Reporte 
{
	protected String fechaInicio,fechaFin;
	protected Cuenta cuenta;
	protected ManejoArchivo archivo= new ArchivoCuenta();
	protected Boolean delimitar;
	
	public Reporte(String fechaInicio,String fechaFin,Cuenta cuenta)
	{
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.cuenta = cuenta;
		delimitar = true;
	}
	
	public Reporte(Cuenta cuenta)
	{	
		this.cuenta = cuenta;
		delimitar = false;
	}
	
	
	public void generarReporte()
	{
		try 
		{
			escribirHeader();
		} 
		catch (DocumentException e) 
		{
			System.out.println("Algo malo pasó :|");
		}
		escribirBody();
		escribirFooter();
	}
	
	protected void escribirBody()
	{	
	}
	
	protected void escribirHeader() throws DocumentException
	{	
	}
	
	protected void escribirFooter()
	{	
	}
}
