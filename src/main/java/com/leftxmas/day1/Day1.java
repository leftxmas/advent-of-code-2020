package com.leftxmas.day1;

import com.leftxmas.PuzzleInputLoader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

class Day1 {

    private static final int EXPECTED_SUM = 2020;

    private static final String MESSAGE = "The two numbers are %s and %s";

    public static void main(String[] args) throws URISyntaxException, IOException {

        File puzzleInput = PuzzleInputLoader.getFileFromResource("day1.txt");

        List<String> lines = Files.readAllLines(puzzleInput.toPath(), StandardCharsets.UTF_8);

        int firstNumber = 0;
        int secondNumber = 0;

        mainLoop:
        for (int i = 0; i < lines.size(); i++) {

            firstNumber = Integer.valueOf(lines.get(i));

            for (int j = 0; j < lines.size(); j++) {

                secondNumber = Integer.valueOf(lines.get(j));

                int sum = firstNumber + secondNumber;

                System.out.println(firstNumber + " + " + secondNumber + " = " + sum);

                if (sum == EXPECTED_SUM) {
                    System.out.println(String.format(MESSAGE, firstNumber, secondNumber));
                    break mainLoop;
                }
            }
        }

        int result = firstNumber * secondNumber;
        System.out.printf(String.valueOf(result));

    }
}
