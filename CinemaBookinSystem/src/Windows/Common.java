package Windows;

import java.awt.Container;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import Database.DbAdapterHall;
import Database.DbAdapterMovie;
import Database.DbAdapterMovieScreening;
import Database.DbAdapterUser;
import Models.User;

public class Common {

	public static void showInfo(Container container, String text_1, String text_2) {
		JOptionPane.showMessageDialog(container, text_1, text_2, JOptionPane.PLAIN_MESSAGE);
	}

	public static int isSelected(boolean value) {
		if (value)
			return 1;
		return 0;
	}

	public static String isSelected2(boolean value) {
		if (value)
			return "1";
		return "0";
	}

	public static String isAdmin(boolean value) {
		if (!value)
			return "uzytkownik";
		return "administrator";
	}

	public static boolean getStatus(String status) {
		if (status.equals("1"))
			return true;
		return false;
	}

	public static String getCurrentDateAndTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static void getMainWindow(User user) {
		System.out.println(user.getUserRole());
		if (user.getUserRole().equals("administrator")) {
			Main frame = new Main();
			frame.setVisible(true);
		} else {
			Windows.User.Main frame = new Windows.User.Main();
			frame.setVisible(true);
		}
	}

	public static User getUserFromContext() {
		return Login.userContext;
	}

	public static boolean canDeleteHall(Container container, String id) {
		Object[] options = { "Nie", "Tak, usuń" };
		int answer = JOptionPane.showOptionDialog(container, "Czy usunąć z bazy danych?", "Usuwanie wyniku",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (answer == 1) {
			DbAdapterHall.deleteHall(id);
			return true;
		}
		return false;
	}

	public static boolean canDeleteMovie(Container container, String id) {
		Object[] options = { "Nie", "Tak, usuń" };
		int answer = JOptionPane.showOptionDialog(container, "Czy usunąć z bazy danych?", "Usuwanie wyniku",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (answer == 1) {
			DbAdapterMovie.deleteMovie(id);
			return true;
		}
		return false;
	}

	public static boolean canDeleteMovieScreening(Container container, String id, boolean stan) {
		Object[] options = { "Nie", "Tak, zmień" };
		int answer = JOptionPane.showOptionDialog(container, !stan ? "Czy zmienic na nieaktywny?" : "Czy zmienic na aktywny?", "Modyfikacja",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (answer == 1) {
			DbAdapterMovieScreening.updateMovieScreening(id, stan);
			return true;
		}
		return false;
	}

	public static boolean canDeleteUser(Container container, String id) {
		Object[] options = { "Nie", "Tak, usuń" };
		int answer = JOptionPane.showOptionDialog(container, "Czy usunąć z bazy danych?", "Usuwanie wyniku",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (answer == 1) {
			DbAdapterUser.deleteUser(id);
			return true;
		}
		return false;
	}
	
	
	public static String[] getNumbers() {
		int n=70;
		String[] numbers = new String[n];
		for(int i=0;i<n; i++) {
			numbers[i]=Integer.toString((i+1));
		}
		return numbers;
	}
	
	public static ArrayList<Integer> getNumbers(String n) {
		List<Integer> numbers = new ArrayList<Integer>();
		String cur = "";
		for (int i = 0; i < n.length(); i++) {

			if (n.charAt(i) != '|') {
				cur = cur + (String.valueOf(n.charAt(i)));

			} else {
				if (cur.equals(""))
					break;
				numbers.add(Integer.parseInt(cur));
				cur = "";
			}

		}
		return (ArrayList<Integer>) numbers;
	}

}
