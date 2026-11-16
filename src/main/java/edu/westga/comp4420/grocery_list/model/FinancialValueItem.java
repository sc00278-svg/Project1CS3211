package edu.westga.comp4420.grocery_list.model;

/**
 * Stores basic information for a single item.
 *
 * @author	sc00278
 * @version Fall 2026
 */
public final class FinancialValueItem {   

	private final String name;
	private final double amount;
	private final FinancialValueType type;
	
	/**
	 * Create and initialize a new financialVallued item with the provided information.
	 * 
	 * @precondition name != null &&
	 * 				 amountNeeded > 0.000 &&
	 * 				 type != null
	 * @postcondition getName() == name &&
	 * 				  getAmount() == amount &&
	 * 				  getType() == type
	 * 
	 * @param name the name for the new item
	 * @param amount the money amount value of the item
	 * @param type the type of financial value of the item
	 */
	public FinancialValueItem(String name, double amount, FinancialValueType type) {
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
	
	/**
	 * return the amount the financial value is worth
	 * 
	 * @return the amount of the value
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * returns the type of value for the item
	 * 
	 * @return the type of value
	 */
	public FinancialValueType getType() {
		return this.type;
	}
	
	/**the toString for the item
	 * 
	 * @return the toString for the item to be displayed
	 */
	@Override
	public String toString() {
		return "[" + this.type.toString() + "] " + this.name + ": $" + this.amount; 
	}
}