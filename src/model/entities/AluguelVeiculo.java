package model.entities;

import java.util.Date;

import Excecao.DomainException;
import java.text.SimpleDateFormat;

public class AluguelVeiculo {
	
	private Date inicio;
	private Date retorno;
	private Veiculo veiculo;
	private Fatura fatura;
	private Cliente cliente;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yy");

	public AluguelVeiculo() {
		
	}

	public AluguelVeiculo(Date inicio, Date retorno, Veiculo veiculo, Cliente cliente) {
		if(!retorno.after(inicio)) {
			throw new DomainException ("Erro na data: A data de retorno deve ser após a data de inicio: ");
		}
		this.inicio = inicio;
		this.retorno = retorno;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getRetorno() {
		return retorno;
	}

	public void setRetorno(Date retorno) {
		this.retorno = retorno;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "AluguelVeiculo [inicio=" + inicio + ", retorno=" + retorno + ", veiculo=" + veiculo 
				+ "\n "+ fatura 
				+ "\n " + cliente + "]";
	}
	
}