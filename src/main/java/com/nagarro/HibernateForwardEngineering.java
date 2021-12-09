package com.nagarro;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.nagarr.hibernate.dao.impl.ProductDaoInterface;
import com.nagarro.hibernte.dao.ProductDao;


/**
 * The Class HibernateForwardEngineering.
 */
public class HibernateForwardEngineering {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		ReadCSV csv = new ReadCSV();
		File[] CsvReader = csv.readCsvFromFolder();

		ArrayList<Product> records = new ArrayList<>();

		for (int i = 0; i < CsvReader.length; i++) {

			try {

				Scanner x;
				x = new Scanner(new File(String.valueOf(CsvReader[i])));

				x.useDelimiter("[|\n]");

				while (x.hasNext() && String.valueOf(x.hasNext()) != "COLOUR") {

					Product p = new Product();
					ProductDao productDao = new ProductDao();

					p.setId(x.next());

					p.setName(x.next());

					p.setColour(x.next());

					p.setGender_recomendation(x.next());

					p.setSize(x.next());

					p.setPrice(x.next());

					p.setRating(x.next());

					p.setAvailibility(x.next());

					records.add(p);

					productDao.saveProduct(p);

				}

			}

			catch (Exception e) {

				System.out.println("hi");
			}

		}

		char Continue;
		do {

			ProductDao productDao = new ProductDao();

			List<Product> maibu = productDao.sessionGet();

			Scanner myObj = new Scanner(System.in);
			System.out.print("COLOUR: ");
			String colour = myObj.nextLine();
			System.out.print("SIZE: ");
			String size = myObj.nextLine();
			System.out.print("GENDER: ");
			String gender = myObj.nextLine();
			System.out.println("SORT BY:\n1)Price\n2)Rating\n3)Both Price & Rating");

			int sort = myObj.nextInt();

			List<Product> returnDto = searchRecord(colour, size, gender, maibu);

			switch (sort) {
			case 1:

				returnDto.sort(Product.Comparators.PRICE);
				System.out.println(returnDto);
				returnDto.clear();
				break;

			case 2:

				returnDto.sort(Product.Comparators.SIZE);
				System.out.println(returnDto);
				returnDto.clear();
				break;

			case 3:

				returnDto.sort(Product.Comparators.BOTH);
				System.out.println(returnDto);
				returnDto.clear();
				break;

			default:
				System.out.println("try another Tshirt");
			}
			System.out.println("do you want to continue with new shirts:Press Y to continue or n to terminate  ");
			Continue = myObj.next().charAt(0);
		} while (Continue == 'Y' || Continue == 'y');

	}

	/**
	 * Search record.
	 *
	 * @param colour the colour
	 * @param size the size
	 * @param gender the gender
	 * @param maibu the maibu
	 * @return the list
	 */
	private static List<Product> searchRecord(String colour, String size, String gender, List<Product> maibu) {

		List<Product> returnDto = maibu.stream().filter(obj -> obj.getColour().equals(colour)
				&& obj.getSize().equals(size) && obj.getGender_recomendation().equals(gender))
				.collect(Collectors.toList());
		return returnDto;
	}

}
