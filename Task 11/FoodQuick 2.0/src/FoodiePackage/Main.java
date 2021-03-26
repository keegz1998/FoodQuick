package FoodiePackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	// General Variables
	static String driverFilePath = "C:\\Users\\keega\\Desktop\\drivers.txt";
	static String invoiceFilePath = "C:\\Users\\keega\\Desktop\\invoice.txt";
	static String customerListFilePath = "C:\\Users\\keega\\Desktop\\customerList.txt";
	static String customerLocationsFilePath = "C:\\Users\\keega\\Desktop\\customerLocations.txt";
	static String customerInfoFilePath = "C:\\Users\\keega\\Desktop\\customerInfo.txt";
	static String invoice = "";
	static Customer newCustomer = new Customer("zeegansss", "074 500 4874", "45 Amadina Road Forestdale", "Durban",
			"keeganbagnall@gmail.com");
	static Restaurant newRestaurant = new Restaurant("Pizza Baby", "082 565 1498", "Cape Town");
	static Order newOrder = new Order(1, "No Avo", 0);
	static Meal newMeal = new Meal(2, "Chicken Lasanga", 20.00);

	public static void main(String[] args) throws IOException {
		createInvoice();
	}

	public static void createInvoice() throws IOException {
		createCustomer();
		createRestaurant();
		createMeal();
		createOrder();
		FindDriver(newRestaurant.restaurantLocation, newCustomer.customerCity);
		WriteToFile(invoice, invoiceFilePath);
		sortCustomers();

	}

	private static void createMeal() {
		invoice += newMeal.toString();

	}

	private static void createCustomer() {
		invoice += "Order Number " + newOrder.orderNumber + newCustomer.toString();

	}

	private static void createRestaurant() {

		invoice += newRestaurant.toString();

	}

	private static void createOrder() {
		newOrder.totalPrice = newMeal.mealPrice * newMeal.mealQuantity;
		invoice += newOrder.instructionsToString() + newOrder.totalPriceToString();

	}

	public static customerList AddCustomer() {
		customerList newCustomerList = new customerList(newCustomer.customerName, newOrder.orderNumber,
				newCustomer.customerCity);
		return newCustomerList;

	}

	public static void groupCustomersByLocation() {
		ArrayList<String> locationsArrayList = new ArrayList<String>();
		ArrayList<String> linesList = new ArrayList<>();

	}

	public static void sortCustomers() throws IOException {
		String output1 = "";
		String output2 = "";
		String output3 = "";
		ArrayList<String> customerLocationsArrayList = new ArrayList<>(Arrays.asList("Cape Town", "Durban",
				"Johannesburg", "Potchefstroom", "Springbok", "Bloemfontein", "Port Elizabeth", "Witbank"));

		ArrayList<customerList> customerListArrayList = new ArrayList<customerList>();
		customerListArrayList.add(AddCustomer());

		ArrayList<String> linesList = new ArrayList<>();

		String[] lineOfCustomerInfo = new String[3];

		BufferedReader buffRead = new BufferedReader(new FileReader(customerInfoFilePath));
		String textLineInFile;
		while ((textLineInFile = buffRead.readLine()) != null) {
			linesList.add(textLineInFile);
		}
		buffRead.close();

		for (int z = 0; z < linesList.size(); z++) {
			lineOfCustomerInfo = linesList.get(z).split(", ");
			customerList newCustomerList = new customerList(lineOfCustomerInfo[0],
					Integer.parseInt(lineOfCustomerInfo[1]), lineOfCustomerInfo[2]);
			customerListArrayList.add(newCustomerList);
		}
		output1 = "";
		output2 = "";
		sort(customerListArrayList);
		for (int y = 0; y < customerListArrayList.size(); y++) {
			output1 += customerListArrayList.get(y).customerName + ", " + customerListArrayList.get(y).customerID
					+ "\n";
			output2 += customerListArrayList.get(y).customerName + ", " + customerListArrayList.get(y).customerID + ", "
					+ customerListArrayList.get(y).Location + "\n";
		}

		WriteToFile(output1, customerListFilePath);
		WriteToFile(output2, customerInfoFilePath);
		String city = "";
		for (int a = 0; a < customerLocationsArrayList.size(); a++) {
			output3 += "\n";
			output3 += customerLocationsArrayList.get(a) + ": ";

			for (int b = 0; b < customerListArrayList.size(); b++) {

				if (customerListArrayList.get(b).Location.equals(customerLocationsArrayList.get(a))) {
					output3 += (customerListArrayList.get(b).customerName + ", ");

				}

			}

		}
		System.out.print(output3);
		WriteToFile(output3, customerLocationsFilePath);

	}

	public static void groupCustomersByLocations() throws IOException {

		String output = "";

		ArrayList<customerList> customerListArrayList = new ArrayList<customerList>();
		customerListArrayList.add(AddCustomer());

		ArrayList<String> linesList = new ArrayList<>();

		String[] lineOfCustomerInfo = new String[3];

		BufferedReader buffRead = new BufferedReader(new FileReader(customerListFilePath));
		String textLineInFile;
		while ((textLineInFile = buffRead.readLine()) != null) {
			linesList.add(textLineInFile);
		}
		buffRead.close();

		for (int z = 0; z < linesList.size(); z++) {
			lineOfCustomerInfo = linesList.get(z).split(", ");
			customerList newCustomerList = new customerList(lineOfCustomerInfo[0], 0, lineOfCustomerInfo[2]);
			customerListArrayList.add(newCustomerList);
		}
		output = "";
		sort(customerListArrayList);
		for (int y = 0; y < customerListArrayList.size(); y++) {
			output += customerListArrayList.get(y).customerName + ", " + customerListArrayList.get(y).Location + "\n";
		}
		

		WriteToFile(output, customerLocationsFilePath);
	}

	public static void sort(ArrayList<customerList> list) {

		list.sort((o1, o2) -> o1.customerName.compareTo(o2.customerName()));
	}

	public static void FindDriver(String restaurantLocation, String customerLocations) throws IOException {
		int load = 27;
		String driverName = "";
		String output = "";
		ArrayList<Driver> driverObjectsList = new ArrayList<Driver>();
		ArrayList<String> linesList = new ArrayList<>();
		String[] lineOfDriverInfo = new String[3];
		BufferedReader buffRead = new BufferedReader(new FileReader(driverFilePath));
		String textLineInFile;
		while ((textLineInFile = buffRead.readLine()) != null) {
			linesList.add(textLineInFile);
		}
		buffRead.close();

		for (int z = 0; z < linesList.size(); z++) {
			lineOfDriverInfo = linesList.get(z).split(", ");
			Driver newDriver = new Driver(lineOfDriverInfo[0], lineOfDriverInfo[1],
					Integer.parseInt(lineOfDriverInfo[2]));
			driverObjectsList.add(newDriver);
		}

		for (int y = 0; y < driverObjectsList.size(); y++) {
			if (restaurantLocation.equals(customerLocations)
					&& (restaurantLocation.equals(driverObjectsList.get(y).City))) {
				System.out.println((driverObjectsList.get(y).City));
				if (driverObjectsList.get(y).Load < load) {
					load = driverObjectsList.get(y).Load;
					output = "\n \n" + driverObjectsList.get(y).Name
							+ " is nearest to the restaurant and so he will be delivering your order at: \n \n";
					driverName = driverObjectsList.get(y).Name;

				}
			} else if (output == "") {
				output = "Sorry! Our drivers are too far away from you to be able to deliver to your location. \n \n";
			}

		}
		output += newCustomer.customerAddress + "\n" + newCustomer.customerCity
				+ "\n\nIf you need to contact the restaurantm their number is " + newRestaurant.restaurantContactNumber;
		invoice += output;
		output = "";
		for (int z = 0; z < driverObjectsList.size(); z++) {
			if (driverObjectsList.get(z).Name.equals(driverName)) {
				driverObjectsList.get(z).Load += 1;

			}
			output += driverObjectsList.get(z).Name + ", " + driverObjectsList.get(z).City + ", "
					+ driverObjectsList.get(z).Load + "\n";
		}
		WriteToFile(output, driverFilePath);

	}

	public static void WriteToFile(String textToWrite, String filePath) {
		// Create new File object with path
		@SuppressWarnings("unused")
		File fileObj = new File(filePath);
		try {
			// Create new file writer object with path
			FileWriter myWriter = new FileWriter(filePath);
			// Write the parameter to the file
			myWriter.write(textToWrite);
			// Close the writer
			myWriter.close();
			// File writing Success message
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			// File writing Error message
			System.out.println("An error occurred.");

		}
	}

}
