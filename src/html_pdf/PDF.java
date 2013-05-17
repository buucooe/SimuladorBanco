package html_pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	public PDF(Cuenta cuenta) 
	{
		super(cuenta);
	}
	
	
	public PDF(Date fechaInicio,Date fechaFin,Cuenta cuenta)//listo
	{
		super(fechaInicio,fechaFin,cuenta);
	}
	
	protected void escribirHeader() throws DocumentException	
	{
		FileOutputStream archivo;
		try {
			archivo = new FileOutputStream("C:\\Banco\\Reporte.pdf");
			Document documento = new Document();
	    	PdfWriter.getInstance(documento, archivo);
	    	documento.open();
	    	for(String x: cuenta.operaciones)
	    	{
	    		documento.add(new Paragraph(x));
	    	}
	    	documento.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void escribirBody()
	{	
		
	}
	
	protected void escribirFooter()
	{	
		
	}
}
