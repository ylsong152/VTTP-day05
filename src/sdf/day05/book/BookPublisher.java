package sdf.day05.book;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookPublisher {
    public static int COL_TITLE = 1;
    public static int COL_PUBLISHER = 11;
    public static void main(String[] args) {

        if(args.length <= 0) {
            System.err.println("Missing book CSV");
            System.exit(1);
        }
        System.out.printf("Processing %s\n", args[0]);

        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            Map<String, List<Book>> classified = br.lines()
            .skip(1)
            .map(row -> row.trim().split(","))
            .map(fields -> new Book(fields[COL_TITLE], fields[COL_PUBLISHER]))
            .collect(Collectors.groupingBy(book -> book.getBookPublisher()));

            for (String publisher : classified.keySet()) {
                List<Book> books = classified.get(publisher);
                System.out.printf("%s (%d)\n", publisher, books.size());
                for (Book book : books) {
                    System.out.printf("\t%s\n", book.getBookTitle());
                }
            }


            // .map(arr -> arr[arr.length - 1])
            // .collect(Collectors.groupingBy(publisher -> publisher.trim().toUpperCase(), Collectors.counting()));
            // classified.forEach((publisher, count) -> System.out.printf("%s: %d\n", publisher, count));    
            

            // List convert Map
            // List<String[]> a = br.lines()
            // .skip(1)
            // .map(line -> line.trim().split(","))
            // .collect(Collectors.toList());

            // Map<String, Long> classified = a.stream()
            // .map(arr -> arr[11])
            // .collect(Collectors.groupingBy(publisher -> publisher, Collectors.counting()));
            
            // classified.forEach((publisher, count) -> System.out.println(publisher + ": " + count));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}