package juan.ahumada.codechallenge.service;

import juan.ahumada.codechallenge.service.impl.SentenceService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SentenceServiceTest {

	private final SentenceService sentenceService = new SentenceService();

	static Stream<Arguments> generateTestData() {
		return Stream.of(
				Arguments.of("It was many and many a year ago", "I0t w1s m2y a1d m2y a y2r a1o"),
				Arguments.of("Copyright,Microsoft:Corporation", "C7t,M6t:C6n"),
				Arguments.of("", ""),
				Arguments.of("Hello0my1name2is3Juan", "H2o0m0y1n2e2i0s3J2n"),
				Arguments.of("12345", "12345"),
				Arguments.of("     ", "     ")
		);
	}

	@ParameterizedTest
	@MethodSource("generateTestData")
	void testSuccessfulSentenceParsing(final String initialWord, final String expected) {
		final String response = sentenceService.processSentence(initialWord);

		assertNotNull(response);
		assertEquals(expected, response);
	}
}
