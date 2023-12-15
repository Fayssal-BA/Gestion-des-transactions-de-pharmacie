package Application;

import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.bson.*;

import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Menu_principal {

	private JFrame frmGestion;
	private JTextField txtCode;
	private JTextField txtNom;
	private JTextField TxtPrix;
	private JTextField txtTotal;
	private JTextField txtPayer;
	private JTextField TxtReste;
	private JTextField ClientCode;

	private JButton btnNewButton;
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
					Menu_principal window = new Menu_principal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private void initialize() {
		frmGestion = new JFrame();
		frmGestion.setAlwaysOnTop(true);
		frmGestion.setVisible(true);
		frmGestion.setTitle("Ventes de médicaments\r\n");
		frmGestion.setResizable(false);
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
		panell.setBounds(11, 95, 617, 194);
		panell.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmGestion.getContentPane().add(panell);
		panell.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Prix:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 87, 67, 35);
		panell.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Code:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 0, 67, 35);
		panell.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Nom:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(12, 45, 67, 35);
		panell.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Quantité:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(11, 127, 67, 35);
		panell.add(lblNewLabel_1_3);

		txtCode = new JTextField();
		txtCode.setBounds(93, 9, 153, 21);
		panell.add(txtCode);
		txtCode.setColumns(10);

		JLabel lblNewLabel_1_4 = new JLabel("IdClient:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(11, 160, 67, 35);
		panell.add(lblNewLabel_1_4);

		ClientCode = new JTextField();
		ClientCode.setBounds(93, 168, 153, 21);
		ClientCode.setColumns(10);
		panell.add(ClientCode);

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
		lblNewLabel_1_1_1.setBounds(347, 7, 67, 35);
		panell.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Payer:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(347, 48, 67, 35);
		panell.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Reste:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(347, 94, 67, 35);
		panell.add(lblNewLabel_1_1_3);

		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setForeground(Color.RED);
		txtTotal.setBackground(Color.BLACK);
		txtTotal.setColumns(10);
		txtTotal.setBounds(435, 14, 153, 21);
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
		txtPayer.setBounds(435, 55, 153, 21);
		panell.add(txtPayer);

		TxtReste = new JTextField();
		TxtReste.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtReste.setForeground(Color.BLUE);
		TxtReste.setHorizontalAlignment(SwingConstants.CENTER);
		TxtReste.setBackground(Color.GRAY);
		TxtReste.setColumns(10);
		TxtReste.setBounds(435, 101, 153, 21);
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

		btnNewButton = new JButton("Enregistrer");
		ModifyButton = new JButton("Modifier");
		DeleteButton = new JButton("Delete");
		RestoreButton = new JButton("Annuler");

		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(445, 136, 143, 23);
		ModifyButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ModifyButton.setBounds(285, 136, 143, 23);
		DeleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		DeleteButton.setBounds(445, 163, 143, 23);
		RestoreButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		RestoreButton.setBounds(285, 163, 143, 23);

		panell.add(btnNewButton);
		ModifyButton.setEnabled(false);
		DeleteButton.setEnabled(false);
		RestoreButton.setEnabled(false);
		panell.add(ModifyButton);
		panell.add(DeleteButton);
		panell.add(RestoreButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Dbase.ADD(ClientCode.getText(), txtCode.getText(), txtNom.getText(), TxtPrix.getText(),
						spinner.getValue().toString(), txtTotal.getText(), txtPayer.getText(), TxtReste.getText())) {
					JOptionPane.showMessageDialog(panell, txtNom.getText() + " a été ajouté avec succès");

				} else {
					JOptionPane.showMessageDialog(panell, txtNom.getText() + " n\'a pas été ajouté");

				}
				Liste();
				spinner.setValue(0);
				reload();

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 299, 616, 182);
		frmGestion.getContentPane().add(scrollPane);

		JMenuBar menuBar = new JMenuBar();
		frmGestion.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Accueil");
		menuBar.add(mnNewMenu);

		// ssssssssssssssssssssssssssssss

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

		// Ajoutez cette partie à la classe Menu_principal

		// ...

		// ssssssssssssssssssssssssssss

		JMenu mnNewMenu_1 = new JMenu("Selectionner une vente");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Séléctionner Par Code/Nom");

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Select_directly();
				frmGestion.setVisible(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		String[] columns = { "Code", "Nom", "Prix", "Quantité", "Total", "Payé", "Reste", "CodeClient" };
		tableModel = new DefaultTableModel(columns, 0);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		Liste();

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() != -1) {
					btnNewButton.setEnabled(false);
					txtCode.setEditable(false);
					ModifyButton.setEnabled(true);
					DeleteButton.setEnabled(true);
					RestoreButton.setEnabled(true);

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

					DeleteButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							btnNewButton.setEnabled(true);
							txtCode.setEditable(true);
							DeleteButton.setEnabled(false);
							ModifyButton.setEnabled(false);
							RestoreButton.setEnabled(false);
							if (Dbase.Delete(txtCode.getText())) {
								JOptionPane.showMessageDialog(panell, txtNom.getText() + " a été supprimé avec succès");

							} else {
								JOptionPane.showMessageDialog(panell, txtNom.getText() + " n\'a pas été supprimé");

							}
							Liste();
							reload();
							spinner.setValue(0);

						}
					});

					RestoreButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnNewButton.setEnabled(true);
							txtCode.setEditable(true);
							DeleteButton.setEnabled(false);
							ModifyButton.setEnabled(false);
							RestoreButton.setEnabled(false);
							
							spinner.setValue(0);
							reload();
							
							Liste();
						}
					});

					int selectedRow = table.getSelectedRow();
					String code = table.getValueAt(selectedRow, 0).toString();
					String nom = table.getValueAt(selectedRow, 1).toString();
					String prix = table.getValueAt(selectedRow, 2).toString();
					String qte = table.getValueAt(selectedRow, 3).toString();
					String total = table.getValueAt(selectedRow, 4).toString();
					String payer = table.getValueAt(selectedRow, 5).toString();
					String reste = table.getValueAt(selectedRow, 6).toString();
					String CodeClient = table.getValueAt(selectedRow, 7).toString();

					txtCode.setText(code);
					txtNom.setText(nom);
					TxtPrix.setText(prix);
					spinner.setValue(Integer.parseInt(qte));
					txtTotal.setText(total);
					txtPayer.setText(payer);
					TxtReste.setText(reste);
					ClientCode.setText(CodeClient);

				}

			}
		}

		);

	}
	

	private void Liste() {
		tableModel.setRowCount(0);
		try {
			List<Document> liste = Dbase.getSells();
			 String temp;
			for (Document d : liste) {
				
				temp = (((Document)d.get("ClientInfo"))!= null ) ? ((Document)d.get("ClientInfo")).getString("codeClient") : "";
			 
				tableModel.addRow(new Object[] { d.getString("Code"), d.getString("Nom"), d.getString("Prix"),
						d.getString("QTE"), d.getString("Total"), d.getString("Payer"), d.getString("Reste"),temp});

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void reload() {

		txtCode.setText(null);
		TxtPrix.setText(null);
		txtNom.setText(null);
		txtTotal.setText(null);
		txtPayer.setText(null);
		TxtReste.setText(null);
		
		ClientCode.setText(null);

	}
}
