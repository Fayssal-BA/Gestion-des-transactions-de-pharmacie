package Application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class NouveauClientForm {

	private JFrame frmGestion;
	private JTextField txtPrenom;
	private JTextField txtCodeClient;
	private JTextField txtNom;
	private JTextField txtPhone;
	private JTextField txtAdresse;

	/*
	 * private JButton ModifyButton; private JButton DeleteButton; private JButton
	 * RestoreButton;
	 */

	private JButton enregitreButton;
	private JButton ModifyButton;
	private JButton DeleteButton;
	private JButton RestoreButton;

	private DefaultTableModel tableModel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new NouveauClientForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NouveauClientForm() {

		frmGestion = new JFrame();
		frmGestion.setAlwaysOnTop(true);
		frmGestion.setTitle("Enregistrement des clients\r\n");
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

		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setBounds(0, 0, 616, 71);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel panell = new JPanel();
		panell.setBounds(11, 95, 616, 194);
		panell.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmGestion.getContentPane().add(panell);
		panell.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Phone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 87, 67, 35);
		panell.add(lblNewLabel_1);

		JLabel lblNewLabel_ = new JLabel("CodeClient:");
		lblNewLabel_.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_.setBounds(290, 1, 100, 35);
		panell.add(lblNewLabel_);

		txtCodeClient = new JTextField();
		txtCodeClient.setBounds(400, 9, 153, 21);
		panell.add(txtCodeClient);
		txtCodeClient.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Prénom:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 0, 67, 35);
		panell.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Nom:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(12, 45, 67, 35);
		panell.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Adresse:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(11, 130, 67, 35);
		panell.add(lblNewLabel_1_3);

		txtPrenom = new JTextField();
		// txtCode.setEditable(false);
		txtPrenom.setBounds(93, 9, 153, 21);
		panell.add(txtPrenom);
		txtPrenom.setColumns(10);

		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(93, 50, 153, 21);
		panell.add(txtNom);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(93, 96, 153, 21);
		panell.add(txtPhone);

		txtAdresse = new JTextField();
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(93, 142, 153, 21);
		panell.add(txtAdresse);

		/*
		 * 
		 * ModifyButton = new JButton("Modifier"); ModifyButton.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) { } });
		 * DeleteButton = new JButton("Delete"); RestoreButton = new JButton("Effacer");
		 * RestoreButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { } }); ModifyButton.setFont(new
		 * Font("Times New Roman", Font.PLAIN, 16)); ModifyButton.setBounds(310, 134,
		 * 143, 23); DeleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 * DeleteButton.setBounds(463, 134, 143, 23); RestoreButton.setFont(new
		 * Font("Times New Roman", Font.PLAIN, 16)); RestoreButton.setBounds(463, 161,
		 * 143, 23); ModifyButton.setEnabled(false); DeleteButton.setEnabled(false);
		 * RestoreButton.setEnabled(false); panell.add(ModifyButton);
		 * panell.add(DeleteButton); panell.add(RestoreButton);
		 * 
		 * 
		 * 
		 * JMenuBar menuBar = new JMenuBar(); frmGestion.setJMenuBar(menuBar);
		 * 
		 * JMenu mnNewMenu = new JMenu("Accueil"); menuBar.add(mnNewMenu);
		 * 
		 * JMenu mnNewMenu_1 = new JMenu("Selectionner une vente");
		 * mnNewMenu.add(mnNewMenu_1);
		 * 
		 * JMenuItem mntmNewMenuItem = new JMenuItem("Séléctionner sur tableau");
		 * mntmNewMenuItem.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { new Menu_principal();
		 * frmGestion.setVisible(false);
		 * 
		 * } }); mnNewMenu_1.add(mntmNewMenuItem);
		 * 
		 * JMenuItem mntmNewMenuItem_1 = new JMenuItem("Séléctionner Par Code/Nom");
		 * mnNewMenu_1.add(mntmNewMenuItem_1);
		 * 
		 * 
		 * /* RestoreButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { //disableBtns(); reload();
		 * 
		 * } }); /* ModifyButton.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { //disableBtns(); if
		 * (Dbase.Modify(txtCode.getText(), txtNom.getText(), TxtPrix.getText(),
		 * TxtQuantite.getText())) { JOptionPane.showMessageDialog(panell,
		 * txtCode.getText() + " a été modifé avec succès");
		 * 
		 * } else { JOptionPane.showMessageDialog(panell, txtCode.getText() +
		 * " n\'a pas été modifié");
		 * 
		 * } reload();
		 * 
		 * 
		 * } });
		 */
		/*
		 * DeleteButton.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { //disableBtns(); if
		 * (Dbase.Delete(txtCode.getText())) { JOptionPane.showMessageDialog(panell,
		 * txtNom.getText() + " a été supprimé avec succès");
		 * 
		 * } else { JOptionPane.showMessageDialog(panell, txtNom.getText() +
		 * " n\'a pas été supprimé");
		 * 
		 * } reload();
		 * 
		 * 
		 * } });
		 */

		enregitreButton = new JButton("Enregistrer");
		ModifyButton = new JButton("Modifier");
		DeleteButton = new JButton("Delete");
		RestoreButton = new JButton("Annuler");

		enregitreButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		enregitreButton.setBounds(445, 136, 143, 23);
		ModifyButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ModifyButton.setBounds(285, 136, 143, 23);
		DeleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		DeleteButton.setBounds(445, 163, 143, 23);
		RestoreButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		RestoreButton.setBounds(285, 163, 143, 23);

		panell.add(enregitreButton);
		ModifyButton.setEnabled(false);
		DeleteButton.setEnabled(false);
		RestoreButton.setEnabled(false);
		panell.add(ModifyButton);
		panell.add(DeleteButton);
		panell.add(RestoreButton);

		// BUTTON ENREGISTRER

		enregitreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Dbase.ajouter(txtCodeClient.getText(), txtPrenom.getText(), txtNom.getText(), txtPhone.getText(),
						txtAdresse.getText())) {
					JOptionPane.showMessageDialog(panell,
							txtNom.getText() + " " + txtPrenom.getText()  + " a été ajouté avec succès");

				} else {
					JOptionPane.showMessageDialog(panell, txtPrenom.getText()  +" " + txtNom.getText() +" n\'a pas été ajouté");

				}
				Liste();
				reload();

			}

		});

		// CREER LE MENU

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 299, 616, 182);
		frmGestion.getContentPane().add(scrollPane);

		JMenuBar menuBar = new JMenuBar();
		frmGestion.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Accueil");
		menuBar.add(mnNewMenu);

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

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Séléctionner Par Code/Nom");
		
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Select_directly();
				frmGestion.setVisible(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		// pour afficher les clients
		
		

		String[] columns = { "Code" , "Prénom", "Nom", "Phone", "Adresse" };
		tableModel = new DefaultTableModel(columns, 0);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		Liste();

		
		/*
		 * 
		 * 
		 * 
		 
	
			

					ModifyButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							btnNewButton.setEnabled(true);
							txtCode.setEditable(true);
							ModifyButton.setEnabled(false);
							DeleteButton.setEnabled(false);
							RestoreButton.setEnabled(false);
							if (Dbase.Modify(txtCode.getText(), txtNom.getText(), TxtPrix.getText(),
									spinner.getValue().toString(), txtTotal.getText(), txtPayer.getText(),
									TxtReste.getText(),ClientCode.getText())) {
								JOptionPane.showMessageDialog(panell, txtNom.getText() + " a été modifé avec succès");

							} else {
								JOptionPane.showMessageDialog(panell, txtNom.getText() + " n\'a pas été modifié");

							}
							Liste();
							spinner.setValue(0);
							reload();

						}
					});

		 */
		
		
		// LES AUTRES BUTTON APPRES LA SELECTION DANS LE TABLEAU ::

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() != -1) {
					enregitreButton.setEnabled(false);
					txtCodeClient.setEditable(false);
					ModifyButton.setEnabled(true);
					DeleteButton.setEnabled(true);
					RestoreButton.setEnabled(true);

					ModifyButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							enregitreButton.setEnabled(true);
							txtCodeClient.setEditable(true);
							ModifyButton.setEnabled(false);
							DeleteButton.setEnabled(false);
							RestoreButton.setEnabled(false);
							if (Dbase.modifie(txtCodeClient.getText() ,txtPrenom.getText(), txtNom.getText(), txtPhone.getText(),
									txtAdresse.getText())) {
								JOptionPane.showMessageDialog(panell,
										txtPrenom.getText()  +" " + txtNom.getText() + " a été modifé avec succès");
								System.out.print("modifie  ùùù");

							} else if (!txtPrenom.getText().equals("") && txtPrenom.getText().equals("")) {
								JOptionPane.showMessageDialog(panell, txtPrenom.getText() +" " + txtNom.getText() +" n\'a pas été modifié");
								System.out.print("pas modifie");

							}
							Liste();
							reload();
							System.out.print("fin");

						}
					});

					DeleteButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							enregitreButton.setEnabled(true);
							txtCodeClient.setEditable(true);
							DeleteButton.setEnabled(false);
							ModifyButton.setEnabled(false);
							RestoreButton.setEnabled(false);
							
							if (Dbase.supprimer(txtCodeClient.getText()) && !txtCodeClient.getText().equals("")) {
								JOptionPane.showMessageDialog(panell,
										txtPrenom.getText()  +" " + txtNom.getText()  + " a été supprimé avec succès");

							} /*else {
								JOptionPane.showMessageDialog(panell,
										txtPrenom.getText()  +" " + txtNom.getText() + " n\'a pas été supprimé");

							}*/
							Liste();
							reload();

						}
					});

					RestoreButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							enregitreButton.setEnabled(true);
							txtCodeClient.setEditable(true);
							DeleteButton.setEnabled(false);
							ModifyButton.setEnabled(false);
							RestoreButton.setEnabled(false);

							reload();

							Liste();
						}
					});

					int selectedRow = table.getSelectedRow();
					String code = table.getValueAt(selectedRow, 0).toString();
					String prenom = table.getValueAt(selectedRow, 1).toString();

					String nom = table.getValueAt(selectedRow, 2).toString();
					String prix = table.getValueAt(selectedRow, 3).toString();
					String adresse = table.getValueAt(selectedRow, 4).toString();

					
					txtCodeClient.setText(code);
					txtPrenom.setText(prenom);
					txtNom.setText(nom);
					txtPhone.setText(prix);
					txtAdresse.setText(adresse);

				}

			}
		}

		);

	}// fin De LA CLASSE

	private void reload() {

		txtPrenom.setText(null);
		txtPhone.setText(null);
		txtNom.setText(null);
		txtAdresse.setText(null);
		txtCodeClient.setText(null);

	}

	private void Liste() {
		tableModel.setRowCount(0);
		try {
			List<Document> liste = Dbase.getSellsClients();

			for (Document d : liste) {
				tableModel.addRow(new Object[] { d.getString("codeClient"), d.getString("Prénom"), d.getString("Nom"), d.getString("Phone"),
						d.getString("Adresse") });

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
