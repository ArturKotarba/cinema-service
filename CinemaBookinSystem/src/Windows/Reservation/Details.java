package Windows.Reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Database.DbAdapterReservation;
import Models.MovieScreening;
import Models.Reservation;
import Windows.Common;
import javax.swing.JTextArea;

public class Details extends JFrame {
	private JPanel contentPane;
	private Reservation reservation;
	MovieScreening movieScreening;
	JLabel lbId, lblNumberOfTickets, lbTotal, lblNewLabel_1_1_1_1_2_1;
	JTextArea txtMovie;

	private void prepareFields() {
		lbId.setText(Integer.toString(reservation.getId()));

		txtMovie.setText(reservation.getMovieScreening().toString());
		lblNumberOfTickets.setText(Integer.toString(reservation.getSeatNumber()) + " szt.");
		lbTotal.setText(
				String.valueOf((reservation.getMovieScreening().getPrice() * reservation.getSeatNumber()) + " zł."));
		
		if(reservation.isAccepted() == true && reservation.isActive() == true) lblNewLabel_1_1_1_1_2_1.setText("OPŁACONA");
		if(reservation.isActive() == false || reservation.isAccepted() == false ) lblNewLabel_1_1_1_1_2_1.setText("ANULOWANA");
	}

	public Details(Reservation reservation, boolean isAdmin) {
		this.reservation = reservation;
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

		JLabel lblRepertuar = new JLabel("Szczegóły rezerwacji");
		lblRepertuar.setBounds(86, 11, 301, 37);
		lblRepertuar.setForeground(new Color(204, 0, 153));
		lblRepertuar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRepertuar);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 132, 371, 128);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Szczegóły");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 29, 171, 23);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("seansu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 46, 171, 23);
		panel_4.add(lblNewLabel_1_1);

		txtMovie = new JTextArea();
		txtMovie.setText("ABC");
		txtMovie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtMovie.setBounds(109, 11, 235, 106);
		panel_4.add(txtMovie);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 440, 371, 47);
		panel_1.add(panel_4_1_1);

		if (isAdmin)
		{	
			boolean isCanceled = reservation.isAccepted() == false || reservation.isActive() == false;
			String canceledTitle = "ANULUJ";
			
			if (isCanceled)
			{
				canceledTitle = "Przywróć";
			}
			
			JButton btnCancel = new JButton(canceledTitle);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Common.showInfo(getContentPane(), "Rezerwacja", "Rezerwacja jest już anulowana");
					
					if (isCanceled) {
						DbAdapterReservation.updateReservation(reservation.getId(), "1", "1");
						Common.showInfo(getContentPane(), "Rezerwacja", "Przywrócono rezerwacje");
					} else {
						DbAdapterReservation.updateReservation(reservation.getId(), "0", "0");
						Common.showInfo(getContentPane(), "Rezerwacja", "Anulowano rezerwacje");
						
					}
				}
			});
			btnCancel.setForeground(Color.BLACK);
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnCancel.setBackground(new Color(204, 0, 153));
			btnCancel.setBounds(0, 9, 87, 21);
			panel_4_1_1.add(btnCancel);
		}

		String title = "Nie Zapłacono";
		if (reservation.isAccepted() && reservation.isActive())
		{
			title = "ZAPŁACONO";
		}

		JPanel panel_4_1_2_1 = new JPanel();
		panel_4_1_2_1.setLayout(null);
		panel_4_1_2_1.setBounds(0, 262, 371, 54);
		panel_1.add(panel_4_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Liczba biletów");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 12, 123, 23);
		panel_4_1_2_1.add(lblNewLabel_1_1_1_1);

		lblNumberOfTickets = new JLabel("numberOfTickets");
		lblNumberOfTickets.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberOfTickets.setBounds(125, 12, 133, 23);
		panel_4_1_2_1.add(lblNumberOfTickets);

		JPanel panel_4_1_2_1_2 = new JPanel();
		panel_4_1_2_1_2.setLayout(null);
		panel_4_1_2_1_2.setBounds(0, 70, 371, 54);
		panel_1.add(panel_4_1_2_1_2);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("ID rezerwacji");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2.setBounds(10, 12, 123, 23);
		panel_4_1_2_1_2.add(lblNewLabel_1_1_1_1_2);

		lbId = new JLabel("#1234");
		lbId.setForeground(Color.RED);
		lbId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbId.setBounds(125, 12, 133, 23);
		panel_4_1_2_1_2.add(lbId);

//		if (Common.getUserFromContext().getUserRole().equals("administrator")) {
//			btnPaid.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					if (reservation.isAccepted() == true && reservation.isActive() == true) {
//						Common.showInfo(getContentPane(), "Rezerwacja", "Rezerwacja została już opłacona");
//					}
//					if (reservation.isAccepted() == false || reservation.isActive() == false) {
//						Common.showInfo(getContentPane(), "Rezerwacja", "Rezerwacja została już anulowana");
//					} else {
//						DbAdapterReservation.updateReservation(reservation.getId(), null, "1");
//						Common.showInfo(getContentPane(), "Rezerwacja", "Opłacono rezerwacje");
//					}
//				}
//			});
//
//		}

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Cena biletu:");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_3.setBounds(10, 394, 123, 23);
		panel_1.add(lblNewLabel_1_1_1_1_3);

		
		
		String title_price = "Nie Zapłacono";
		if (reservation.isAccepted() && reservation.isActive())
		{
			title_price = "ZAPŁACONO";
		}

		JLabel paidLabel = new JLabel(title_price);
		paidLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		paidLabel.setBounds(10, 420, 171, 23);
		panel_1.add(paidLabel);
		
		lbTotal = new JLabel("0");
		lbTotal.setForeground(Color.RED);
		lbTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbTotal.setBounds(131, 394, 133, 23);
		panel_1.add(lbTotal);
		
		lblNewLabel_1_1_1_1_2_1 = new JLabel("ID rezerwacji");
		lblNewLabel_1_1_1_1_2_1.setForeground(Color.RED);
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2_1.setBounds(10, 45, 123, 23);
		panel_1.add(lblNewLabel_1_1_1_1_2_1);

//		if (!Common.getUserFromContext().getUserRole().equals("administrator"))
//			btnPaid.setVisible(false);

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
				if (Common.getUserFromContext().getUserRole().equals("administrator")) {
				setVisible(false);
				dispose();
				Index frame = new Index();
				frame.setVisible(true);
				}
				else {
					setVisible(false);
					dispose();
					MyReservations frame = new MyReservations();
					frame.setVisible(true);
				}
			}
		});
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBackground(new Color(204, 0, 153));
		btnReturn.setBounds(0, 56, 356, 45);
		panel_3.add(btnReturn);
		prepareFields();
	}
}