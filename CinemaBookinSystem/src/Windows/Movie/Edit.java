package Windows.Movie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Database.DbAdapterMovie;
import Models.Movie;
import Windows.Common;
import Windows.Reservation.Index;


public class Edit extends JFrame {
	private int id;
	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldDescription;
	private JTextField textFieldReleaseDate;
	private JTextField textFieldDurationTime;
	private JCheckBox chckbxIsActive;

	private void GetDataAndSetFields() {
		Movie movie = DbAdapterMovie.getMovie(id);
		textFieldTitle.setText(movie.getTitle());
		textFieldDescription.setText(movie.getDescription());
		textFieldReleaseDate.setText(movie.getReleaseDate());
		chckbxIsActive.setSelected(movie.isActive());
		textFieldDurationTime.setText(Integer.toString(movie.getDurationTime()));
	}

	public Edit(int id) {
		this.id = id;

		if (Common.getUserFromContext().getUserRole().equals("administrator")) {
			setTitle("Modyfikowanie filmu - CinemaWorld");
		} else {
			setTitle("Szczegóły filmu - CinemaWorld");
		}

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

		JLabel lblRepertuar = new JLabel("Modyfikowanie filmu");

		if (Common.getUserFromContext().getUserRole().equals("administrator")) {
			lblRepertuar = new JLabel("Modyfikowanie filmu");
		} else {
			lblRepertuar = new JLabel("Szczegóły filmu");
		}

		lblRepertuar.setBounds(79, 11, 253, 37);
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

		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTitle.setBounds(126, 9, 235, 30);
		panel_4.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 136, 371, 54);
		panel_1.add(panel_4_1);

		JLabel lblNewLabel_1_1 = new JLabel("Opis");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 12, 123, 23);
		panel_4_1.add(lblNewLabel_1_1);

		textFieldDescription = new JTextField();
		textFieldDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(126, 9, 235, 30);
		panel_4_1.add(textFieldDescription);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 429, 371, 47);
		panel_1.add(panel_4_1_1);

		JPanel panel_4_1_2 = new JPanel();
		panel_4_1_2.setLayout(null);
		panel_4_1_2.setBounds(0, 201, 371, 54);
		panel_1.add(panel_4_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Data premiery");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2.add(lblNewLabel_1_1_1);

		textFieldReleaseDate = new JTextField();
		textFieldReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldReleaseDate.setColumns(10);
		textFieldReleaseDate.setBounds(126, 9, 235, 30);
		panel_4_1_2.add(textFieldReleaseDate);

		JPanel panel_4_1_2_1 = new JPanel();
		panel_4_1_2_1.setLayout(null);
		panel_4_1_2_1.setBounds(0, 266, 371, 54);
		panel_1.add(panel_4_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Czas trwania");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2_1.add(lblNewLabel_1_1_1_1);

		textFieldDurationTime = new JTextField();
		textFieldDurationTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDurationTime.setColumns(10);
		textFieldDurationTime.setBounds(126, 9, 123, 30);
		panel_4_1_2_1.add(textFieldDurationTime);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("minut");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(259, 12, 123, 23);
		panel_4_1_2_1.add(lblNewLabel_1_1_1_1_1);

		JPanel panel_4_1_2_1_1 = new JPanel();
		panel_4_1_2_1_1.setLayout(null);
		panel_4_1_2_1_1.setBounds(0, 331, 371, 54);
		panel_1.add(panel_4_1_2_1_1);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Aktywny");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2.setBounds(10, 12, 123, 23);
		panel_4_1_2_1_1.add(lblNewLabel_1_1_1_1_2);

		chckbxIsActive = new JCheckBox("");
		chckbxIsActive.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxIsActive.setBounds(126, 12, 97, 23);
		panel_4_1_2_1_1.add(chckbxIsActive);

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
			public void actionPerformed(ActionEvent arg0) {
				
				if (Common.getUserFromContext().getUserRole().equals("administrator"))
				{					
					Windows.Movie.Index frame = new Windows.Movie.Index();
					frame.setVisible(true);
					setVisible(false);
					dispose();
				}
				else
				{
					setVisible(false);
					dispose();
					Windows.Movie.ActiveMovies frame = new Windows.Movie.ActiveMovies();
					frame.setVisible(true);					
				}
			}
		});
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBackground(new Color(204, 0, 153));
		btnReturn.setBounds(0, 56, 356, 45);
		panel_3.add(btnReturn);

		if (Common.getUserFromContext().getUserRole().equals("administrator")) {

			JButton btnSave = new JButton("ZAPISZ");

			btnSave.setForeground(Color.BLACK);
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnSave.setBackground(new Color(204, 0, 153));
			btnSave.setBounds(104, 0, 181, 45);
			panel_4_1_1.add(btnSave);

			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((textFieldTitle.getText().isEmpty() || textFieldReleaseDate.getText().isEmpty())
							|| textFieldReleaseDate.getText().isEmpty() || textFieldDurationTime.getText().isEmpty()) {

						Common.showInfo(getContentPane(), "Puste pola tekstowe", "Nie wypełniono wszystkich pól");
					} else {

						boolean isActive = chckbxIsActive.isSelected();

						DbAdapterMovie.updateMovie(id, textFieldTitle.getText(), textFieldDescription.getText(),
								textFieldReleaseDate.getText(), Common.isSelected(isActive),
								Integer.parseInt(textFieldDurationTime.getText())

						);
						Common.showInfo(getContentPane(), "Zapisano pomyślnie", "Film został zapisany pomyślnie");
					}
				}
			});
		}

		GetDataAndSetFields();
	}
}