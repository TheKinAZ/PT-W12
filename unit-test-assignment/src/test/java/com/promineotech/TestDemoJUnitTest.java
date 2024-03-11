package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		
		else {
			 assertThatThrownBy(() -> 
			 testDemo.addPositive(a, b))
			 .isInstanceOf(IllegalArgumentException.class);
		}
	} // end of method

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(Arguments.arguments(2, 4, 6, false), Arguments.arguments(9, -4, 5, true),
				Arguments.arguments(2, -4, 6, true), Arguments.arguments(3, 30, 33, false),
				Arguments.arguments(0, 0, 6, true), Arguments.arguments(8, 0, 0, true));
	} // end of method

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);

	} // end of method

	
	@Test
	void assertThatNumberSquaredIsCorrect() {
	  TestDemo mockDemo = spy(new TestDemo());
	  doReturn(6).when(mockDemo).getRandomInt();
	  int intSquared = mockDemo.randomNumberSquared();
	  assertThat(intSquared).isEqualTo(36);

	} // end of method

	
	@Test
	void assertThatMultipliersWork() {
		assertThat(testDemo.multiplyPositive(4, 5)).isEqualTo(20);
		assertThat(testDemo.multiplyPositive(8, 2)).isEqualTo(16);

	} // end of method

} // end of class
