package Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	private static String url = "jdbc:mysql://localhost/airline system";
	private static String user = "user";
	private static String password = "momo202302491";
	private static Statement statement;

	public Database() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}

	public Statement getStatement() {
		return statement;
	}



}
