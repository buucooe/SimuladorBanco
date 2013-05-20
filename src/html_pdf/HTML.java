package html_pdf;

import java.io.FileWriter;
import java.io.PrintWriter;


import cuenta_persona_banco.Cuenta;

public class HTML extends Reporte
{
	FileWriter html=null;
    PrintWriter pw=null;
	public HTML(Cuenta cuenta) 
	{
		super(cuenta);
	}
	
	
	public HTML(String fechaInicio,String fechaFin,Cuenta cuenta)//listo
	{
		super(fechaInicio,fechaFin,cuenta);
	}
	
	protected void escribirHeader()
	{
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
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Algo malo pasó :|");
	    }
	}
	
	protected void escribirBody()
	{	
		try
		{
			pw.println("<font color=white size=+5, face=bell MT>");
	        pw.println("<h1 align=center>Reporte-Lobuki</h1>");
	        pw.println("<hr width =100% color=White>");
	        pw.println("</font>");
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<font color=white size=+2,face=bell MT>");
	        pw.println("<table>");
	        pw.println("<tr>");
	        pw.println("<th scope=\"col\">Usuario</th>");
	        pw.println("<th scope=\"col\">Actividad</th>");
	        pw.println("<th scope=\"col\">Cantidad</th>");
	        pw.println("<th scope=\"col\">Número de cuenta</th>");
	        pw.println("<th scope=\"col\">Fecha</th>");
	        pw.println("</tr>");
	        for(String x: cuenta.operaciones)
	    	{
	        	String[] datos = x.split(","); 
	        	if(delimitar)
	        	{
	        		String[] datosFecha = datos[4].split("/");
		        	int dia = Integer.parseInt(datosFecha[2]);
		        	int mes = Integer.parseInt(datosFecha[1]);
		        	int año = Integer.parseInt(datosFecha[0]);
		        	
		        	String[] datosFechaInicial = fechaInicio.split("/");
		        	int diaInicial = Integer.parseInt(datosFechaInicial[2]);
		        	int mesInicial = Integer.parseInt(datosFechaInicial[1]);
		        	int añoInicial = Integer.parseInt(datosFechaInicial[0]);
		        	
		        	String[] datosFechaFinal = fechaFin.split("/");
		        	int diaFinal = Integer.parseInt(datosFechaFinal[2]);
		        	int mesFinal = Integer.parseInt(datosFechaFinal[1]);
		        	int añoFinal = Integer.parseInt(datosFechaFinal[0]);
		        	
		        	if(dia>=diaInicial && dia<=diaFinal && mes >= mesInicial && mes<=mesFinal && año>=añoInicial && año<=añoFinal)
		        	{
		        		pw.println("<tr>");
		        		pw.println("<td>"+datos[0]+"</td>");
		        		pw.println("<td>"+datos[1]+"</td>");
		        		pw.println("<td>"+datos[2]+"</td>");
		        		pw.println("<td>"+datos[3]+"</td>");
		        		pw.println("<td>"+datos[4]+"</td>");
		        		pw.println("</tr>");
		        	}	
	        	}
	        	else
	        	{
	        		pw.println("<tr>");
	        		pw.println("<td>"+datos[0]+"</td>");
	        		pw.println("<td>"+datos[1]+"</td>");
	        		pw.println("<td>"+datos[2]+"</td>");
	        		pw.println("<td>"+datos[3]+"</td>");
	        		pw.println("<td>"+datos[4]+"</td>");
	        		pw.println("</tr>");
	        	}
	    	}
	        pw.println("</font>");
	        pw.println("</html>");
	        pw.println("</body>");
		}
		catch(Exception e)
	    {
	        System.out.println("Algo malo pasó :|");
	    }
	}
	
	protected void escribirFooter()
	{	
		try
        {
            if(null!=html)
            {
                html.close();
            }
        }
		catch(Exception e2)
		{
			System.out.println("Algo malo pasó :|");
		}

	}
}
