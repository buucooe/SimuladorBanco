package html_pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

import archivo.ManejoArchivo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import cuenta_persona_banco.Cuenta;

public class HTML extends Reporte
{
	public HTML(Cuenta cuenta) 
	{
		super(cuenta);
	}
	
	
	public HTML(Date fechaInicio,Date fechaFin,Cuenta cuenta)//listo
	{
		super(fechaInicio,fechaFin,cuenta);
	}
	
	protected void escribirHeader() throws DocumentException	
	{
		FileWriter html=null;
	    PrintWriter pw=null;

	    try
	    {
	        html=new FileWriter("bitacora.html");
	        pw=new PrintWriter(html);

	        pw.println("<html>");
	        pw.println("<body bgcolor=black>");
	        pw.println("<head>");
	        pw.println("<title>");
	        pw.println("Banco-lobuki");
	        pw.println("</title>");
	        pw.println("</head>");
	        pw.println("<font color=white size=+5, face=bell MT>");
	        pw.println("<h1 align=center>Reporte</h1>");
	        pw.println("<hr width =100% color=White>");
	        pw.println("</font>");
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<font color=white size=+2,face=bell MT>");
	        for(String x: cuenta.operaciones)
	    	{
	        	pw.println(x);
		        pw.println("<br>");
	    	}
	        pw.println("</font>");
	        pw.println("</html>");
	        pw.println("</body>");
	    }
	     catch(Exception e){
	        e.printStackTrace();

	     }
	     finally
	     {
	        try
	        {
	            if(null!=html)
	                html.close();
	        }

	     catch(Exception e2)
	     {
	        e2.printStackTrace();
	     }
	    }
	  	}
	
	protected void escribirBody()
	{	
	}
	
	protected void escribirFooter()
	{		
	}
}
