package FoodiePackage;

public class Restaurant {
	// Attributes
		String restaurantName;
		String restaurantContactNumber;
		String restaurantLocation;

	// Constructor
		public Restaurant(String restaurantName, String restaurantContactNumber, String restaurantLocation) {
			this.restaurantName = restaurantName;
			this.restaurantContactNumber = restaurantContactNumber;
			this.restaurantLocation = restaurantLocation;
		}
		public String toString() {
			return "\n \nYou have ordered the following from "+ restaurantName +" in " + restaurantLocation+":\n\n";
		}
	}
