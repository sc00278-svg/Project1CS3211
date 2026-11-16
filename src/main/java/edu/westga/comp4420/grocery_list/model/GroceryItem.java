package edu.westga.comp4420.grocery_list.model;

/**
 * Stores basic information for a single item.
 *
 * @author	sc00278
 * @version Fall 2026
 */
public final class GroceryItem {   

	private final String name;
	private final double amount;
	private final FinancialValueType type;
	
	/**
	 * Create and initialize a new grocery item with the provided information.
	 * 
	 * @precondition name != null &&
	 * 				 amountNeeded > 0 &&
	 * 				 amountInCart > 0
	 * @postcondition getName() == name &&
	 * 				  getAmountNeeded() == amountNeeded &&
	 * 				  getAmountInCart() == amountInCart
	 * 
	 * @param name the name for the new grocery item
	 * @param amountNeeded the amount needed to be purchased for the new grocery item
	 * @param amountInCart the amount currently in the cart for the new grocery item
	 */
	public GroceryItem(String name, double amount, FinancialValueType type) {
		if (name == null) {
			throw new IllegalArgumentException("Must provide a name.");
		}
		if (amount <= 0.000) {
			throw new IllegalArgumentException("Must provide a positive value.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Must have a type");
		}
		this.name = name;
		this.amount = amount;
		this.type = type;
	}
	
	/**
	 * Return the name for the grocery item.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name for the new grocery item
	 */
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "[" + this.type.toString() + "] " + this.name + ": $" + this.amount; 
	}
}