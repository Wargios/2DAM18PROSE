package cliente;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VistaCliente extends JPanel {

	private JPanel panelNorte;
	private JScrollPane panelCentro;
	private JPanel panelSur;

	private JLabel jLabelNick;
	private JTextField jFieldNick;
	private JButton jButtonConectar;
	private JButton jButtonDesconectar;

	private JTextArea jtaChat;
	
	private JTextField htFieldEnviar;
	private JButton jButtonEnviar;

	public VistaCliente() {
		setLayout(new BorderLayout());
		
		// PANEL NORTE /////////////////
		panelNorte = new JPanel(new GridLayout(2, 2));
		jLabelNick = new JLabel("Nick: ");
		jFieldNick = new JTextField();
		jButtonConectar = new JButton("Conectar");
		jButtonDesconectar = new JButton("Desconectar");
		jButtonDesconectar.setEnabled(false);

		panelNorte.add(jLabelNick);
		panelNorte.add(jFieldNick);
		panelNorte.add(jButtonConectar);
		panelNorte.add(jButtonDesconectar);

		add(panelNorte, BorderLayout.NORTH);

		// PANEL CENTRO /////////////////
		jtaChat = new JTextArea(10,10);
		jtaChat.setEditable(false);
		panelCentro = new JScrollPane(jtaChat);

		add(panelCentro, BorderLayout.CENTER);

		// PANEL SUR /////////////////
		panelSur = new JPanel(new GridLayout(2,1));
		htFieldEnviar = new JTextField(10);
		jButtonEnviar = new JButton("Enviar");
		
		panelSur.add(htFieldEnviar);
		panelSur.add(jButtonEnviar);

		add(panelSur, BorderLayout.SOUTH);

	}

	public JTextField getjFieldNick() {
		return jFieldNick;
	}

	public JButton getjButtonConectar() {
		return jButtonConectar;
	}

	public JTextArea getJtaChat() {
		return jtaChat;
	}

	public JButton getjButtonDesconectar() {
		return jButtonDesconectar;
	}

	public JButton getjButtonEnviar() {
		return jButtonEnviar;
	}

	/**
	 * Añade el controlador
	 * @param actionListener
	 */
	void controlador(ActionListener actionListener) {
		
		jButtonConectar.addActionListener(actionListener);
		jButtonConectar.setActionCommand("CONECTAR");
		
		jButtonDesconectar.addActionListener(actionListener);
		jButtonDesconectar.setActionCommand("DESCONECTAR");
		
		jButtonEnviar.addActionListener(actionListener);
		jButtonEnviar.setActionCommand("ENVIAR");
	}
	
}
