package cuenta_persona_banco;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona 
{
	private Cuenta cuenta;
	private String usuario,
				   nombre;
	protected List<String> numerosCuenta;
	protected List<Cuenta> cuentas;
	private int cantidadCuentas;
	
	public Persona()
	{
		cantidadCuentas = 0;
		numerosCuenta = new ArrayList<String>();
		cuentas = new ArrayList<Cuenta>();
	}
	
	public void eliminar()
	{
		//Eliminar usuario
	}
	
	public Cuenta getCuenta() 
	{
		return cuenta;
	}

	public void setCuenta(String numCuenta) 
	{
		if(cantidadCuentas < 5)
		{
			numerosCuenta.add(cuenta.getNumeroCuenta());
			cantidadCuentas += 1;
		}
		else
		{
			System.out.println("Numero maximo de cuentas alcanzado(5)");
			return;
		}
	}

	public String getUsuario()
	{
		return usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public int getCantidadCuentas()
	{
		return this.cantidadCuentas;
	}

	public List<String> getNumerosCuenta()
	{
		return this.numerosCuenta;
	}
	

	
}
