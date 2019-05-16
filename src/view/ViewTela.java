package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ViewTela {

	private JFrame frmPrograma;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtIdade;
	private final ButtonGroup sexGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTela window = new ViewTela();
					window.frmPrograma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrograma = new JFrame();
		frmPrograma.setResizable(false);
		frmPrograma.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewTela.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		frmPrograma.setTitle("Programa - by Emerson");
		frmPrograma.setBounds(100, 100, 310, 192);
		frmPrograma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrograma.getContentPane().setLayout(null);
		frmPrograma.setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 36, 22);
		frmPrograma.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(94, 12, 200, 20);
		frmPrograma.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(10, 44, 74, 16);
		frmPrograma.getContentPane().add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(94, 42, 200, 20);
		frmPrograma.getContentPane().add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 71, 55, 16);
		frmPrograma.getContentPane().add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(94, 69, 200, 20);
		frmPrograma.getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		sexGroup.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(94, 94, 71, 24);
		frmPrograma.getContentPane().add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		sexGroup.add(rdbtnFeminino);
		rdbtnFeminino.setBounds(167, 94, 67, 24);
		frmPrograma.getContentPane().add(rdbtnFeminino);
		
		JRadioButton rdbtnOutro = new JRadioButton("Outro");
		sexGroup.add(rdbtnOutro);
		rdbtnOutro.setBounds(236, 94, 53, 24);
		frmPrograma.getContentPane().add(rdbtnOutro);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 98, 55, 16);
		frmPrograma.getContentPane().add(lblSexo);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sexo = "";
				if (rdbtnMasculino.isSelected()) {
					sexo = rdbtnMasculino.getText();
				} else if (rdbtnFeminino.isSelected()) {
					sexo = rdbtnFeminino.getText();
				} else if (rdbtnOutro.isSelected()) {
					sexo = rdbtnOutro.getText();
				} else {
					sexo = "Indefinido";
				}
				
				if (txtNome.getText().isEmpty() || txtSobrenome.getText().isEmpty() || txtIdade.getText().isEmpty() || !rdbtnMasculino.isSelected() && !rdbtnFeminino.isSelected() && !rdbtnOutro.isSelected()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", 0);
				} else {
					JOptionPane.showMessageDialog(null, "Nome: " +txtNome.getText()+ "\nSobrenome: " +txtSobrenome.getText()+
														"\nIdade: " +txtIdade.getText()+ "\nSexo: " +sexo, "Informações", 1);
				}
			}
		});
		btnMostrar.setBounds(10, 127, 98, 26);
		frmPrograma.getContentPane().add(btnMostrar);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtSobrenome.setText("");
				txtIdade.setText("");
				sexGroup.clearSelection();
			}
		});
		btnResetar.setBounds(196, 127, 98, 26);
		frmPrograma.getContentPane().add(btnResetar);
	}
}
