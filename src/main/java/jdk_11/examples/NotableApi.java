package jdk_11.examples;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NotableApi {

    public static void main(String[] args) {
        Optional<String[]> params = Optional.ofNullable(args);
        if(params.isEmpty()) {
            System.out.println("Empty params");
        }

        Stream.of("A", "a")
                .filter(name -> !name.startsWith("A"))
                .filter(Predicate.not(name -> name.startsWith("A")))
                .findAny();

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime stop = LocalDateTime.now().plusHours(12).plusMinutes(12);
        long seconds = TimeUnit.SECONDS.convert(Duration.between(start, stop));

        var nullIs = InputStream.nullInputStream();
        var nullOs = OutputStream.nullOutputStream();
        var nullReader = Reader.nullReader();
        var nullWriter = Writer.nullWriter();
    }
}
