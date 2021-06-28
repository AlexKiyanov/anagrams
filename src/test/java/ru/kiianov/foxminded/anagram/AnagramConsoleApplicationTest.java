package ru.kiianov.foxminded.anagram;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramConsoleApplicationTest {
    InputStream systemIn = System.in;
    PrintStream systemOut = System.out;

    ByteArrayInputStream inputStream;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUpOutput() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }

    private String getOutput() {
        return outputStream.toString();
    }

    @Test
    void mainShouldPrintAnagramForInputString() {
        String inputString = "ab1cd efg2h";
        String expectedOutput = "dc1ba hgf2e\n";

        provideInput(inputString);

        AnagramConsoleApplication.main(new String[0]);

        assertEquals(expectedOutput, getOutput());
    }
}
