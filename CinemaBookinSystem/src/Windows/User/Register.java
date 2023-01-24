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
import Models.User;
import Windows.Common;
import Windows.Login;

public class Register extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldPassword;

	public Register() {
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

		JLabel lblRepertuar = new JLabel("Rejestracja");
		lblRepertuar.setBounds(100, 11, 201, 37);
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

		JButton btnRegister = new JButton("REJESTRUJ");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textFieldEmail.getText().isEmpty() || textFieldPhoneNumber.getText().isEmpty())
						|| textFieldPassword.getText().isEmpty()) {

					Common.showInfo(getContentPane(), "Puste pola tekstowe", "Nie wypełniono wszystkich pól");
				} else {

					if (DbAdapterUser.getUser(textFieldEmail.getText(), null) == null) {
						boolean isAdmin = false;

						DbAdapterUser.insertUser(textFieldEmail.getText(), textFieldPhoneNumber.getText(),
								textFieldPassword.getText(), Common.isAdmin(isAdmin)

						);
						Common.showInfo(getContentPane(), "Zapisano pomyślnie",
								"Rejestracja zakończyła się pomyślnie. Zostaniesz automatycznie zalogowany po kliknięciu OK.");
						User user = DbAdapterUser.getUser(textFieldEmail.getText(), textFieldPassword.getText());
						
						Login.userContext = user;
						setVisible(false);
						dispose();
						Common.getMainWindow(user);

					} else
						Common.showInfo(getContentPane(), "Nie zapisano pomyślnie",
								"Użytkownik o takim emailu już istnieje");
				}
			}
		});
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBackground(new Color(204, 0, 153));
		btnRegister.setBounds(104, 0, 181, 45);
		panel_4_1_1.add(btnRegister);

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

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(10, 11, 356, 67);
		panel.add(panel_2);

		JLabel lblNewLabel = new JLabel("CinemaWorld");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(204, 0, 153));
		panel_2.add(lblNewLabel);
	}
}
