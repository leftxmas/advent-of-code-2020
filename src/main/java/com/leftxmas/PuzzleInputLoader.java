package com.leftxmas;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class PuzzleInputLoader {

    public static File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = PuzzleInputLoader.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }

}
