package demoTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import demo.NumberCalculation;

public class NumberCalculationTest {
	
	NumberCalculation nc;
	
	@BeforeEach
	void init() {
		nc = new NumberCalculation();
	}
	
	@Test
	void testAddition() {
		assertEquals(nc.add(10, 20), 30);
	}
	
	@Nested
	class addTest {
		
		@Test
		void AddPositive() {
			assertEquals(nc.add(1, 2), 3);
		}
		@Test
		void AddPosNeg() {
			assertEquals(nc.add(1, -2), -1);
		}
		@Test
		void AddNegative() {
			assertEquals(nc.add(-10, -3), -13);
		}
	}
	
	@Test
	void testMultiply() {
		assertAll(() -> assertEquals(0, nc.multiply(1,0)), () -> assertEquals(7, nc.multiply(7,2)),
				() -> assertEquals(20, nc.multiply(4,5)));
	}
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> nc.divide(1,0), "denominator should not be zero");
	}

}
