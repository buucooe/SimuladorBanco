package cuenta_persona_banco;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class Cuenta 
{
	private String numeroCuenta;
	protected String tipoCuenta;
	public List<String> operaciones;
	protected  Date fechaInicial;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private double saldo = 0;
	
	public Cuenta()
	{
		this.fechaInicial = new Date();
		this.operaciones = new ArrayList<String>();
	}

	public double getSaldo() 
	{
		return this.saldo;
	}

	public void setSaldo(double saldo) 
	{
		this.saldo = saldo;
	}
	
	public String getNumeroCuenta()
	{
		return this.numeroCuenta;
	}
	
	public void setNumeroCuenta()
	{
		Random rand = new Random();
		this.numeroCuenta =  Integer.toString(rand.nextInt(1000) + 1);
		System.out.println("Numero de cuenta: " + this.numeroCuenta );
		
	}
	
	public String getTipoCuenta()
	{
		return this.tipoCuenta;
	}
	
	public void setTipoCuenta(String tipoCuenta)
	{
		this.tipoCuenta = tipoCuenta;
	}
	
	public String getFechaCreacion()
	{
		return dateFormat.format(this.fechaInicial);
	}
	
}
