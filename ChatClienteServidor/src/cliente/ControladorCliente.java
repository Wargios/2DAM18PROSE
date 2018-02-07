package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCliente implements ActionListener {

	private Cliente cliente;
	private VistaCliente vistaCliente;

	public ControladorCliente(Cliente cliente, VistaCliente vistaCliente) {
		this.cliente = cliente;
		this.vistaCliente = vistaCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "CONECTAR":
			if (cliente.startClient(vistaCliente)) {
				vistaCliente.getjButtonConectar().setEnabled(false);
				vistaCliente.getjButtonDesconectar().setEnabled(true);
				vistaCliente.getjFieldNick().setEditable(false);
			}
			break;

		case "DESCONECTAR":
			if (cliente.stopClient()) {
				vistaCliente.getjButtonConectar().setEnabled(true);
				vistaCliente.getjButtonDesconectar().setEnabled(false);
				vistaCliente.getjFieldNick().setEditable(true);
			}
			break;

		case "ENVIAR":

			break;

		default:

			break;
		}

	}

}
