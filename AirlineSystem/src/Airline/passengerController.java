package Airline;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class passengerController {
	public static void AddNewpassenger(DataBase database, Scanner s) throws SQLException {
		System.out.println("Enter First Name : ");
		String firstName = s.next();
		System.out.println("Enter Last Name :");
		String lastName = s.next();
		System.out.println("Enter the Phone Number : ");
		String tel = s.next();
		System.out.println("Enter Email : ");
		String email = s.next();

		passenger newPassenger = new passenger();
		newPassenger.setFirstName(firstName);
		newPassenger.setLastName(lastName);
		newPassenger.setEmail(email);
		newPassenger.setTel(tel);
		ArrayList<passenger> passenger = database.getAllPassengers();
		int id;
		if (passenger.size() != 0) {
			id = passenger.get(passenger.size() - 1).getId() + 1;

		} else {
			id = 0;
		}
		newPassenger.setId(id);
		database.AddPassenger(newPassenger);
		System.out.println("Passenger added successfully !");
	}

	public static void editPassenger(DataBase database, Scanner s) throws SQLException {
		System.out.println("Enter passenger id(int) : \n(-2) to get passenger by name   ");
		int id = s.nextInt();
		passenger passenger;
		if (id == -2) {
//			printAllPassengers(database);
//			System.out.println("Enter passenger id(int)");
//			id = s.nextInt();
			passenger = getPassengerByName(database, s);
		} else {
			passenger = database.getPassenger(id);
		}

		
		System.out.println("Enter first name: \n(-2) to keep the old value");
		String firstName = s.next();
		if (firstName.equals("-2"))
			firstName = passenger.getFirstName();

		System.out.println("Enter last name : \n(-2) to keep the old value");
		String lastName = s.next();
		if (lastName.equals("-2"))
			lastName = passenger.getLastName();

		System.out.println("Enter Tel number : \n(-2) to keep the old value");
		String telNumber = s.next();
		if (telNumber.equals("-2"))
			telNumber = passenger.getLastName();

		System.out.println("Enter Email : \n(-2) to keep the old value");
		String email = s.next();
		if (email.equals("-2"))
			email = passenger.getLastName();
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setEmail(email);
		passenger.setTel(telNumber);
		database.editPassenger(passenger);
		System.out.println("passenger edited successfully !");

	}

	public static void printAllPassengers(DataBase database) throws SQLException {
		ArrayList<passenger> passenger = database.getAllPassengers();
		System.out.println("\n--------------------------------------------------------");
		for (passenger p : passenger) {
			System.out.println("id : " + p.getId());
			System.out.println("Name : " + p.getFirstName() + " " + p.getLastName());
			System.out.println("Email :" + p.getEmail());
			System.out.println("Telephone number " + p.getTel());
			System.out.println("***********************");
		}
		System.out.println("--------------------------------------------------------\n");
	}

	public static void getPassengerIDByName(DataBase database, Scanner s) throws SQLException {
		System.out.println("Enter first name :");
		String firstName = s.next();
		System.out.println("Enter last name :");
		String lastName = s.next();
		passenger p = database.getPassenger(firstName, lastName);
		p.print();
	}

	public static passenger getPassengerByName(DataBase database, Scanner s) throws SQLException {
		System.out.println("Enter first name :");
		String firstName = s.next();
		System.out.println("Enter last name :");
		String lastName = s.next();
		passenger p = database.getPassenger(firstName, lastName);
		return p;
	}
}
