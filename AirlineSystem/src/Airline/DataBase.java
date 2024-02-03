package Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {
	private static String url = "jdbc:mysql://localhost/airline system";
	private static String user = "user";
	private static String password = "momo202302491";
	private static Statement statement;

	public DataBase() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}

	public void AddPassenger(passenger p) throws SQLException {
		String insert = "INSERT INTO `passengers`(`id`, `firstName`, `lastName`, `tel`, `email`) " + "VALUES ('"
				+ p.getId() + "','" + p.getFirstName() + "','" + p.getLastName() + "','" + p.getTel() + "','"
				+ p.getEmail() + "');";
		statement.execute(insert);
	}

	public passenger getPassenger(int id) throws SQLException {
		String get = "	SELECT `id`, `firstName`, `lastName`, `tel`, `email` FROM `passengers` WHERE `id`= " + id
				+ " ;";
		ResultSet rs = statement.executeQuery(get);
		passenger p = new passenger();
		rs.next();
		p.setId(Integer.parseInt(rs.getString("id")));
		p.setFirstName(rs.getString("firstName"));
		p.setLastName(rs.getString("lastName"));
		p.setTel(rs.getString("Tel"));
		p.setEmail(rs.getString("email"));
		return p;
	}

	public passenger getPassenger(String firstName, String lastName) throws SQLException {
		String get = "SELECT `id`, `firstName`, `lastName`, `tel`, `email` FROM `passengers` WHERE `firstName` = '" + firstName + "'";

		ResultSet rs = statement.executeQuery(get);
		passenger passenger = new passenger();
		while (rs.next()) {
		
			passenger p = new passenger();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setTel(rs.getString("Tel"));
			p.setEmail(rs.getString("email"));
			if (p.getLastName().equals(lastName))
				passenger = p;
			break;
		}
		return passenger;
	}

	public void editPassenger(passenger p) throws SQLException {
		String update = "UPDATE `passengers` SET `id`='" + p.getId() + "',`firstName`='" + p.getFirstName()
				+ "',`lastName`='" + p.getLastName() + "',`tel`='" + p.getTel() + "',`email`='" + p.getEmail()
				+ "' WHERE `id` = '" + p.getId() + "';";
		statement.execute(update);

	}

	public ArrayList<passenger> getAllPassengers() throws SQLException {
		String get = "SELECT * FROM `passengers`;";
		ResultSet rs = statement.executeQuery(get);
		ArrayList<passenger> passengers = new ArrayList<>();
		while (rs.next()) {
			passenger p = new passenger();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setTel(rs.getString("Tel"));
			p.setEmail(rs.getString("email"));
			passengers.add(p);
		}
		return passengers;

	}
}
