package chapter9.sector02;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;


public class FilesDemo {

    public static void main(String[] args) throws IOException {

        final String filePath = "java8-lambda/src/main/java/chapter9/sector02/";

        Path path = Paths.get(filePath + "FilesDemo.java");
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(content.substring(0, 100) + "...");
        List<String> lines = Files.readAllLines(path);
        System.out.println("Last line: " + lines.get(lines.size() - 1));
        path = Paths.get(filePath + "FilesDemo1.out");
        content = content.replaceAll("e", "x");
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        path = Paths.get(filePath + "FilesDemo2.out");
        Files.write(path, lines);
        Collections.reverse(lines);
        Files.write(path, lines, StandardOpenOption.APPEND);
        URL url = new URL("http://horstmann.com");

        boolean deleted = Files.deleteIfExists(Paths.get(filePath + "FilesDemo3.out"));
        System.out.println(deleted);

        Files.copy(url.openStream(), Paths.get(filePath + "FilesDemo3.out"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Files.copy(Paths.get(filePath + "FilesDemo3.out"), out);
        System.out.println(out.toString("UTF-8").substring(0, 100) + "...");

        Files.copy(Paths.get(filePath + "FilesDemo3.out"), Paths.get(filePath + "FilesDemo4.out"));
        Files.copy(Paths.get(filePath + "FilesDemo4.out"), Paths.get(filePath + "FilesDemo5.out"));
        Files.copy(Paths.get(filePath + "FilesDemo3.out"), Paths.get(filePath + "FilesDemo5.out"), StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES);
        Files.move(Paths.get(filePath + "FilesDemo5.out"), Paths.get(filePath + "FilesDemo6.out"), StandardCopyOption.ATOMIC_MOVE);
        Files.delete(Paths.get(filePath + "FilesDemo6.out"));

        Path newPath = Files.createTempFile(null, ".txt");
        System.out.println(newPath);
        newPath = Files.createTempDirectory("fred");
        System.out.println(newPath);

    }

}