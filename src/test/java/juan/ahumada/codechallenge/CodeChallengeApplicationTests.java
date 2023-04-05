package juan.ahumada.codechallenge;

import juan.ahumada.codechallenge.service.ISentenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(args = {"--arg1=Test word"})
class CodeChallengeApplicationTests {

	@Autowired
	private ISentenceService sentenceService;

	@Test
	void contextLoads() {
		assertNotNull(sentenceService);
	}

}
