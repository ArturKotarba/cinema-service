package Windows.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Windows.Common;
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

		JPanel panelCinema = new JPanel();
		panelCinema.setBackground(new Color(0, 0, 0));
		panelCinema.setBounds(10, 11, 356, 67);
		panel.add(panelCinema);

		JLabel lblNewLabel = new JLabel("Cinema");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(204, 0, 153));
		panelCinema.add(lblNewLabel);

		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(Color.BLACK);
		panelButtons.setBounds(10, 156, 356, 342);
		panel.add(panelButtons);
		panelButtons.setLayout(null);

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
		panelButtons.add(btnMyReservations);

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
		panelButtons.add(btnReserve);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(new Color(204, 0, 153));
		panel_4_2.setBounds(0, 0, 356, 10);
		panelButtons.add(panel_4_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 332, 356, 10);
		panelButtons.add(panel_4);
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
		panelButtons.add(btnMovies);

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
		panelButtons.add(btnActiveMovieScreening);
	}
}
