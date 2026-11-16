package edu.westga.comp4420.grocery_list.test.model.grocery_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.grocery_list.model.FinancialValueItem;
import edu.westga.comp4420.grocery_list.model.FinancialValueType;

class TestToString {

	@Test
	void test() {
FinancialValueItem item = new FinancialValueItem("name", 1.00, FinancialValueType.income);
		
		String actual = item.toString();
		
		assertEquals(actual, "[income] name: $1.0", "assert that the name returned by the getName method matches the expected name");

	}
}
