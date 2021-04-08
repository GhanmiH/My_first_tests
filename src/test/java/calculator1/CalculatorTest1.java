package calculator1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.assertj.core.util.Streams;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import calculatorUnderTest.digitset;

class CalculatorTest1 {

	private Calculator1 calculatorUnderTest;
	private Collector<Object, ?, Set<Object>> Stream;
	private static Instant startedAt;

	@BeforeAll
	public static void initstartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();
	}

	@AfterAll
	public static void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests: {0} ms", duration));
	}

	@BeforeEach
	public void initCalculator() {
		calculatorUnderTest = new Calculator1();
		System.out.println("Appel avant test");
	}

	@AfterEach
	public void underCalculator() {
		System.out.println("Appel aprés chaque test");
		calculatorUnderTest = null;

	}

	@Test
	void testAddTwoPositiveNumbers() {
		// ARRANGE
		int a = 10;
		int b = 7;
		// ACT
		int somme = calculatorUnderTest.add(a, b);
		// ASSERT
		assertThat(somme).isEqualTo(17);
	}

	@Test
	void testDoubleAdd() {
		Double a = 12.4;
		Double b = 0.24;
		Double sommeDouble = calculatorUnderTest.add(a, b);
		assertThat(sommeDouble).isEqualTo(12.64);
	}

	@Test
	void testDoubleMultiply() {
		Double a = 11.5;
		Double b = 2.1;
		Double multiplyDouble = calculatorUnderTest.multiply(a, b);
		assertThat(multiplyDouble).isEqualTo(24.150000000000002);
	}

	@Test
	void testMultiply() {
		int a = 10;
		int b = 2;
		int produit = calculatorUnderTest.multiply(a, b);
		assertThat(produit).isEqualTo(20);
	}

	@ParameterizedTest(name = "{0}*0 doit etre égal à 0")
	@ValueSource(ints = { 1, 5, 5200, 489521 })
	public void multiplyShouldReturnZero(int arg) {
		int actualResult = calculatorUnderTest.multiply(arg, 0);
		assertThat(actualResult).isEqualTo(0);
	}

	@ParameterizedTest(name = "{0}+{1} doit etre égal à {2}")
	@CsvSource({ "1,3,4", "58,11,69", "42,57,99" })
	public void addArguments(int arg1, int arg2, int expectedresultat) {
		final int actuelresultat = calculatorUnderTest.add(arg1, arg2);

	}
}
