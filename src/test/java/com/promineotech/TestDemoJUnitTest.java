package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
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
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	// Parameter Source Method
	static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
				arguments(2, 4, 6, false), // Valid
				arguments(0, 4, 0, true), // Invalid
				arguments(2, -4, 0, true) // Invalid
		);
		//formatter:on
	}
	
	// Individual Test Method with specific input values and asserts the results
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}

	// Individual Test Method determines whether passwords are valid (>6 characters)
    @Test
    void testValidPassword() {
        TestDemo testDemo = new TestDemo();

        assertTrue(testDemo.isPasswordSixCharactersOrMore("mypassword")); // Valid password
        assertTrue(testDemo.isPasswordSixCharactersOrMore("secure1")); //Valid password
        assertFalse(testDemo.isPasswordSixCharactersOrMore(null)); // Null password should be invalid
        assertFalse(testDemo.isPasswordSixCharactersOrMore("123"));  // Too short, less than 6 characters
        assertFalse(testDemo.isPasswordSixCharactersOrMore("abc"));  // Too short, less than 6 characters
    }

    // Individual Test Method uses Mockito to create a spy to return a specific value when getRandomInt is called
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);
	}

}