package cuenta_persona_banco;

public class Banco implements Aprobador
{

	private Aprobador siguiente;

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

	@Override
	public void aprobar(Cuenta cuenta) 
	{
		Empleado emp = new Empleado();
		this.setNext(emp);
		
		Gerente ger0 = new Gerente(1);
		emp.setNext(ger0);
		//aqui checamos si hay otro gerente conectado buscando en el archivo, 
		//si lo encontramos, creamos al tipo de gerente2 para q apruebe el delirio.
		Gerente ger1 = new Gerente(2);
		ger0.setNext(ger1);
		
		siguiente.aprobar(cuenta);
	}
}
