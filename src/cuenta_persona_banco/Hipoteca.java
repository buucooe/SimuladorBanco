package cuenta_persona_banco;

public class Hipoteca extends Cuenta 
{
	private int periodoCreditoMeses = 0;
	private double tasaInteres = 0;
	String[] fecha = new String[3];
	
	public Hipoteca(int periodoEstablecido, double tasaInteres)
	{
		this.crear(periodoEstablecido, tasaInteres);
	}
	
	public void crear(int periodoEstablecido, double tasaInteres) 
	{
		
		this.setPeriodoCreditoMeses(periodoEstablecido);
		this.setTasaInteres(tasaInteres);
	}
	
	protected boolean checarPeriodoActual(int periodoActual)
	{
		String fechaCreacion = this.getFechaCreacion();
		fecha = fechaCreacion.split("/");
		int mes = Integer.parseInt(fecha[1]);
		
		System.out.println(mes + " " + fecha[1]);
		if(mes > periodoActual)
		{
			System.out.println("Periodo agotado");
			return false;
		}
		else
		{
			System.out.println("Periodo vigente");
			return true;
		}
	}
	
	public void setPeriodoCreditoMeses(int periodoCreditoMeses)
	{
		this.periodoCreditoMeses = periodoCreditoMeses;
	}
	
	public int getPeriodoCreditoMeses()
	{
		return periodoCreditoMeses;
	}
	
	public void setTasaInteres(double tasaInteres)
	{
		this.tasaInteres = tasaInteres;
	}
	
	public double getTasaInteres()
	{
		return tasaInteres;
	}

}
