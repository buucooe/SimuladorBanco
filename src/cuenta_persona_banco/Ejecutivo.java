package cuenta_persona_banco;

public abstract class Ejecutivo extends Persona implements Aprobador 
{
	protected Aprobador siguiente;

	@Override
	public abstract void aprobar(Cuenta cuenta);

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
