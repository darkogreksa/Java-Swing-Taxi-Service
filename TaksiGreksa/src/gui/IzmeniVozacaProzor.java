package gui;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IzmeniVozacaProzor extends JFrame{
	
	private JLabel lblImeKorisnika;
	private JTextField txtImeKorisnika;

	private JLabel lblPrezime;
	private JTextField txtPrezime;

	private JLabel lblJmbg;
	private JTextField txtJmbg;

	private JLabel lblAdresa;
	private JTextField txtAdresa;

	private JLabel lblPol;
	private JComboBox cbPol;

	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;

	private JLabel lblLozinka;
	private JTextField txtLozinka;

	private JLabel lblPlata;
	private JTextField txtPlata;
	
	private JLabel lblBrojClanskeKarte;
	private JTextField txtBrojClanskeKarte;

	private JLabel lblVozilo;
	private JComboBox cbVozilo;
	
	public IzmeniVozacaProzor() {
		setTitle("Dodavanje korisnika");
		ImageIcon ikonica = new ImageIcon(LoginProzor.class.getResource("/ikonice/faketaxi.png"));
		setIconImage(ikonica.getImage());
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
	}

	private void initActions() {
		// TODO Auto-generated method stub
		
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		
	}

}
