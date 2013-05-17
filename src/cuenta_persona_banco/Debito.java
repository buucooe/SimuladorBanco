package cuenta_persona_banco;

public class Debito extends Cuenta
{
	double montoMinimo = 5000;
	
	public Debito()
	{
		this.tipoCuenta = "deb";
		System.out.println("Debito Creado");
	}
	
	protected boolean checarMontoMinimo()
	{
		if(this.getSaldo() < montoMinimo)
		{
			System.out.println("El saldo en la cuenta es menor al minimo");
			return false;
		}
		return true;
	}
	
	public void setMontoMinimo(int montoMinimo)
	{
		this.montoMinimo = montoMinimo;
	}
	
	public double getMontoMinimo()
	{
		return montoMinimo;
	}

}
