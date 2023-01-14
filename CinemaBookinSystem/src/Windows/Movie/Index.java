package Windows.Movie;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Database.DbAdapterMovie;
import Models.Movie;
import Windows.Common;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

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
					return Integer.class;
				case 4:
					return Boolean.class;
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
		model.addColumn("Premiera");

		model.addColumn("Czas");
		model.addColumn("Aktywny");
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
		ArrayList<Movie> halls = DbAdapterMovie.selectMovies();
		if (halls.size() > 0) {
			for (int i = 0; i < halls.size(); i++) {
				model.addRow(new Object[i]);
				model.setValueAt(Integer.valueOf(halls.get(i).getId()), i, 0);
				model.setValueAt(String.valueOf(halls.get(i).getTitle()), i, 1);
				model.setValueAt(String.valueOf(halls.get(i).getReleaseDate()), i, 2);
				model.setValueAt(Integer.valueOf(halls.get(i).getDurationTime()), i, 3);
				model.setValueAt(Boolean.valueOf(halls.get(i).isActive()), i, 4);
				model.setValueAt(false, i, 5);
			}
		}
	}

	public Index() {
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

		JLabel lblRepertuar = new JLabel("FILMY");
		lblRepertuar.setBounds(107, 11, 264, 37);
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

		JButton btnCreate = new JButton("UTWÓRZ");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Create frame = new Create();
				frame.setVisible(true);
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setBackground(new Color(204, 0, 153));
		btnCreate.setBounds(0, 0, 356, 45);
		panel_3.add(btnCreate);

		JButton btnReturn = new JButton("WSTECZ");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Common.getMainWindow(Common.getUserFromContext());
				setVisible(false);
				dispose();
			}
		});
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBackground(new Color(204, 0, 153));
		btnReturn.setBounds(0, 206, 356, 45);
		panel_3.add(btnReturn);

		JButton btnEdit = new JButton("MODYFIKUJ");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() > 0) {
					int counter = 0;
					for (int i = 0; i < table.getRowCount(); i++) {
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 5).toString());
						String id = table.getValueAt(i, 0).toString();
						if (checked) {
							counter++;
							setVisible(false);
							dispose();	
							Edit frame = new Edit(Integer.parseInt(id));
							frame.setVisible(true);
							break;
						}
					}

					if (counter == 0)
						Common.showInfo(getContentPane(), "Nie wybrano filmu", "Nie wybrano");
				}
				
				
				
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBackground(new Color(204, 0, 153));
		btnEdit.setBounds(0, 56, 356, 45);
		panel_3.add(btnEdit);

		JButton btnDelete = new JButton("USUŃ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getRowCount() > 0) {
					int counter = 0;
					for (int i = 0; i < table.getRowCount(); i++) {
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 3).toString());
						String id = table.getValueAt(i, 0).toString();
						if (checked) {
							counter++;
							boolean a = Common.canDeleteMovie(getContentPane(), id);
							if (a == true) {
								model.removeRow(i);
								getData();
								table.revalidate();
							}
							break;
						}
					}

					if (counter == 0)
						Common.showInfo(getContentPane(), "Nie wybrano elementu do usunięcia", "Nie wybrano");
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBackground(new Color(204, 0, 153));
		btnDelete.setBounds(0, 112, 356, 45);
		panel_3.add(btnDelete);
		generateGrid();
	}
}