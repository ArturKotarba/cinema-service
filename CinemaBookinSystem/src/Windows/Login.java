package Windows;

import Database.DbAdapterHall;
import Database.DbAdapterMovie;
import Database.DbAdapterMovieScreening;
import Database.DbAdapterReservation;
import Database.DbAdapterUser;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Models.User;
import Windows.User.Register;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldEmail, textFieldPassword;
	public static User userContext;

	public static void main(String[] args) {
//uruchamiaja sie dwa okna, ktore wspoldziela watki
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		CreateDatabaseAndUsers();
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

		JLabel lblRepertuar = new JLabel("Logowanie");
		lblRepertuar.setBounds(100, 11, 201, 37);
		lblRepertuar.setForeground(new Color(204, 0, 153));
		lblRepertuar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRepertuar);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 71, 371, 54);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(10, 12, 91, 23);
		panel_4.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEmail.setBounds(126, 9, 235, 30);
		panel_4.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 219, 371, 47);
		panel_1.add(panel_4_1_1);

		JButton btnLogin = new JButton("ZALOGUJ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userContext = DbAdapterUser.getUser(textFieldEmail.getText().toString(),
						textFieldPassword.getText().toString());
				if (userContext != null) {
					Common.getMainWindow(userContext);
					setVisible(false);
					dispose();

				} else
					Common.showInfo(getContentPane(),
							"Użytkownik o takim emailu nie istnieje lub wprowadzone hasło jest niepoprawne",
							"Nie zalogowano pomyślnie");
			}

		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBackground(new Color(204, 0, 153));
		btnLogin.setBounds(104, 0, 181, 45);
		panel_4_1_1.add(btnLogin);

		JPanel panel_4_1_2 = new JPanel();
		panel_4_1_2.setLayout(null);
		panel_4_1_2.setBounds(0, 136, 371, 54);
		panel_1.add(panel_4_1_2);

		JLabel lblPassword = new JLabel("Hasło");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 12, 123, 23);
		panel_4_1_2.add(lblPassword);

		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Symbol", Font.PLAIN, 15));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(126, 9, 235, 30);
		panel_4_1_2.add(textFieldPassword);

		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setLayout(null);
		panel_4_1_1_1.setBounds(0, 298, 371, 47);
		panel_1.add(panel_4_1_1_1);

		JButton btnRegister = new JButton("PRZEJDZ DO REJESTRACJI");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Register frame = new Register();
				frame.setVisible(true);
			}
		});
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnRegister.setBackground(new Color(204, 0, 153));
		btnRegister.setBounds(103, 0, 181, 45);
		panel_4_1_1_1.add(btnRegister);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(10, 11, 356, 67);
		panel.add(panel_2);

		JLabel lblLabel = new JLabel("CinemaWorld");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblLabel.setForeground(new Color(204, 0, 153));
		panel_2.add(lblLabel);
	}

//metoda ktora pozwala na utworzenie nowego pliku z bazą od podstaw - po uruchomieniu trzeba zakomentowac!
	private static void CreateDatabaseAndUsers() {
	/*
	 DbAdapterHall.createTable();
		  
		  DbAdapterMovie.createTable();
		  
		  DbAdapterMovieScreening.createTable();
		  
		  DbAdapterReservation.createTable();
		  
		  DbAdapterUser.createTable();
		  
		  DbAdapterUser.insertUser("admin@bs.pl", "123456789","haslo",
		  "administrator"); DbAdapterUser.insertUser("user@bs.pl", "123456789","haslo",
		  "uzytkownik");
		  
		  
		  DbAdapterMovie.insertMovie("FILM1", "OPIS", "", 1, 90, "");*/
		 
	}
}