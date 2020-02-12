package com.domain.lesson17Stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WPStream {
    public static void main(String[] args) throws IOException {
        // первые 10
        File file = new File ("resource/wp.txt");
        Map<String, Long> map = Files.lines(file.toPath())
                .parallel()
                .map(line-> line.replaceAll("\\p{Punct}", " ").toLowerCase().trim())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .parallelStream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map);

        //ДОМА Stream  and  Collectors - методы


    }
}
