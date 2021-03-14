package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Excecao.DomainException;
import model.entities.AluguelVeiculo;
import model.entities.Cliente;
import model.entities.Veiculo;
import model.services.ImpostoBrasil;
import model.services.ImpostoServico;
import model.services.ServicoAluguel;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:ss");
	try {	
		System.out.print("Entre com os dados do pedido: ");
		System.out.println("Inicio da locação (dd/MM/yyy hh:mm)");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.println("Término da locação (dd/MM/yyy hh:mm)");
		Date retorno = sdf.parse(sc.nextLine());
	
		System.out.println("Digite o modelo do veículo: ");
		String modelo = sc.nextLine();
		System.out.println("Informe a placa do carro: ");
		String placa = sc.nextLine();
		System.out.println("Informe o nome do cliente: ");
		String nome = sc.nextLine();
		System.out.println("Informe o CPF do cliente: ");
		String CPF = sc.nextLine();
		System.out.println("Informe o telefone do cliente: ");
		String telefone = sc.nextLine();
		
		
		AluguelVeiculo av = new AluguelVeiculo(inicio,retorno,new Veiculo(modelo,placa),new Cliente(nome,CPF,telefone));
	
		
		System.out.println("Entre com o preço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.println("Entre com o preço por dia: ");
		double precoDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoHora,precoDia,new ImpostoBrasil());
		servicoAluguel.processarFatura(av);
		
		System.out.println("Resumo da fatura de locação: ");
		System.out.println(av );
		System.out.println(servicoAluguel);
	}
	catch (DomainException e) {
		System.out.println("Erro na data: " + e.getMessage());
	}
		
	
		sc.close();

	}

}
