package Windows.Reservation;

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
import Database.DbAdapterReservation;
import Models.Reservation;
import Windows.Common;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Index extends JFrame {

	private JPanel contentPane, panel_4;
	private DefaultTableModel model;
	private JTable table;
	private JTextField textFieldId;

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
				case 6:
					return Boolean.class;
				
				default:
					return Boolean.class;
				}
			}
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return column == 6;
		    };
		};

		
		table.setModel(model);
		model.addColumn("Id");
		model.addColumn("Seans");
		model.addColumn("Użytkownik");
		model.addColumn("Liczba biletów");
		
		model.addColumn("Anulowana");
		model.addColumn("Zapłacona");
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
		ArrayList<Reservation> halls = DbAdapterReservation.selectReservations();
		if (halls.size() > 0) {
			for (int i = 0; i < halls.size(); i++) {
				model.addRow(new Object[i]);
				model.setValueAt(Integer.valueOf(halls.get(i).getId()), i, 0);
				model.setValueAt(String.valueOf(halls.get(i).getMovieScreening().getId()
						+ halls.get(i).getMovieScreening().getMovie().getTitle()), i, 1);
				model.setValueAt(String.valueOf(halls.get(i).getUser().getEmail()), i, 2);
				model.setValueAt(Integer.valueOf(halls.get(i).getSeatNumber()), i, 3);
				model.setValueAt(Boolean.valueOf(!halls.get(i).isActive()), i, 4);
				model.setValueAt(Boolean.valueOf(halls.get(i).isAccepted()), i, 5);
				model.setValueAt(false, i, 6);
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

		JLabel lblRepertuar = new JLabel("REZERWACJE");
		lblRepertuar.setBounds(304, 11, 264, 37);
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

		JButton btnDetails = new JButton("SZCZEGÓŁY REZERWACJI");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() > 0) {
					int counter = 0;
					for (int i = 0; i < table.getRowCount(); i++) {
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 6).toString());
						
						String id = table.getValueAt(i, 0).toString();
						if (checked) {
							counter++;
							setVisible(false);
							dispose();	
							Reservation reservation = DbAdapterReservation.getReservation(Integer.parseInt(id));
							Details frame = new Details(reservation, true);
							frame.setVisible(true);
							break;
						}
					}

					if (counter == 0)
						Common.showInfo(getContentPane(), "Nie wybrano rezerwacji", "Nie wybrano");
				}
			}
		});
		btnDetails.setForeground(Color.BLACK);
		btnDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDetails.setBackground(new Color(204, 0, 153));
		btnDetails.setBounds(0, 56, 356, 45);
		panel_3.add(btnDetails);



		textFieldId = new JTextField();
		textFieldId.setBounds(120, 175, 236, 20);
		panel_3.add(textFieldId);
		textFieldId.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(39, 165, 183, 37);
		panel_3.add(lblId);
		lblId.setForeground(new Color(204, 0, 153));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnReturn = new JButton("WSTECZ");
		btnReturn.setBounds(10, 105, 356, 45);
		panel.add(btnReturn);
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
		generateGrid();
		
		JButton btnFind = new JButton("SZUKAJ");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldId.getText().isEmpty()) {
					Reservation reservation = DbAdapterReservation.getReservation(Integer.parseInt(textFieldId.getText().toString()));
					System.out.print(Integer.parseInt(textFieldId.getText()));
					if(reservation!=null) {
						Details frame = new Details(reservation, true);
					frame.setVisible(true);
					}
					else {
						Common.showInfo(getContentPane(), "Brak rezerwacji o takim ID", "Brak rezerwacji");
					}
				} else {
					Common.showInfo(getContentPane(), "Brak wartości w polu ID", "Brak wartości");
				}
			}
		});
		btnFind.setForeground(Color.BLACK);
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFind.setBackground(new Color(204, 0, 153));
		btnFind.setBounds(0, 206, 356, 45);
		panel_3.add(btnFind);
	}
}