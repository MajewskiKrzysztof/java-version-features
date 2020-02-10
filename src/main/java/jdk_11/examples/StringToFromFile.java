package jdk_11.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StringToFromFile {

    public static void main(String[] args) throws IOException {
        Path filePath = Path.of(".", "data.txt");

        filePath = Files.writeString(filePath, "Some important content");

        String readContent = Files.readString(filePath);
    }

}
