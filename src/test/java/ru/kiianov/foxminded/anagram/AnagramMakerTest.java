package ru.kiianov.foxminded.anagram;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnagramMakerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final AnagramMaker anagramMaker = new AnagramMaker();

    @Test
    public void makeAnagramShouldReturnSameSymbolIfSentenceContainsOneLetterSymbol() {
        String sentenceLetterSymbol = "A";

        assertEquals(sentenceLetterSymbol, anagramMaker.makeAnagram(sentenceLetterSymbol));
    }

    @Test
    public void makeAnagramShouldReturnSameSymbolIfSentenceContainsOneNonLetterSymbol() {
        String sentenceNonLetterSymbol = "1";

        assertEquals(sentenceNonLetterSymbol, anagramMaker.makeAnagram(sentenceNonLetterSymbol));
    }

    @Test
    public void makeAnagramShouldReturnSameWordIfSentenceContainsOneWordWithSameLetterSymbols() {
        String wordWithSameLetters = "aaaaaaa";

        assertEquals(wordWithSameLetters, anagramMaker.makeAnagram(wordWithSameLetters));
    }

    @Test
    public void makeAnagramShouldReturnSameWordIfSentenceContainsOneWordWithSameNonLetterSymbols(){
        String wordWithSameNonLetters = "!!!!!";

        assertEquals(wordWithSameNonLetters, anagramMaker.makeAnagram(wordWithSameNonLetters));

    }

    @Test
    public void makeAnagramShouldReturnProperlyResultIfSentenceContainsOneWordWithDifferentLetterSymbols() {
        String wordWithDifferentLetters = "abcdef";
        String expectedResultWithDifferentLetters = "fedcba";

        assertEquals(expectedResultWithDifferentLetters, anagramMaker.makeAnagram(wordWithDifferentLetters));
    }

    @Test
    public void makeAnagramShouldReturnSameWordIfSentenceContainsOneWordWithDifferentNonLetterSymbols(){
        String wordWithDifferentNonLetters = "123$!";

        assertEquals(wordWithDifferentNonLetters, anagramMaker.makeAnagram(wordWithDifferentNonLetters));
    }

    @Test
    public void makeAnagramShouldReturnProperlyResultIfSentenceContainsOneWordWithDifferentLetterSymbolsInCases(){
        String wordWithDifferentLettersInCases = "aAbBcC";
        String expectedResultWithDifferentLettersInCases = "CcBbAa";

        assertEquals(expectedResultWithDifferentLettersInCases, anagramMaker.makeAnagram(wordWithDifferentLettersInCases));
    }

    @Test
    public void makeAnagramShouldReturnProperlyResultIfSentenceContainsSeveralWordWithDifferentLetterSymbols() {
        String centenceWithSeveralLetterWords = "abcd efgh ijkl";

        String expectedResultWithDifferentLetters = "dcba hgfe lkji";

        assertEquals(expectedResultWithDifferentLetters, anagramMaker.makeAnagram(centenceWithSeveralLetterWords));
    }

    @Test
    public void makeAnagramShouldReturnSameSentenceIfSentenceContainsSeveralWordWithDifferentNonLetterSymbols() {
        String sentenceWithSeveralNonLetterWords = "123$! 4%56 7890";

        assertEquals(sentenceWithSeveralNonLetterWords, anagramMaker.makeAnagram(sentenceWithSeveralNonLetterWords));
    }

    @Test
    public void makeAnagramShouldReturnProperlyResultIfSentenceContainsSeveralWordWithDifferentSymbols() {
        String centenceWithSeveralWords = "abCd a1Ab2c %!defG";
        String expectedResultWithDifferentWords = "dCba c1bA2a %!Gfed";

        assertEquals(expectedResultWithDifferentWords, anagramMaker.makeAnagram(centenceWithSeveralWords));
    }

    @Test
    public void anagramMakerShouldThrowIllegalArgumentExceptionIfSentenceIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("sentence is null");

        anagramMaker.makeAnagram(null);
    }

    @Test
    public void anagramMakerShouldThrowIllegalArgumentExceptionIfSentenceIsEmpty() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("sentence is empty");

        anagramMaker.makeAnagram("");
    }

    @Test
    public void anagramMakerShouldThrowIllegalArgumentExceptionIfSentenceIsBlank() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("sentence contains only whitespaces");

        anagramMaker.makeAnagram("  \r\n\t\f");
    }
}
