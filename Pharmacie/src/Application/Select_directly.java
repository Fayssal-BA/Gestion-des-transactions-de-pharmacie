package Application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.bson.Document;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Select_directly {

	private JFrame frmGestion;
	private JTextField txtCode;
	private JTextField txtNom;
	private JTextField TxtPrix;
	private JTextField txtTotal;
	private JTextField txtPayer;
	private JTextField TxtReste;
	private JTextField Clientcode;

	private JButton btnNewButton;
	private JButton ModifyButton;
	private JButton DeleteButton;
	private JButton RestoreButton;

	private static final long serialVersionUID = 1L;
	private final JLabel lblNewLabel_2 = new JLabel("Code:");
	private JTextField SearchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Select_directly();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Select_directly() {

		frmGestion = new JFrame();
		frmGestion.setAlwaysOnTop(true);
		frmGestion.setTitle("Ventes de médicaments\r\n");
		frmGestion.setResizable(false);
		frmGestion.setVisible(true);
		frmGestion.setBounds(100, 100, 652, 544);
		frmGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestion.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(11, 14, 616, 71);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmGestion.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("GESTION DE PHARMACIE ");
		lblNewLabel.setBounds(0, 0, 616, 71);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel panell = new JPanel();
		panell.setBounds(11, 95, 616, 194);
		panell.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmGestion.getContentPane().add(panell);
		panell.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Prix:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 87, 67, 35);
		panell.add(lblNewLabel_1);

		JLabel lblNewLabe = new JLabel("Code client:");
		lblNewLabe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabe.setBounds(10, 155, 120, 35);
		panell.add(lblNewLabe);

		JLabel lblNewLabel_1_1 = new JLabel("Code:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 0, 67, 35);
		panell.add(lblNewLabel_1_1);

		Clientcode = new JTextField();
		Clientcode.setBounds(93, 163 , 153, 21);
		panell.add(Clientcode);
		Clientcode.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Nom:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(12, 45, 67, 35);
		panell.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Quantité:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(11, 127, 67, 35);
		panell.add(lblNewLabel_1_3);

		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setBounds(93, 9, 153, 21);
		panell.add(txtCode);
		txtCode.setColumns(10);

		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(93, 50, 153, 21);
		panell.add(txtNom);

		TxtPrix = new JTextField();
		TxtPrix.setColumns(10);
		TxtPrix.setBounds(93, 96, 153, 21);
		panell.add(TxtPrix);

		JLabel lblNewLabel_1_1_1 = new JLabel("Total:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(354, 10, 67, 35);
		panell.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Payer:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(354, 51, 67, 35);
		panell.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Reste:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(354, 97, 67, 35);
		panell.add(lblNewLabel_1_1_3);

		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setForeground(Color.RED);
		txtTotal.setBackground(Color.BLACK);
		txtTotal.setColumns(10);
		txtTotal.setBounds(453, 14, 153, 21);
		panell.add(txtTotal);

		txtPayer = new JTextField();
		txtPayer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int total = Integer.parseInt(txtTotal.getText());
				int payer = Integer.parseInt(txtPayer.getText());
				int reste = total - payer;
				TxtReste.setText(String.valueOf(reste));

			}
		});

		txtPayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPayer.setForeground(Color.WHITE);
		txtPayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtPayer.setBackground(Color.GREEN);
		txtPayer.setColumns(10);
		txtPayer.setBounds(453, 59, 153, 21);
		panell.add(txtPayer);

		TxtReste = new JTextField();
		TxtReste.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtReste.setForeground(Color.BLUE);
		TxtReste.setHorizontalAlignment(SwingConstants.CENTER);
		TxtReste.setBackground(Color.GRAY);
		TxtReste.setColumns(10);
		TxtReste.setBounds(453, 101, 153, 21);
		panell.add(TxtReste);

		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				int prix = Integer.parseInt(TxtPrix.getText());
				int qte = Integer.parseInt(spinner.getValue().toString());
				int total = prix * qte;
				txtTotal.setText(String.valueOf(total));
			}
		});
		spinner.setBounds(93, 136, 153, 21);
		panell.add(spinner);
		ModifyButton = new JButton("Modifier");
		ModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DeleteButton = new JButton("Delete");
		RestoreButton = new JButton("Effacer");
		RestoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ModifyButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ModifyButton.setBounds(310, 134, 143, 23);
		DeleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		DeleteButton.setBounds(463, 134, 143, 23);
		RestoreButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		RestoreButton.setBounds(463, 161, 143, 23);
		ModifyButton.setEnabled(false);
		DeleteButton.setEnabled(false);
		RestoreButton.setEnabled(false);
		panell.add(ModifyButton);
		panell.add(DeleteButton);
		panell.add(RestoreButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(11, 299, 617, 116);
		frmGestion.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnNewButton = new JButton("Chercher");
		btnNewButton.setBounds(258, 60, 143, 29);
		panel_1.add(btnNewButton);

		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(116, 10, 71, 36);
		panel_1.add(lblNewLabel_2);

		SearchField = new JTextField();
		SearchField.setBounds(221, 18, 180, 27);
		panel_1.add(SearchField);
		SearchField.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		frmGestion.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Accueil");
		menuBar.add(mnNewMenu);

		JMenu mnNewClient = new JMenu("Clients");
		mnNewMenu.add(mnNewClient);

		JMenuItem ajout = new JMenuItem("Ajouter un client");

		ajout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NouveauClientForm();
				frmGestion.setVisible(false);
			}
		});
		mnNewClient.add(ajout);

		JMenu mnNewMenu_1 = new JMenu("Selectionner une vente");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Séléctionner sur tableau");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Menu_principal();
				frmGestion.setVisible(false);

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = Dbase.getOne(SearchField.getText());
				if (document != null) {
					enableBtns();
					String code = document.getString("Code");
					String nom = document.getString("Nom");
					String prix = document.getString("Prix");
					String qte = document.getString("QTE");
					String total = document.getString("Total");
					String payer = document.getString("Payer");
					String reste = document.getString("Reste");
					String clientCode = ((Document) document.get("ClientInfo")).getString("codeClient")  ;

					txtCode.setText(code);
					txtNom.setText(nom);
					TxtPrix.setText(prix);
					spinner.setValue(Integer.parseInt(qte));
					txtTotal.setText(total);
					txtPayer.setText(payer);
					TxtReste.setText(reste);
					Clientcode.setText(clientCode);
					
					JOptionPane.showMessageDialog(panell, SearchField.getText() + " a été trouvé");
					SearchField.setText(null);

				} else {
					disableBtns();
					spinner.setValue(0);
					reload();
					JOptionPane.showMessageDialog(panell, SearchField.getText() + " n\'a pas été trouvé");

				}
			}
		});

		RestoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableBtns();
				spinner.setValue(0);
				reload();
				
			}
		});

		ModifyButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				disableBtns();
				if (Dbase.Modify(txtCode.getText(), txtNom.getText(), TxtPrix.getText(), spinner.getValue().toString(),
						txtTotal.getText(), txtPayer.getText(), TxtReste.getText(), Clientcode.getText())) {
					JOptionPane.showMessageDialog(panell, txtCode.getText() + " a été modifé avec succès");

				} else {
					JOptionPane.showMessageDialog(panell, txtCode.getText() + " n\'a pas été modifié");

				}
				spinner.setValue(0);
				reload();
				

			}
		});

		DeleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				disableBtns();
				if (Dbase.Delete(txtCode.getText())) {
					JOptionPane.showMessageDialog(panell, txtNom.getText() + " a été supprimé avec succès");

				} else {
					JOptionPane.showMessageDialog(panell, txtNom.getText() + " n\'a pas été supprimé");

				}
				spinner.setValue(0);
				reload();
				

			}
		});

	}

	private void reload() {

		txtCode.setText(null);
		TxtPrix.setText(null);
		txtNom.setText(null);
		txtTotal.setText(null);
		txtPayer.setText(null);
		TxtReste.setText(null);
		SearchField.setText(null);
		Clientcode.setText(null);

	}

	private void disableBtns() {
		ModifyButton.setEnabled(false);
		DeleteButton.setEnabled(false);
		RestoreButton.setEnabled(false);
	}

	private void enableBtns() {
		ModifyButton.setEnabled(true);
		DeleteButton.setEnabled(true);
		RestoreButton.setEnabled(true);
	}
}
