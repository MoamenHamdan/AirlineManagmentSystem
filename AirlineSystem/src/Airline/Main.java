package Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Database database = new Database();
		Scanner s = new Scanner(System.in);
		int i = -1;
		do {
			System.out.println("welcome to Hamdan's Airline System ");
			System.out.println("0. Quit");
			System.out.println("1. Add new Passenger ");
			System.out.println("2. Edit passenger ");
			System.out.println("3. Get passenger by name");
			System.out.println("4. Print All passengers ");
			System.out.println("5. Delete passenger ");
			System.out.println("6. Get passenger by id");
			i = s.nextInt();
			switch (i) {
			case 1:
				passengerController.AddNewPassenger(database, s);
				break;
			case 2:
				passengerController.EditPassenger(database, s);
				break;
			case 3:
				passengerController.findPassengerByName(database, s);
				break;
			case 4:
				passengerController.printAllPassengers(database);
				break;
			case 5:
				passengerController.DeletePassenger(database, s);
				break;
			case 6:
				passengerController.getPassengerByID(database, s);
				break;
			}
		} while (i != 0);

	}

}
