package Windows.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Database.DbAdapterUser;
import Windows.Common;
import javax.swing.JCheckBox;

public class Create extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldPassword;

	public Create() {
		setTitle("Tworzenie filmu - CinemaWorld");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 757, 509);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(376, 11, 371, 487);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRepertuar = new JLabel("Tworzenie użytkownika");
		lblRepertuar.setBounds(70, 11, 301, 37);
		lblRepertuar.setForeground(new Color(204, 0, 153));
		lblRepertuar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRepertuar);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 71, 371, 54);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 12, 91, 23);
		panel_4.add(lblNewLabel_1);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEmail.setBounds(126, 9, 235, 30);
		panel_4.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 136, 371, 54);
		panel_1.add(panel_4_1);

		JLabel lblNewLabel_1_1 = new JLabel("Numer telefonu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 12, 123, 23);
		panel_4_1.add(lblNewLabel_1_1);

		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(126, 9, 235, 30);
		panel_4_1.add(textFieldPhoneNumber);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 429, 371, 47);
		panel_1.add(panel_4_1_1);

		JButton btnCreate = new JButton("UTWÓRZ");

		btnCreate.setForeground(Color.BLACK);
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreate.setBackground(new Color(204, 0, 153));
		btnCreate.setBounds(104, 0, 181, 45);
		panel_4_1_1.add(btnCreate);

		JPanel panel_4_1_2 = new JPanel();
		panel_4_1_2.setLayout(null);
		panel_4_1_2.setBounds(0, 201, 371, 54);
		panel_1.add(panel_4_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Hasło");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2.add(lblNewLabel_1_1_1);

		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Symbol", Font.PLAIN, 15));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(126, 9, 235, 30);
		panel_4_1_2.add(textFieldPassword);

		JPanel panel_4_1_2_1 = new JPanel();
		panel_4_1_2_1.setLayout(null);
		panel_4_1_2_1.setBounds(0, 266, 371, 88);
		panel_1.add(panel_4_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Rola");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2_1.add(lblNewLabel_1_1_1_1);

		JCheckBox chckbxIsAdmin = new JCheckBox("adminstrator");
		chckbxIsAdmin.setBounds(131, 14, 97, 23);
		panel_4_1_2_1.add(chckbxIsAdmin);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(10, 11, 356, 67);
		panel.add(panel_2);

		JLabel lblNewLabel = new JLabel("CinemaWorld");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(204, 0, 153));
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 193, 356, 160);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnReturn = new JButton("WSTECZ");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Index frame = new Index();
				frame.setVisible(true);
			}
		});
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBackground(new Color(204, 0, 153));
		btnReturn.setBounds(0, 56, 356, 45);
		panel_3.add(btnReturn);

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((textFieldEmail.getText().isEmpty() || textFieldPhoneNumber.getText().isEmpty())
						|| textFieldPassword.getText().isEmpty()) {

					Common.showInfo(getContentPane(), "Puste pola tekstowe", "Nie wypełniono wszystkich pól");
				} else {

					if (DbAdapterUser.getUser(textFieldEmail.getText(), null) == null) {
						boolean isAdmin = chckbxIsAdmin.isSelected();

						DbAdapterUser.insertUser(textFieldEmail.getText(), textFieldPhoneNumber.getText(),
								textFieldPassword.getText(), Common.isAdmin(isAdmin)

						);
						Common.showInfo(getContentPane(), "Zapisano pomyślnie", "Film został zapisany pomyślnie");

					} else
						Common.showInfo(getContentPane(), "Nie zapisano pomyślnie",
								"Użytkownik o takim emailu już istnieje");
				}
			}
		});
	}
}