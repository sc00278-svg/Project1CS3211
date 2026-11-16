package edu.westga.comp4420.grocery_list.test.model.grocery_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.grocery_list.model.FinancialValueItem;
import edu.westga.comp4420.grocery_list.model.FinancialValueType;

class TestGetAmount {

	@Test
	void test() {
FinancialValueItem item = new FinancialValueItem("name", 1.0, FinancialValueType.income);
		
		double actual = item.getAmount();
		
		assertEquals(actual, 1.0, "assert that the value returned by the getAmount method matches the expected value");
	}

}
