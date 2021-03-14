package model.services;

public class ImpostoBrasil implements ImpostoServico{
	
	public double imposto(double amount) {
		if (amount <=100.00) {
			return amount *0.2;
		}
		else {
			return amount*0.15;
		}
	}

}
