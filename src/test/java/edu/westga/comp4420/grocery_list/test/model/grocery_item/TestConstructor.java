package edu.westga.comp4420.grocery_list.test.model.grocery_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.grocery_list.model.FinancialValueType;
import edu.westga.comp4420.grocery_list.model.FinancialValueItem;

class TestConstructor {
	
	@ParameterizedTest
	@CsvSource({"bob, 1, income"})
	void testValidInput(String name, double amount, FinancialValueType type) {
		FinancialValueItem result = new FinancialValueItem(name, amount, type);
		
		assertEquals(name, result.getName(), "checking name of grocery item");
		assertEquals(amount, result.getAmount(), "checking amount needed of grocery item");
		assertEquals(type, result.getType(), "checking amount in cart of grocery item");
	}
	
	@Test
	void testInvalidInput() {
		assertThrows(IllegalArgumentException.class, ()-> {new FinancialValueItem(null, 0.1, FinancialValueType.expense);});
	}
	
	@Test
	void testInvalidInputValue() {
		assertThrows(IllegalArgumentException.class, ()-> {new FinancialValueItem("name", -0.1, FinancialValueType.expense);});
	}
	
	@Test
	void testInvalidTypeInput() {
		assertThrows(IllegalArgumentException.class, ()-> {new FinancialValueItem("name", 0.1, null);});
	}
}
