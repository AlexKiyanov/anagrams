package ru.kiianov.foxminded.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramMakerTest {

    private final AnagramMaker anagramMaker = new AnagramMaker();

    @Test
    void makeAnagramShouldReturnSameSymbolIfSentenceContainsOneLetterSymbol() {
        String sentenceLetterSymbol = "A";

        assertEquals(sentenceLetterSymbol, anagramMaker.makeAnagram(sentenceLetterSymbol));
    }

    @Test
    void makeAnagramShouldReturnSameSymbolIfSentenceContainsOneNonLetterSymbol() {
        String sentenceNonLetterSymbol = "1";

        assertEquals(sentenceNonLetterSymbol, anagramMaker.makeAnagram(sentenceNonLetterSymbol));
    }

    @Test
    void makeAnagramShouldReturnSameWordIfSentenceContainsOneWordWithSameLetterSymbols() {
        String wordWithSameLetters = "aaaaaaa";

        assertEquals(wordWithSameLetters, anagramMaker.makeAnagram(wordWithSameLetters));
    }

    @Test
    void makeAnagramShouldReturnSameWordIfSentenceContainsOneWordWithSameNonLetterSymbols() {
        String wordWithSameNonLetters = "!!!!!";

        assertEquals(wordWithSameNonLetters, anagramMaker.makeAnagram(wordWithSameNonLetters));

    }

    @Test
    void makeAnagramShouldReturnProperlyResultIfSentenceContainsOneWordWithDifferentLetterSymbols() {
        String wordWithDifferentLetters = "abcdef";
        String expectedResultWithDifferentLetters = "fedcba";

        assertEquals(expectedResultWithDifferentLetters, anagramMaker.makeAnagram(wordWithDifferentLetters));
    }

    @Test
    void makeAnagramShouldReturnSameWordIfSentenceContainsOneWordWithDifferentNonLetterSymbols() {
        String wordWithDifferentNonLetters = "123$!";

        assertEquals(wordWithDifferentNonLetters, anagramMaker.makeAnagram(wordWithDifferentNonLetters));
    }

    @Test
    void makeAnagramShouldReturnProperlyResultIfSentenceContainsOneWordWithDifferentLetterSymbolsInCases() {
        String wordWithDifferentLettersInCases = "aAbBcC";
        String expectedResultWithDifferentLettersInCases = "CcBbAa";

        assertEquals(expectedResultWithDifferentLettersInCases, anagramMaker.makeAnagram(wordWithDifferentLettersInCases));
    }

    @Test
    void makeAnagramShouldReturnProperlyResultIfSentenceContainsSeveralWordWithDifferentLetterSymbols() {
        String centenceWithSeveralLetterWords = "abcd efgh ijkl";

        String expectedResultWithDifferentLetters = "dcba hgfe lkji";

        assertEquals(expectedResultWithDifferentLetters, anagramMaker.makeAnagram(centenceWithSeveralLetterWords));
    }

    @Test
    void makeAnagramShouldReturnSameSentenceIfSentenceContainsSeveralWordWithDifferentNonLetterSymbols() {
        String sentenceWithSeveralNonLetterWords = "123$! 4%56 7890";

        assertEquals(sentenceWithSeveralNonLetterWords, anagramMaker.makeAnagram(sentenceWithSeveralNonLetterWords));
    }

    @Test
    void makeAnagramShouldReturnProperlyResultIfSentenceContainsSeveralWordWithDifferentSymbols() {
        String centenceWithSeveralWords = "abCd a1Ab2c %!defG";
        String expectedResultWithDifferentWords = "dCba c1bA2a %!Gfed";

        assertEquals(expectedResultWithDifferentWords, anagramMaker.makeAnagram(centenceWithSeveralWords));
    }

    @Test
    void anagramMakerShouldThrowIllegalArgumentExceptionIfSentenceIsNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                anagramMaker.makeAnagram(null));
        assertEquals("sentence is null", exception.getMessage());
    }

    @Test
    void anagramMakerShouldThrowIllegalArgumentExceptionIfSentenceIsEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                anagramMaker.makeAnagram(""));
        assertEquals("sentence is empty", exception.getMessage());
    }

    @Test
    void anagramMakerShouldThrowIllegalArgumentExceptionIfSentenceIsBlank() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                anagramMaker.makeAnagram("  \r\n\t\f"));
        assertEquals("sentence contains only whitespaces", exception.getMessage());
    }
}
