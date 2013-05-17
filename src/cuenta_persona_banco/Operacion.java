package cuenta_persona_banco;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operacion 
{
	private Cuenta cuenta;
	private Persona persona;
	protected  Date fechaOp;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	public void depositar(double cantidad, Cuenta cuenta, Persona persona)
	{
		double saldo = cuenta.getSaldo();
		saldo += cantidad;
		cuenta.setSaldo(saldo);
		getInfo("deposito", cantidad, persona, cuenta);
		
	}
	
	public boolean retirar(double cantidad, Cuenta cuenta, Persona persona)
	{
		double nuevo_saldo = cuenta.getSaldo() - cantidad;
		if(nuevo_saldo >= 0)
		{
			cuenta.setSaldo(nuevo_saldo);
			getInfo("retiro", cantidad, persona, cuenta);
			return true;
		}
		else
		{
			System.out.println("Fondos insuficientes");
			return false;
		}
	}
	
	public void eliminar(Cuenta cuenta)
	{
		//Eliminar la cuenta
	}
	
	public double consultarSaldo(Cuenta cuenta, Persona persona)
	{
		getInfo("consulta", persona, cuenta);
		return cuenta.getSaldo();
	}
	
	public void getInfo(String operacion, double cantidad, Persona persona, Cuenta cuenta)
	{
		cuenta.operaciones.add(persona.getUsuario() + "," + operacion + "," + cantidad + "," + cuenta.getNumeroCuenta() + "," + getFechaOperacion() );
	}
	
	public void getInfo(String operacion, Persona persona, Cuenta cuenta)
	{
		cuenta.operaciones.add(persona.getUsuario() + "," + operacion +  "," + "null," + cuenta.getNumeroCuenta() + "," + getFechaOperacion() );
	}
	
	public String getFechaOperacion()
	{
		return dateFormat.format(fechaOp);
	}
	
}
