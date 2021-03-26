package FoodiePackage;

public class Order {
	// Attributes
		int orderNumber;
		String specialInstructions;
		double totalPrice;

	// Constructor
		public Order(int orderNumber, String specialInstructions, double totalPrice) {
			this.orderNumber = orderNumber;
			this.specialInstructions = specialInstructions;
			this.totalPrice = totalPrice;
		}
		public String instructionsToString() {
			
			return "\nSpecial instructions: "+ specialInstructions;
			
		}
		public String totalPriceToString() {
			return "\n\nTotal:R" + totalPrice;
		}
	}