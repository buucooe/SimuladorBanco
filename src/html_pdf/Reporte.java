package html_pdf;

import java.util.Date;

import com.itextpdf.text.DocumentException;


import archivo.ArchivoCuenta;
import archivo.ManejoArchivo;
import cuenta_persona_banco.Cuenta;

public class Reporte 
{
	protected Date fechaInicio,fechaFin;
	protected Cuenta cuenta,cuentaTemp;
	protected ManejoArchivo archivo= new ArchivoCuenta();
	protected Boolean delimitar;
	
	public Reporte(Date fechaInicio,Date fechaFin,Cuenta cuenta)//listo
	{
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.cuenta = cuenta;
		delimitar = true;
	}
	
	public Reporte(Cuenta cuenta)//listo
	{	
		this.cuenta = cuenta;
		delimitar = false;
	}
	
	public void generarReporte()
	{
		cuentaTemp = archivo.leerArchivo(cuenta);
		try {
			escribirHeader();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		escribirBody();
		escribirFooter();
	}
	
	protected void escribirBody()//listo
	{	
	}
	
	protected void escribirHeader() throws DocumentException//listo
	{	
	}
	
	protected void escribirFooter()//listo
	{	
	}
}
