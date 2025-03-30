package com.stockmanager.demo;

import com.stockmanager.demo.utils.FinancialHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoApplicationTests {
	private final FinancialHelper financialHelper = new FinancialHelper();
	@Test
	void getInstanceFieldNameTest() {
		assertEquals("totalRevenue", financialHelper.getInstanceFieldName("Total Revenue"));
		assertEquals("totalSalesAmount", financialHelper.getInstanceFieldName("Total Sales Amount"));
		assertEquals("revenue", financialHelper.getInstanceFieldName("Revenue"));
		assertEquals("helloWorld", financialHelper.getInstanceFieldName(" hello world "));
		assertEquals("totalRevenue", financialHelper.getInstanceFieldName(	"TOTAL REVENUE"));
		assertEquals("totalRevenue", financialHelper.getInstanceFieldName("tOtAl ReVeNuE"));
		assertEquals("", financialHelper.getInstanceFieldName(""));
	}
}
