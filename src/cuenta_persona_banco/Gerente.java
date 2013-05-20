package cuenta_persona_banco;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Ejecutivo 
{
	private Aprobador siguiente;
	protected int tipoGerente;
	public List<String> gerentes;
	
	public Gerente(int tipoGerente)
	{
		this.tipoGerente = tipoGerente;
		this.gerentes = new ArrayList<String>();
	}

	public int getTipoGerente() 
	{
		return tipoGerente;
	}

	public void setTipoGerente(int tipoGerente) 
	{
		this.tipoGerente = tipoGerente;
	}
	
	public Aprobador getNext()
	{ 	
		if(this.getTipoGerente() == 1)
		{
			return this.siguiente;
		}
		else
		{
			System.err.println("No se pudo completar su transacción");
			System.err.println("intentelo de nuevo.");
			return null;
		}
	}

	@Override
	public void aprobar(Cuenta cuenta) 
	{
		if(cuenta.getTipoCuenta() == "hip" || cuenta.getTipoCuenta() == "cre")
		{
			System.out.println("la trato yo, el gerente tipo 2");
		}
	}

}
