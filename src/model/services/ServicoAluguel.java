package model.services;

import java.util.Date;

import Excecao.DomainException;
import model.entities.AluguelVeiculo;
import model.entities.Fatura;

public class ServicoAluguel {
	
	private Double precoHora;
	private Double precoDia;
	private ImpostoServico impostoServico;
	
	public ServicoAluguel() {
		
	}

	public ServicoAluguel(Double precoHora, Double precoDia, ImpostoServico impostoServico) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.impostoServico = impostoServico;
	}

	public Double getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(Double precoHora) {
		this.precoHora = precoHora;
	}

	public Double getPrecoDia() {
		return precoDia;
	}

	public void setPrecoDia(Double precoDia) {
		this.precoDia = precoDia;
	}

	public ImpostoServico getImpostoServico() {
		return impostoServico;
	}

	public void setImpostoServico(ImpostoServico impostoServico) {
		this.impostoServico = impostoServico;
	}
	public void processarFatura(AluguelVeiculo aluguelVeiculo) {
		long T1 = aluguelVeiculo.getInicio().getTime();
		long T2 = aluguelVeiculo.getRetorno().getTime();
		double horas = (double)(T2-T1)/1000/60/60;
	
		double pagamentoBasico;
		if (horas <=12.0) {
			pagamentoBasico = Math.ceil(horas)* precoHora;
		}
		else {
			pagamentoBasico = Math.ceil(horas/24)*precoDia;
		}
		double imposto = impostoServico.imposto(pagamentoBasico);
		aluguelVeiculo.setFatura(new Fatura(pagamentoBasico,imposto));
	}

	@Override
	public String toString() {
		return "ServicoAluguel [precoHora= R$ " + String.format("%.2f", precoHora) 
		+ ", precoDia= " + String.format("%.2f", precoDia)
		+  "]";
	}
	
}
