package Windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	public Main() {
		setTitle("CinemaWorld");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 757, 509);
		contentPane.add(panel);
		panel.setLayout(null);

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
		panel_3.setBounds(10, 97, 356, 399);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnManageMovies = new JButton("ZARZĄDZAJ FILMAMI");
		btnManageMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Windows.Movie.Index frame = new Windows.Movie.Index();
				frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnManageMovies.setForeground(Color.BLACK);
		btnManageMovies.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageMovies.setBackground(new Color(204, 0, 153));
		btnManageMovies.setBounds(0, 210, 356, 45);
		panel_3.add(btnManageMovies);

		JButton btnManageReservations = new JButton("ZARZĄDZAJ REZEREWACJAMI");
		btnManageReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Windows.Reservation.Index frame = new Windows.Reservation.Index();
				frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnManageReservations.setBounds(0, 38, 356, 45);
		panel_3.add(btnManageReservations);
		btnManageReservations.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageReservations.setForeground(Color.BLACK);
		btnManageReservations.setBackground(new Color(204, 0, 153));

		JButton btnManageHalls = new JButton("ZARZĄDZAJ SALAMI");
		btnManageHalls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Windows.Hall.Index frame = new Windows.Hall.Index();
				frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnManageHalls.setBounds(0, 266, 356, 45);
		panel_3.add(btnManageHalls);
		btnManageHalls.setForeground(Color.BLACK);
		btnManageHalls.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageHalls.setBackground(new Color(204, 0, 153));

		JButton btnManageMovieScreenings = new JButton("ZARZĄDZAJ SEANSAMI");
		btnManageMovieScreenings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Windows.MovieScreening.Index frame = new Windows.MovieScreening.Index();
				frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnManageMovieScreenings.setBounds(0, 322, 356, 45);
		panel_3.add(btnManageMovieScreenings);
		btnManageMovieScreenings.setForeground(Color.BLACK);
		btnManageMovieScreenings.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageMovieScreenings.setBackground(new Color(204, 0, 153));

		JButton btnManageUsers = new JButton("ZARZĄDZAJ UŻYTKOWNIKAMI");
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Windows.User.Index frame = new Windows.User.Index();
				frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnManageUsers.setForeground(Color.BLACK);
		btnManageUsers.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageUsers.setBackground(new Color(204, 0, 153));
		btnManageUsers.setBounds(0, 154, 356, 45);
		panel_3.add(btnManageUsers);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 0, 153));
		panel_4.setBounds(0, 126, 356, 17);
		panel_3.add(panel_4);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(new Color(204, 0, 153));
		panel_4_2.setBounds(0, 389, 356, 10);
		panel_3.add(panel_4_2);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBounds(0, 0, 356, 17);
		panel_3.add(panel_4_1);
		panel_4_1.setBackground(new Color(204, 0, 153));
	}
}