package Windows.MovieScreening;

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
import Database.DbAdapterHall;
import Database.DbAdapterMovie;
import Database.DbAdapterMovieScreening;
import Models.Hall;
import Models.Movie;
import Windows.Common;
import javax.swing.JComboBox;

public class Create extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldPrice;
	private JTextField textFieldData;
	JComboBox<Movie> comboBox;
	JComboBox<Hall> comboBox_1;

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

		JLabel lblRepertuar = new JLabel("Tworzenie seansu");
		lblRepertuar.setBounds(100, 11, 201, 37);
		lblRepertuar.setForeground(new Color(204, 0, 153));
		lblRepertuar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRepertuar);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 71, 371, 54);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tytuł");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 12, 91, 23);
		panel_4.add(lblNewLabel_1);

		Movie[] array = DbAdapterMovie.selectMovies().toArray(new Movie[0]);
		Hall[] array1 = DbAdapterHall.selectHalls().toArray(new Hall[0]);

		MovieComboBox myModel = new MovieComboBox(array);
		comboBox = new JComboBox<>();
		comboBox.setModel(myModel);
		comboBox.setBounds(125, 14, 236, 22);
		panel_4.add(comboBox);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 136, 371, 54);
		panel_1.add(panel_4_1);

		JLabel lblNewLabel_1_1 = new JLabel("Cena");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 12, 123, 23);
		panel_4_1.add(lblNewLabel_1_1);

		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(126, 9, 235, 30);
		panel_4_1.add(textFieldPrice);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 368, 371, 47);
		panel_1.add(panel_4_1_1);

		JButton btnCreate = new JButton("UTWÓRZ");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movie movie = (Movie) comboBox.getSelectedItem();
				Hall hall = (Hall) comboBox_1.getSelectedItem();
				if ((textFieldData.getText().isEmpty() || textFieldPrice.getText().isEmpty() || movie == null
						|| hall == null)) {
					Common.showInfo(getContentPane(), "Puste pola tekstowe", "Nie wypełniono wszystkich pól");
				} else {

					DbAdapterMovieScreening.insertMovieScreening(movie.getId(), hall.getId(), textFieldData.getText(),

							Double.parseDouble(textFieldPrice.getText())

					);
					Common.showInfo(getContentPane(), "Zapisano pomyślnie", "Film został zapisany pomyślnie");
				}

			}
		});
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreate.setBackground(new Color(204, 0, 153));
		btnCreate.setBounds(104, 0, 181, 45);
		panel_4_1_1.add(btnCreate);

		JPanel panel_4_1_2 = new JPanel();
		panel_4_1_2.setLayout(null);
		panel_4_1_2.setBounds(0, 201, 371, 54);
		panel_1.add(panel_4_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Data i godzina");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2.add(lblNewLabel_1_1_1);

		textFieldData = new JTextField();
		textFieldData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldData.setColumns(10);
		textFieldData.setBounds(126, 9, 235, 30);
		panel_4_1_2.add(textFieldData);

		JPanel panel_4_1_2_1 = new JPanel();
		panel_4_1_2_1.setLayout(null);
		panel_4_1_2_1.setBounds(0, 266, 371, 54);
		panel_1.add(panel_4_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sala");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2_1.add(lblNewLabel_1_1_1_1);

		HallComboBox myModel1 = new HallComboBox(array1);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(myModel1);
		comboBox_1.setBounds(129, 14, 232, 22);
		panel_4_1_2_1.add(comboBox_1);

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

class MovieComboBox extends DefaultComboBoxModel<Movie> {
	public MovieComboBox(Movie[] items) {
		super(items);
	}

	@Override
	public Movie getSelectedItem() {
		Movie selectedJob = (Movie) super.getSelectedItem();

		return selectedJob;
	}
}

class HallComboBox extends DefaultComboBoxModel<Hall> {
	public HallComboBox(Hall[] items) {
		super(items);
	}

	@Override
	public Hall getSelectedItem() {
		Hall selectedJob = (Hall) super.getSelectedItem();

		return selectedJob;
	}
}