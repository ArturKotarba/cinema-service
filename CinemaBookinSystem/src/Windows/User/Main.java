package Windows.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Windows.Common;
import Windows.Login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	private JPanel contentPane;
	
	public static void main(String[] args) {

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


	public Main() {
		setTitle("CinemaWorld");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 548);
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
		panel_3.setBounds(10, 156, 356, 342);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnMyReservations = new JButton("MOJE REZERWACJE");
		btnMyReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Windows.Reservation.MyReservations frame = new Windows.Reservation.MyReservations();
						
				frame.setVisible(true);
			}
		});
		btnMyReservations.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMyReservations.setForeground(Color.BLACK);
		btnMyReservations.setBackground(new Color(204, 0, 153));
		btnMyReservations.setBounds(0, 102, 356, 45);
		panel_3.add(btnMyReservations);

		JButton btnReserve = new JButton("REZERWUJ");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Windows.Reservation.Create frame = new Windows.Reservation.Create();
				frame.setVisible(true);
			}
		});
		btnReserve.setForeground(Color.BLACK);
		btnReserve.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReserve.setBackground(new Color(204, 0, 153));
		btnReserve.setBounds(0, 263, 356, 45);
		panel_3.add(btnReserve);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(new Color(204, 0, 153));
		panel_4_2.setBounds(0, 0, 356, 10);
		panel_3.add(panel_4_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 332, 356, 10);
		panel_3.add(panel_4);
		panel_4.setBackground(new Color(204, 0, 153));

		JButton btnMovies = new JButton("FILMY");
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Windows.Movie.ActiveMovies frame = new Windows.Movie.ActiveMovies();
				frame.setVisible(true);

			}
		});
		btnMovies.setForeground(Color.BLACK);
		btnMovies.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMovies.setBackground(new Color(204, 0, 153));
		btnMovies.setBounds(0, 46, 356, 45);
		panel_3.add(btnMovies);

		JButton btnActiveMovieScreening = new JButton("REPERTUAR");
		btnActiveMovieScreening.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				Windows.MovieScreening.ActiveMovieScreening frame = new Windows.MovieScreening.ActiveMovieScreening();
				frame.setVisible(true);
			}
		});
		btnActiveMovieScreening.setForeground(Color.BLACK);
		btnActiveMovieScreening.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnActiveMovieScreening.setBackground(new Color(204, 0, 153));
		btnActiveMovieScreening.setBounds(0, 158, 356, 45);
		panel_3.add(btnActiveMovieScreening);
	}
}
