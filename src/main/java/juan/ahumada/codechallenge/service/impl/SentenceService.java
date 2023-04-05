package juan.ahumada.codechallenge.service.impl;

import juan.ahumada.codechallenge.service.ISentenceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class SentenceService implements ISentenceService {

	public static final String LOOK_BEHIND_NOT_ALPHA = "(?<=\\P{Alpha})";

	public String processSentence(final String sentence) {
		final String[] words = sentence.split(LOOK_BEHIND_NOT_ALPHA);
		final StringBuilder result = new StringBuilder();
		for (String word : words) {
			if (StringUtils.isNotBlank(word)) {
				result.append(processWord(word));
			} else {
				result.append(word);
			}
		}
		return result.toString();
	}

	private String processWord(final String word) {
		String realWord = word;
		String separator = "";
		if (hasSeparator(word)) {
			realWord = word.substring(0, word.length() - 1);
			separator = String.valueOf(word.charAt(word.length() - 1));
		}
		if (realWord.length() >= 2) {
			final String firstLetter = String.valueOf(realWord.charAt(0));
			final String lastLetter = String.valueOf(realWord.charAt(realWord.length() - 1));
			final int mediumNumber = countDistinctCharacters(realWord.substring(1, realWord.length() - 1));
			return firstLetter + mediumNumber + lastLetter + separator;
		}
		return realWord + separator;
	}

	private boolean hasSeparator(final String word) {
		return !StringUtils.isAlpha(word);
	}

	private int countDistinctCharacters(final String word) {
		return word.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(HashSet::new)).size();
	}
}
