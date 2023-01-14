package Windows.MovieScreening;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Database.DbAdapterMovieScreening;
import Models.MovieScreening;
import Windows.Common;

public class ActiveMovieScreening extends JFrame {

	private JPanel contentPane, panel_4;
	private DefaultTableModel model;
	private JTable table;

	private void generateGrid() {
		table = new JTable();
		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return BigDecimal.class;
				case 5:
					return Boolean.class;
				default:
					return Boolean.class;
				}
			}
		};

		table.setModel(model);
		model.addColumn("Id");
		model.addColumn("Tytuł");
		model.addColumn("Sala");
		model.addColumn("Start");
		model.addColumn("Cena");
		model.addColumn("WYBIERZ");

		getData();

		int A = panel_4.getWidth();
		int B = panel_4.getHeight();
		table.setSize(A, B);
		JScrollPane tableSP = new JScrollPane(table);
		tableSP.setSize(A, B);
		panel_4.add(tableSP);
	}

	private void getData() {
		ArrayList<MovieScreening> halls = DbAdapterMovieScreening.selectMovieScreenings2(1);
		if (halls.size() > 0) {
			for (int i = 0; i < halls.size(); i++) {
				model.addRow(new Object[i]);
				model.setValueAt(String.valueOf(halls.get(i).getId()), i, 0);
				model.setValueAt(String.valueOf(halls.get(i).getMovie().getTitle()), i, 1);
				model.setValueAt(String.valueOf(halls.get(i).getHall().getHallNumber()), i, 2);
				model.setValueAt(String.valueOf(halls.get(i).getStartDate()), i, 3);
				model.setValueAt(String.valueOf(halls.get(i).getPrice()), i, 4);
				model.setValueAt(false, i, 5);
			}
		}
	}

	public ActiveMovieScreening() {
		setTitle("Dostępne filmy - CinemaWorld");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1141, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1141, 509);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(376, 11, 740, 487);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRepertuar = new JLabel("AKTUALNY SEANS");
		lblRepertuar.setBounds(260, 11, 264, 37);
		lblRepertuar.setForeground(new Color(204, 0, 153));
		lblRepertuar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRepertuar);

		panel_4 = new JPanel();
		panel_4.setBounds(10, 59, 719, 417);
		panel_1.add(panel_4);

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
		panel_3.setBounds(10, 193, 356, 251);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnReturn = new JButton("WSTECZ");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Common.getMainWindow(Common.getUserFromContext());
			}
		});
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBackground(new Color(204, 0, 153));
		btnReturn.setBounds(0, 206, 356, 45);
		panel_3.add(btnReturn);
		generateGrid();
	}
}
