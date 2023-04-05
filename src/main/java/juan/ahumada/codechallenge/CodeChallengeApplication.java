package juan.ahumada.codechallenge;

import juan.ahumada.codechallenge.service.ISentenceService;
import juan.ahumada.codechallenge.ui.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeChallengeApplication implements CommandLineRunner {

	private final ISentenceService sentenceService;

	@Autowired
	public CodeChallengeApplication(final ISentenceService sentenceService) {
		this.sentenceService = sentenceService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		UserInterface.showWelcomeMessage();
		if (args.length > 0) {
			useArguments(args);
		} else {
			useConsoleUI();
		}
	}

	private void useArguments(String[] args) {
		final String sentence = args[0];
		UserInterface.showSentence(sentence);
		UserInterface.showResult(sentenceService.processSentence(sentence));
	}

	private void useConsoleUI() {
		boolean otherWord = true;
		while (otherWord) {
			final String sentence = UserInterface.getWordFromUser();
			final String result = sentenceService.processSentence(sentence);
			UserInterface.showResult(result);
			otherWord = UserInterface.userWantsToExit();
		}
	}
}
