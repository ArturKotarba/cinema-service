package Windows.Reservation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.DbAdapterHall;
import Database.DbAdapterReservation;
import Models.MovieScreening;
import Models.Reservation;
import Windows.Common;
import Windows.Login;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetSeats extends JFrame implements Callable<Boolean> {
	private JPanel contentPane;
	private int numbers;
	List<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
	List<Reservation> reservations = new ArrayList<Reservation>();
	int idMovieScreening;
	String all = "";
	List<Integer> reservedSeats = new ArrayList<Integer>();
	static List<Integer> checked = new ArrayList<Integer>();
	ExecutorService es = Executors.newFixedThreadPool(20);
	int seat;
	static public HashMap<Integer, Boolean> aSeats = new  HashMap<Integer, Boolean>();

	public SetSeats(int numbers, int idMovieScreening) {
		this.numbers = numbers;
		this.idMovieScreening = idMovieScreening;

		setTitle("CinemaWorld");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 548);
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
		panel_3.setBounds(10, 156, 678, 342);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(new Color(204, 0, 153));
		panel_4_2.setBounds(0, 0, 678, 10);
		panel_3.add(panel_4_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 332, 678, 10);
		panel_3.add(panel_4);
		panel_4.setBackground(new Color(204, 0, 153));

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.BLACK);
		panel_3_1.setBounds(10, 21, 653, 300);
		panel_3.add(panel_3_1);

		JPanel panel_4_2_1 = new JPanel();
		panel_4_2_1.setBackground(new Color(204, 0, 153));
		panel_4_2_1.setBounds(0, 0, 663, 10);
		panel_3_1.add(panel_4_2_1);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(204, 0, 153));
		panel_4_1.setBounds(0, 332, 663, 10);
		panel_3_1.add(panel_4_1);

		JPanel panel_4_2_1_1 = new JPanel();
		panel_4_2_1_1.setBackground(new Color(204, 0, 153));
		panel_4_2_1_1.setBounds(-27, 290, 690, 10);
		panel_3_1.add(panel_4_2_1_1);

		JButton btnNewButton = new JButton("ZAPISZ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (save()) {

					Common.showInfo(getContentPane(), "Zapisano pomyślnie", "Dane zostały zapisane pomyślnie");
					setVisible(false);
					dispose();
					Create.UpdateTF();
				} else
					Common.showInfo(getContentPane(),
							"Dane nie zostały zapisane. Proszę zaznaczyć prawidłową liczbę biletów " + numbers,
							"Nie zapisano pomyślnie");
			}
		});
		btnNewButton.setBounds(315, 111, 89, 23);
		panel.add(btnNewButton);

		getNotFreeSeats();
		int startX = 0; // +67
		int startY = 25; // +37
		int currentX = startX;
		int currentY = startY;
		for (int i = 0; i < Common.getNumbers().length; i++) {

			if (i == 10) {
				currentX = startX;
				currentY = currentY + 37;
			}
			;
			if (i == 20) {
				currentX = startX;
				currentY = currentY + 37;
			}
			;
			if (i == 30) {
				currentX = startX;
				currentY = currentY + 37;
			}
			;
			if (i == 40) {
				currentX = startX;
				currentY = currentY + 37;
			}
			;
			if (i == 50) {
				currentX = startX;
				currentY = currentY + 37;
			}
			;
			if (i == 60) {
				currentX = startX;
				currentY = currentY + 37;
			}
			JCheckBox checkbox = new JCheckBox(Common.getNumbers()[i]);
			checkbox.setForeground(Color.WHITE);
			checkbox.setBackground(new Color(0, 0, 0));
			checkbox.setBounds(currentX, currentY, 53, 23);
			currentX = currentX + 67;
			for (int j = 0; j < reservedSeats.size(); j++) {
				if (Integer.parseInt(checkbox.getText()) == reservedSeats.get(j)) {
					checkbox.setEnabled(false);
					
				}
				
			}
			checkboxes.add(checkbox);
			panel_3_1.add(checkbox);
		}
		setData();
	}

	public void getNotFreeSeats() {
		reservations = DbAdapterReservation.getFreeSeats(idMovieScreening);

		for (int i = 0; i < reservations.size(); i++) {
			all = all + (reservations.get(i).getSeats() + "|");

		}
		System.out.println(all);
		reservedSeats = Common.getNumbers(all);
		for (int i = 0; i < reservedSeats.size(); i++) {
			System.out.println(reservedSeats.get(i));
			
		}
	}

	public void setData() {
		System.out.println(checkboxes.size());
		for (int j = 0; j < checkboxes.size(); j++) {
			if (checkboxes.get(j).isEnabled()) {
			
				aSeats.put(Integer.parseInt(checkboxes.get(j).getText()), Boolean.TRUE);
			
			}
		
		}
		
	}

	
	

	public boolean save() {
		checked = new ArrayList<Integer>();
		int counter = 0;
		for (int i = 0; i < checkboxes.size(); i++) {

			if (checkboxes.get(i).isEnabled() && checkboxes.get(i).isSelected()) {
				checked.add(Integer.parseInt(checkboxes.get(i).getText()));
				seat = Integer.parseInt(checkboxes.get(i).getText());
				reserveSeat(seat,  Login.userContext.getEmail());
			}
			counter++;
		}
		if (checked.size() != numbers)
			return false;
		return true;
	}
	public synchronized boolean canReserveSeat(int nSeat, String name) {

		while (getCurrentSeats() < 0 || !checkSeat(nSeat)) {
			try {
				System.out.println("Watek czeka na rezerwacje miejsca nr: " + nSeat);
				
				TimeUnit.SECONDS.sleep(1);
				es.shutdown();
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public int getCurrentSeats() {

		int tmp = 0;
		
		 for (Map.Entry<Integer, Boolean> set :
			 aSeats.entrySet()) {
			 if(set.getValue()== Boolean.TRUE) {
            tmp += 1;
			 }	
        }		
		return tmp;
	}

	boolean checkSeat(int nSeat) {
		if (aSeats.get(nSeat)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean call() throws Exception {
		return reserveSeat(seat);
	}

	void reserveSeat(int nSeat, String name) {

		if (canReserveSeat(nSeat, name)) {
			aSeats.replace(nSeat, Boolean.FALSE);
			System.out.println("Watek rezerwuje miejsce nr: " + nSeat);
		}
	}

	boolean reserveSeat(int nSeat) {

		reserveSeat(nSeat, Login.userContext.getEmail());

		return true;
	}
}
