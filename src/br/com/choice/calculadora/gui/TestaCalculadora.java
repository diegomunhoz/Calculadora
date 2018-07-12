package br.com.choice.calculadora.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import br.com.choice.calculadora.modelo.Calculadora;

/**
 * Classe responsável por executar calculadora
 * @author Diego Munhoz
 * @since 18/02/2014
 */

public class TestaCalculadora {

	// Declara as varíaveis de referência
	private JFrame janelaPrincipal;
	private JTextArea areaExibicao;
	private JTextArea areaResultado;
	
	private JButton jbtZero;
	private JButton jbtUm;
	private JButton jbtDois;
	private JButton jbtTres;
	private JButton jbtQuatro;
	private JButton jbtCinco;
	private JButton jbtSeis;
	private JButton jbtSete;
	private JButton jbtOito;
	private JButton jbtNove;
	
	private JButton jbtSoma;
	private JButton jbtSubtracao;
	private JButton jbtDivisao;
	private JButton jbtMultiplicacao;
	
	private JButton jbtVirgula;
	private JButton jbtPorcentagem;
	private JButton jbtLimpar;
	private JButton jbtResultado;

	private boolean flagOperacaoRepetida = false;
	private boolean flagResultado= false;
	private String flagOperacao = null;
	private String flagOperacaoResultado;
	private String flagPrimeiraOperacao;

	private double resultado = 0;
	private String numeroDigitado;
	private double numeroDigitadoConvertido;

	public void iniciaGui(){
		
		// Cria as instancias
		janelaPrincipal = new JFrame();
		areaExibicao = new JTextArea();
		areaResultado = new JTextArea();
		
		jbtZero = new JButton("0");
		jbtUm = new JButton("1");
		jbtDois = new JButton("2");
		jbtTres = new JButton("3");
		jbtQuatro = new JButton("4");
		jbtCinco = new JButton("5");
		jbtSeis = new JButton("6");
		jbtSete = new JButton("7");
		jbtOito = new JButton("8");
		jbtNove = new JButton("9");
		jbtSoma = new JButton("+");
		jbtMultiplicacao = new JButton("*");
		jbtDivisao = new JButton("/");
		jbtSubtracao = new JButton("-");
		jbtVirgula = new JButton(",");
		jbtPorcentagem = new JButton("%");
		jbtLimpar = new JButton("CE");
		jbtResultado = new JButton("=");
		
		areaExibicao.setBounds(5, 5, 270, 25);
		areaResultado.setBounds(5, 25, 270, 25);
		
		jbtNove.setBounds(115, 50, 50, 60);
		jbtOito.setBounds(60, 50, 50, 60);
		jbtSete.setBounds(5, 50, 50, 60);
		jbtSeis.setBounds(115, 115, 50, 60);
		jbtCinco.setBounds(60, 115, 50, 60);
		jbtQuatro.setBounds(5, 115, 50, 60);
		jbtTres.setBounds(115, 180, 50, 60);
		jbtDois.setBounds(60, 180, 50, 60);
		jbtUm.setBounds(5, 180, 50, 60);
		jbtZero.setBounds(5, 245, 105, 60);
		jbtVirgula.setBounds(115, 245, 50, 60);
		
		jbtLimpar.setBounds(225, 50, 50, 60);
		jbtPorcentagem.setBounds(225, 115, 50, 60);
		jbtMultiplicacao.setBounds(170, 50, 50, 60);
		jbtDivisao.setBounds(170, 115, 50, 60);
		jbtSubtracao.setBounds(170, 180, 50, 60);
		jbtSoma.setBounds(170, 245, 50, 60);
		jbtResultado.setBounds(225, 180, 50, 125);
		
		areaResultado.setEditable(false);
		areaExibicao.setEditable(false);

		janelaPrincipal.getContentPane().add(areaExibicao);
		janelaPrincipal.getContentPane().add(areaResultado);
		janelaPrincipal.getContentPane().add(jbtUm);
		janelaPrincipal.getContentPane().add(jbtDois);
		janelaPrincipal.getContentPane().add(jbtTres);
		janelaPrincipal.getContentPane().add(jbtQuatro);
		janelaPrincipal.getContentPane().add(jbtCinco);
		janelaPrincipal.getContentPane().add(jbtSeis);
		janelaPrincipal.getContentPane().add(jbtSete);
		janelaPrincipal.getContentPane().add(jbtOito);
		janelaPrincipal.getContentPane().add(jbtNove);
		janelaPrincipal.getContentPane().add(jbtZero);
		janelaPrincipal.getContentPane().add(jbtVirgula);
		janelaPrincipal.getContentPane().add(jbtSoma);
		janelaPrincipal.getContentPane().add(jbtMultiplicacao);
		janelaPrincipal.getContentPane().add(jbtSubtracao);
		janelaPrincipal.getContentPane().add(jbtDivisao);
		janelaPrincipal.getContentPane().add(jbtResultado);
		janelaPrincipal.getContentPane().add(jbtLimpar);
		janelaPrincipal.getContentPane().add(jbtPorcentagem);

		jbtNove.addActionListener(new NoveListener());
		jbtOito.addActionListener(new OitoListener());
		jbtSete.addActionListener(new SeteListener());
		jbtSeis.addActionListener(new SeisListener());
		jbtCinco.addActionListener(new CincoListener());
		jbtQuatro.addActionListener(new QuatroListener());
		jbtTres.addActionListener(new TresListener());
		jbtDois.addActionListener(new DoisListener());
		jbtUm.addActionListener(new UmListener());
		jbtZero.addActionListener(new ZeroListener());
		jbtSoma.addActionListener(new SomaListener());
		jbtSubtracao.addActionListener(new SubtracaoListener());
		jbtMultiplicacao.addActionListener(new MultiplicacaoListener());
		jbtDivisao.addActionListener(new DivisaoListener());
		jbtLimpar.addActionListener(new LimparListener());
		jbtResultado.addActionListener(new ResultadoListener());
		
		// Configura a janela
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setLayout(null);
		janelaPrincipal.setSize(300, 350);
		janelaPrincipal.setVisible(true);
		
	}//fim do método para criar JFrame
	
