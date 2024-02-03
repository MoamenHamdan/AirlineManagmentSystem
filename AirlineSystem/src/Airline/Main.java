package Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		DataBase database = new DataBase();
		Scanner s = new Scanner(System.in);
		int i = -1;
		do {
			System.out.println("welcome to Hamdan's Airline System ");
			System.out.println("0. Quit");
			System.out.println("1. Add new Passenger ");
			System.out.println("2. Edit passenger ");
			System.out.println("3. Get passenger id by name ");
			System.out.println("4. Print All passengers ");

			i = s.nextInt();
			switch (i) {
			case 1:
				passengerController.AddNewpassenger(database, s);
				break;
			case 2:
				passengerController.editPassenger(database, s);
				break;
			case 3:
				passengerController.getPassengerIDByName(database, s);
				break;
			case 4 : 
				passengerController.printAllPassengers(database);
			}
		} while (i != 0);

	}

}
