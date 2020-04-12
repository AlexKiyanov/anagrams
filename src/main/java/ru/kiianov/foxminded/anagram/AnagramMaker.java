package ru.kiianov.foxminded.anagram;

public class AnagramMaker {

    private static final String SPACE_DELIMITER = " ";

    public String makeAnagram(String sentence) {
        validateSentence(sentence);

        String[] words = sentence.split(SPACE_DELIMITER);
        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }

        return concat(reversedWords);
    }

    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        }

        if(sentence.isEmpty()) {
            throw  new IllegalArgumentException("sentence is empty");
        }

        if(sentence.isBlank()){
            throw new IllegalArgumentException("sentence contains only whitespaces");
        }
    }

    private String reverseWord(String word) {
        char[] chars = word.toCharArray();
        int leftIndex = 0;
        int rightIndex = chars.length - 1;

        while (leftIndex < rightIndex) {
            if (!Character.isAlphabetic(chars[leftIndex])) {
                leftIndex++;
            } else if (!Character.isAlphabetic(chars[rightIndex])) {
                rightIndex--;
            } else {
                swap(chars, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        return new String(chars);
    }

    private void swap(char[] chars, int leftIndex, int rightIndex) {
        char tmp = chars[leftIndex];
        chars[leftIndex] = chars[rightIndex];
        chars[rightIndex] = tmp;
    }

    private String concat(String[] words) {
        return String.join(SPACE_DELIMITER, words);
    }
}
