package br.com.choice.calculadora.modelo;

/**
 * Classe responsável por armazenar atributos e método de CALCULADORA
 * @author Diego Munhoz
 * @since 18/02/2014
 */

public class Calculadora {//inicio da classe
	
	private double numeroDigitado;
	private double resultadoFinal;
	private String operacao;
	
	public double getNumeroDigitado() {
		return numeroDigitado;
	}
	public void setNumeroDigitado(double numeroDigitado) {
		this.numeroDigitado = numeroDigitado;
	}
	public double getResultadoFinal() {
		return resultadoFinal;
	}
	public void setResultadoFinal(double resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

}//fim da classe