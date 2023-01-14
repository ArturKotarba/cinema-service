package Windows.Reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Database.DbAdapterMovieScreening;
import Database.DbAdapterReservation;
import Models.MovieScreening;
import Windows.Common;
import javax.swing.JComboBox;

public class Create extends JFrame {

	private JPanel contentPane;
	private JTextField textNumberOfTickets;
	JComboBox comboBox;

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

		JLabel lblRepertuar = new JLabel("Tworzenie rezerwacji");
		lblRepertuar.setBounds(86, 11, 301, 37);
		lblRepertuar.setForeground(new Color(204, 0, 153));
		lblRepertuar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRepertuar);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 71, 371, 54);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Seans");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 12, 91, 23);
		panel_4.add(lblNewLabel_1);

		MovieScreening[] array = DbAdapterMovieScreening.selectMovieScreenings2().toArray(new MovieScreening[0]);

		MovieScreeningComboBox myModel = new MovieScreeningComboBox(array);
		comboBox = new JComboBox<>();
		comboBox.setModel(myModel);

		comboBox.setBounds(124, 14, 237, 22);
		panel_4.add(comboBox);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 368, 371, 47);
		panel_1.add(panel_4_1_1);

		JButton btnReserve = new JButton("REZERWUJ");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int freeSeats = -1;
				MovieScreening movie = (MovieScreening) comboBox.getSelectedItem();

				if (textNumberOfTickets.getText().isEmpty() || movie == null) {
					Common.showInfo(getContentPane(), "Puste pola tekstowe", "Nie wypełniono wszystkich pól");
				} else {
					freeSeats = DbAdapterReservation.getNumberFreeSeats(movie.getId());
					if(freeSeats >= Integer.parseInt(textNumberOfTickets.getText())) {
					
					DbAdapterReservation.insertReservation(movie.getId(), Common.getUserFromContext().getId(),
							Common.isSelected2(false), Integer.parseInt(textNumberOfTickets.getText()),
							Common.isSelected2(true));
	
					Common.showInfo(getContentPane(), "Zapisano pomyślnie", "Film został zapisany pomyślnie");
				}
					else {
						Common.showInfo(getContentPane(), "Brak dostępności miejsc. Obecnie jest dostępne jedynie: "+ freeSeats,"Brak dostępności miejsc");
					}
			}
		}});
		btnReserve.setForeground(Color.BLACK);
		btnReserve.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReserve.setBackground(new Color(204, 0, 153));
		btnReserve.setBounds(104, 0, 181, 45);
		panel_4_1_1.add(btnReserve);

		JPanel panel_4_1_2_1 = new JPanel();
		panel_4_1_2_1.setLayout(null);
		panel_4_1_2_1.setBounds(0, 136, 371, 54);
		panel_1.add(panel_4_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Liczba biletów");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2_1.add(lblNewLabel_1_1_1_1);

		textNumberOfTickets = new JTextField();
		textNumberOfTickets.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNumberOfTickets.setColumns(10);
		textNumberOfTickets.setBounds(126, 9, 235, 30);
		panel_4_1_2_1.add(textNumberOfTickets);

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
	}
}

class MovieScreeningComboBox extends DefaultComboBoxModel<MovieScreening> {
	public MovieScreeningComboBox(MovieScreening[] items) {
		super(items);
	}

	@Override
	public MovieScreening getSelectedItem() {
		MovieScreening selectedJob = (MovieScreening) super.getSelectedItem();

		return selectedJob;
	}
}