package cuenta_persona_banco;

public class Empleado extends Ejecutivo
{
	private Aprobador siguiete;
	
	@Override
	public void aprobar(Cuenta cuenta) 
	{
		if(cuenta.getTipoCuenta() != "cre")
		{
			System.out.println(cuenta.getTipoCuenta());
			System.out.println("la trato yo, el empleado");
		}
		else
		{
			siguiente.aprobar(cuenta);
		}
	}
	
	@Override
	public void setNext(Aprobador aprobador) 
	{
		this.siguiente = aprobador;
		
	}

	@Override
	public Aprobador getNext() 
	{
		return this.siguiente;
	}

}
