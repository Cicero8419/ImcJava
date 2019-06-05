import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdk.jfr.internal.PrivateAccess;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class CalculoImc extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtImc;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoImc frame = new CalculoImc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculoImc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeso = new JLabel("peso");
		lblPeso.setBounds(63, 47, 48, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(138, 44, 96, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(63, 78, 48, 14);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(138, 75, 96, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblSeuImc = new JLabel("Seu Imc");
		lblSeuImc.setBounds(63, 125, 48, 14);
		contentPane.add(lblSeuImc);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setIcon(new ImageIcon(CalculoImc.class.getResource("/Imagens/imc.png")));
		btnCalcular.setBounds(276, 72, 72, 57);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CalculoImc.class.getResource("/Imagens/limpar.png")));
		btnLimpar.setBounds(377, 72, 72, 57);
		contentPane.add(btnLimpar);
		
		lblStatus = new JLabel("New label");
		lblStatus.setIcon(new ImageIcon(CalculoImc.class.getResource("/Imagens/tabela_imc.jpg")));
		lblStatus.setBounds(45, 169, 408, 197);
		contentPane.add(lblStatus);
		
		txtImc = new JTextField();
		txtImc.setBounds(138, 122, 96, 20);
		contentPane.add(txtImc);
		txtImc.setColumns(10);
	}
	//método para calcular o IMC
	////////////////////////////////////////////////////////////////////////////
	private void calcular() 
	{
		DecimalFormat formatador = new DecimalFormat("0.00");
		double peso, altura , imc;
		peso= Double.parseDouble(txtPeso.getText().replace(",","."));
		altura= Double.parseDouble(txtAltura.getText().replace(",","."));
		imc = peso / (altura*altura);
		txtImc.setText(formatador.format(imc));
		
		System.out.print("IMC: " + formatador.format (imc));
		//Para criar um intervalo usamos o operador AND (&&)
		if (imc <18.5 ) 
		{
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tabela_imc_abaixo.jpg")));
		}
		else if (imc >=18.5 && imc < 25)
		{
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tabela_imc_normal.jpg")));
		} 
		else if (imc >= 25 && imc <30) 
		{
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tabela_imc_acima.jpg")));	
		}
		else 
		{
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tabela_imc_obeso.jpg")));
		}
	}
				
				
	//Esse método abaixo limpa os campos e as imagens da tabela IMC
	private void limpar() 
	{
		txtPeso.setText(null);
		txtAltura.setText(null);
		txtImc.setText(null);
		lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tabela_imc.jpg")));
	}		
}