	public class NoveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "9";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "9";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class OitoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "8";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "8";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}
	}

	public class SeteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "7";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "7";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class SeisListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "6";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "6";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class CincoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "5";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "5";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class QuatroListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "4";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "4";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class TresListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "3";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "3";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class DoisListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "2";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "2";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class UmListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "1";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "1";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}
	}

	public class ZeroListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagResultado == true) {
				areaExibicao.setText(null);
				areaResultado.setText(null);
				flagResultado = false;
			}
			if (flagOperacao != null) {
				numeroDigitado = "0";
				areaExibicao.setText(areaExibicao.getText() + numeroDigitado);
				flagOperacaoRepetida = false;
				flagOperacao = null;
			}else {
				numeroDigitado = areaExibicao.getText() + "0";
				areaExibicao.setText(numeroDigitado);
				flagOperacao = null;
				flagOperacaoRepetida = false;
			}
		}		
	}

	public class SomaListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagOperacaoRepetida == true) {
				JOptionPane.showMessageDialog(null, "Operação inválida!");
			}else {
				try {
					areaExibicao.setText(areaExibicao.getText() + "+");
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado + numeroDigitadoConvertido;
					areaResultado.setText("" + resultado);
					flagOperacaoRepetida = true;
					flagOperacaoResultado = "+";
					flagOperacao = "+";
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor digitado inválido, informe novamente!");
				}				
			}
		}
	}

	public class SubtracaoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagOperacaoRepetida == true) {
				JOptionPane.showMessageDialog(null, "Operação inválida!");
			}else {
				try {
					areaExibicao.setText(areaExibicao.getText() + "-");
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado - numeroDigitadoConvertido;
					areaResultado.setText("" + resultado);
					flagOperacaoRepetida = true;
					flagOperacaoResultado = "-";
					flagOperacao = "-";
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor digitado inválido, informe novamente!");
				}				
			}
		}		
	}

	public class MultiplicacaoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagOperacaoRepetida == true) {
				JOptionPane.showMessageDialog(null, "Operação inválida!");
			}else {
				try {
					areaExibicao.setText(areaExibicao.getText() + "*");
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado * numeroDigitadoConvertido;
					areaResultado.setText("" + resultado);
					flagOperacaoRepetida = true;
					flagOperacaoResultado = "*";
					flagOperacao = "*";
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor digitado inválido, informe novamente!");
				}				
			}
		}		
	}

	public class DivisaoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (flagOperacaoRepetida == true) {
				JOptionPane.showMessageDialog(null, "Operação inválida!");
			}else {
				try {
					areaExibicao.setText(areaExibicao.getText() + "/");
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado / numeroDigitadoConvertido;
					areaResultado.setText("" + resultado);
					flagOperacaoRepetida = true;
					flagOperacaoResultado = "/";
					flagOperacao = "/";
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor digitado inválido, informe novamente!");
				}				
			}
		}		
	}

	public class PorcentagemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			areaExibicao.setText(areaExibicao.getText() + "%");
		}		
	}

	public class LimparListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			areaExibicao.setText(null);
			areaResultado.setText(null);
			resultado = 0;
			numeroDigitadoConvertido = 0;
			numeroDigitado = null;
		}
	}

	public class ResultadoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (resultado == 0) {
				JOptionPane.showMessageDialog(null, "É necessário efetuar uma operação!");
			}else if (flagOperacao == null) {
				switch (flagOperacaoResultado) {
				case "+":
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado + numeroDigitadoConvertido;
					areaResultado.setText(resultado + "");
					flagResultado = true;
					flagOperacao = null;
					flagOperacaoResultado = null;
					break;

				case "-":
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado - numeroDigitadoConvertido;
					areaResultado.setText(resultado + "");
					flagResultado = true;
					flagOperacao = null;
					flagOperacaoResultado = null;
					break;

				case "/":
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado / numeroDigitadoConvertido;
					areaResultado.setText(resultado + "");
					flagResultado = true;
					flagOperacao = null;
					flagOperacaoResultado = null;
					break;

				case "*":
					numeroDigitadoConvertido = Double.parseDouble(numeroDigitado);
					resultado = resultado * numeroDigitadoConvertido;
					areaResultado.setText(resultado + "");
					flagResultado = true;
					flagOperacao = null;
					flagOperacaoResultado = null;
					break;
				}
			}else{
				JOptionPane.showMessageDialog(null, "Operação inválida!");
			}
		}
	}

	public static void main(String[] args) {//inicio do método main
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		TestaCalculadora aplicativo = new TestaCalculadora();
		aplicativo.iniciaGui();
	}//fim do main

}//fim da classe