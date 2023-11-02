package sdf.day05;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;


public class BookPublisher {

    public static void main(String[] args) {


        if(args.length <= 0) {
            System.err.println("Missing book CSV");
            System.exit(1);
        }
        System.out.printf("Processing %s\n", args[0]);

        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            Map<String, Long> publishCount = br.lines()
            .skip(1)
            .map(line -> line.split(","))
            .map(arr -> arr[arr.length - 1])
            .collect(Collectors.groupingBy(publisher -> publisher.trim().toUpperCase(), Collectors.counting()));

            // publishCount.forEach((publisher, count) -> System.out.println(publisher + ": " + count));
            publishCount.forEach((publisher, count) -> System.out.printf("%s: %d\n", publisher, count));
            
            // List<String[]> a = br.lines()
            // .skip(1)
            // .map(line -> line.trim().split(","))
            // .collect(Collectors.toList());

            // Map<String, Long> publishCount = a.stream()
            // .map(arr -> arr[11])
            // .collect(Collectors.groupingBy(publisher -> publisher, Collectors.counting()));
            
            // publishCount.forEach((publisher, count) -> System.out.println(publisher + ": " + count));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}