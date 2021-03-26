package FoodiePackage;

public class Customer {
	// Attributes
	String customerName;
	String customerPhoneNumber;
	String customerAddress;
	String customerCity;
	String customerEmail;

	// Constructor
	public Customer(String customerName, String customerPhoneNumber, String customerAddress, String customerCity,
			String customerEmail) {
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerEmail = customerEmail;

	}
	public String toString() {
		return "\nCustomer: "+customerName + "\nEmail: " + customerEmail + "\nPhone Number: " + customerPhoneNumber + "\nLocation: " + customerCity;
	}
}