package html_pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cuenta_persona_banco.Cuenta;

public class PDF extends Reporte
{
	Document documento = new Document();
	FileOutputStream archivo;
	public PDF(Cuenta cuenta) 
	{
		super(cuenta);
	}
	
	
	public PDF(String fechaInicio,String fechaFin,Cuenta cuenta)
	{
		super(fechaInicio,fechaFin,cuenta);
	}
	
	protected void escribirHeader() throws DocumentException	
	{
		
		try 
		{
			archivo = new FileOutputStream("C:\\Banco\\Reporte-"+cuenta.getNumeroCuenta()+".pdf");
	    	PdfWriter.getInstance(documento, archivo);
	    	documento.open();
	    	
	    	Image image1=null;
			try {
				image1 = Image.getInstance("C:\\Banco\\logo.PNG");
			} catch (MalformedURLException e) 
			{

			} catch (IOException e) 
			{
				System.out.println("Algo malo pasó :|");
			}
	        documento.add(image1);	    		    		        
	    	
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Algo malo pasó :|");
		}
	}
	
	protected void escribirBody()
	{		
		try
		{
			PdfPTable table = new PdfPTable(5); 
			PdfPCell cell1 = new PdfPCell(new Paragraph("Usuario"));
	        PdfPCell cell2 = new PdfPCell(new Paragraph("Actividad"));
	        PdfPCell cell3 = new PdfPCell(new Paragraph("Cantidad"));	     
	        PdfPCell cell41 = new PdfPCell(new Paragraph("Número Cuenta"));
	        PdfPCell cell42 = new PdfPCell(new Paragraph("Fecha Operación"));
	        
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell42.setHorizontalAlignment(Element.ALIGN_CENTER);

	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);	        
	        table.addCell(cell41);
	        table.addCell(cell42);
	        
	        
	        for(String x: cuenta.operaciones)//cuenta.operaciones)
	    	{
	        	String[] datos = x.split(","); 
	        	PdfPCell cell5 = new PdfPCell(new Paragraph(datos[0]));
		        PdfPCell cell6 = new PdfPCell(new Paragraph(datos[1]));
		        PdfPCell cell7 = new PdfPCell(new Paragraph(datos[2]));
		        PdfPCell cell8 = new PdfPCell(new Paragraph(datos[3]));
		        PdfPCell cell9 = new PdfPCell(new Paragraph(datos[4]));
		        
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
		        		table.addCell(cell5);
				        table.addCell(cell6);
				        table.addCell(cell7);
				        table.addCell(cell8);	    
				        table.addCell(cell9);
		        	}	        		
		        }
		        else
		        {
			        table.addCell(cell5);
			        table.addCell(cell6);
			        table.addCell(cell7);
			        table.addCell(cell8);	    
			        table.addCell(cell9);
		        }
	    	}
	       
	        documento.add(table);

		} 
		catch (Exception e) 
		{
			System.out.println("Algo malo pasó :|");
		}
	}
	
	protected void escribirFooter()
	{	
		try
		{
			documento.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Algo malo pasó :|");
		}
	}
}
