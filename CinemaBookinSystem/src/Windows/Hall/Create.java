package Windows.Hall;

import Database.DbAdapterHall;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Windows.Common;
import javax.swing.JTextField;

public class Create extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHallNumber;
	private JTextField textFieldMaxCapacity;

	public Create() {
		setTitle("Tworzenie sali - CinemaWorld");
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

		JLabel lblRepertuar = new JLabel("Tworzenie sali");
		lblRepertuar.setBounds(113, 11, 152, 37);
		lblRepertuar.setForeground(new Color(204, 0, 153));
		lblRepertuar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRepertuar);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 71, 371, 54);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Numer sali");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 16, 91, 14);
		panel_4.add(lblNewLabel_1);

		textFieldHallNumber = new JTextField();
		textFieldHallNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldHallNumber.setBounds(126, 9, 235, 30);
		panel_4.add(textFieldHallNumber);
		textFieldHallNumber.setColumns(10);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 156, 371, 54);
		panel_1.add(panel_4_1);

		JLabel lblNewLabel_1_1 = new JLabel("Liczba miejsc");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 16, 123, 14);
		panel_4_1.add(lblNewLabel_1_1);

		textFieldMaxCapacity = new JTextField();
		textFieldMaxCapacity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMaxCapacity.setColumns(10);
		textFieldMaxCapacity.setBounds(126, 9, 235, 30);
		textFieldMaxCapacity.setEditable(false);
		textFieldMaxCapacity.setEnabled(false);
		textFieldMaxCapacity.setText("70");
		panel_4_1.add(textFieldMaxCapacity);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 279, 371, 47);
		panel_1.add(panel_4_1_1);

		JButton btnCreate = new JButton("UTWÓRZ");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textFieldHallNumber.getText().isEmpty() || textFieldMaxCapacity.getText().isEmpty())) {

					Common.showInfo(getContentPane(), "Puste pola tekstowe", "Nie wypełniono wszystkich pól");
				} else {

					DbAdapterHall.insertHall(Integer.parseInt(textFieldMaxCapacity.getText().toString()),
					Integer.parseInt(textFieldHallNumber.getText().toString())
							);
					Common.showInfo(getContentPane(), "Zapisano pomyślnie", "Sala została zapisana pomyślnie");
				}
			}
		});
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreate.setBackground(new Color(204, 0, 153));
		btnCreate.setBounds(104, 0, 181, 45);
		panel_4_1_1.add(btnCreate);

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