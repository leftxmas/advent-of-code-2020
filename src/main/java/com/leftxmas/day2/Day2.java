package com.leftxmas.day2;

import com.leftxmas.PuzzleInputLoader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day2 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        File puzzleInput = PuzzleInputLoader.getFileFromResource("day2.txt");

        List<String> lines = Files.readAllLines(puzzleInput.toPath(), StandardCharsets.UTF_8);

        Set<PasswordPolicy> passwordPolicies = new HashSet<>();
        int validPasswordCount = 0;

        for (String line : lines) {
            String[] passwordPolicyInput = line.split(":");
            String password = passwordPolicyInput[1];

            String[] passwordPolicy = passwordPolicyInput[0].split(" ");
            char passwordPolicyChar = passwordPolicy[1].charAt(0);

            String[] passwordPolicyRange = passwordPolicy[0].split("-");

            PasswordPolicy passwordPolicy1 = new PasswordPolicy(passwordPolicyChar, Integer.valueOf(passwordPolicyRange[0]), Integer.valueOf(passwordPolicyRange[1]), password.trim());

            if (passwordPolicy1.isPasswordValid()) {
                validPasswordCount++;
            }
        }

        System.out.println(validPasswordCount);

    }


}

class PasswordPolicy {

    private char character;

    private int min;

    private int max;

    private String password;

    public PasswordPolicy(char character, int min, int max, String password) {
        this.character = character;
        this.min = min - 1;
        this.max = max - 1;
        this.password = password;
    }

    public char getCharacter() {
        return character;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPasswordValid() {

        List<Integer> positionsForCharacters = Arrays.stream(IntStream.range(0, this.password.length())
                .filter(i -> this.password.charAt(i) == this.character)
                .toArray()).boxed().collect(Collectors.toList());

        boolean validPassword = false;
        if (positionsForCharacters.contains(this.min) && positionsForCharacters.contains(this.max)) {
            validPassword = false;
        } else if (positionsForCharacters.contains(this.min) || positionsForCharacters.contains(this.max)) {
            validPassword = true;
        }

        return validPassword;
    }
}
