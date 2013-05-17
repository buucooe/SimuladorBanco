package cuenta_persona_banco;

public interface Aprobador 
{
	public void aprobar(Cuenta cuenta);
	
	public void setNext(Aprobador aprobador);
	
	public Aprobador getNext();
	
}
