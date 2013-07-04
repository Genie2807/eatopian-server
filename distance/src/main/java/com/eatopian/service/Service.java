package com.eatopian.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eatopian.DAO.MysqlImplDAO;
import com.eatopian.entity.Address;
import com.eatopian.entity.Restaurant;

public class Service {

	/**
	 * @param args
	 */

	public Service() {

	}

	public ArrayList<Restaurant> LocationAroundRestaurants(Address address) {

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");

		MysqlImplDAO m = (MysqlImplDAO) context.getBean("MysqlImplDAO");

//		Scanner sc = new Scanner(System.in);
		Address address = new Address();
		address.setCity("Waltham");
		address.setState("MA");
		address.setStreet("70 Hope Ave");
		address.setZip("02453");
		
		ArrayList<Restaurant> rts = m.findNearRestaurant(address, 4);
		for(Restaurant r: rts){
			System.out.println(r.getrName() + "; " + r.getDistance());
		}
		
		// Location of file to read
//		File file = new File("rt.txt");
		
//		try {
//			Scanner scanner = new Scanner(file);
//			
//			while (scanner.hasNextLine()) {
//				String line = scanner.nextLine();
//				String[] info = line.split(":");
//				Address address = new Address();
//				address.setCity(info[2]);
//				address.setState(info[3]);
//				address.setStreet(info[1]);
//				address.setZip(info[4]);
//				Restaurant r = new Restaurant(info[0], address);
//				System.out.println(r.getrName() + ": " + r.getAddress().getFormattedAddress() + "; " + r.getrGeoHash());
//				 m.insert(r);
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

//		Address address = new Address();
//		address.setCity("Somerville");
//		address.setState("MA");
//		address.setStreet("858 Broadway");
//		address.setZip("02144");

		// Restaurant r = new Restaurant("Tu Y Yo", address);
		// m.insert(r);

	}

}
