package FoodiePackage;

public class Meal {
	// Attributes
		int mealQuantity;
		String mealName;
		double mealPrice;

	// Constructor
		public Meal(int mealQuantity, String mealName, double mealPrice) {
			this.mealQuantity = mealQuantity;
			this.mealName = mealName;
			this.mealPrice = mealPrice;
		}
		public String toString() {
			return mealQuantity +" x "+mealName +" (R"+mealPrice+")\n";
		}
	}