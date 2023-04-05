package juan.ahumada.codechallenge.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInterface.class);

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static final String WELCOME_MESSAGE = "Welcome to the Word Transformation Code Challenge - CC3";
	private static final String WORD_REQUEST_MESSAGE = "Please enter a word: ";
	private static final String SENTENCE_SHOW_MESSAGE = "The sentence is: {}";
	private static final String ANSWER_MESSAGE = "The result for your sentence is: {}";
	private static final String USER_INPUT_ERROR_MESSAGE = "There was an error trying to read your input.";
	private static final String ANOTHER_WORD_REQUEST_MESSAGE = "Do you want to enter another word? (Y/N)";
	private static final String KEY_TO_CONTINUE = "Y";

	private UserInterface() {
		throw new IllegalStateException("Utility class");
	}

	public static String getWordFromUser() {
		showMenuToUser();
		return getUserInput();
	}

	private static String getUserInput() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			LOGGER.error(USER_INPUT_ERROR_MESSAGE);
			return null;
		}
	}

	public static Boolean userWantsToExit() {
		LOGGER.warn(ANOTHER_WORD_REQUEST_MESSAGE);
		final String userInput = getUserInput();
		return userInput != null && userInput.trim().equalsIgnoreCase(KEY_TO_CONTINUE);
	}

	public static void showResult(final String result) {
		LOGGER.warn(ANSWER_MESSAGE, result);
	}

	public static void showSentence(final String sentence) {
		LOGGER.warn(SENTENCE_SHOW_MESSAGE, sentence);
	}

	public static void showWelcomeMessage() {
		LOGGER.warn(WELCOME_MESSAGE);
	}

	private static void showMenuToUser() {
		LOGGER.warn(WORD_REQUEST_MESSAGE);
	}
}
