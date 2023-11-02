package sdf.day05.boardgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardGames {

    public static final int COL_GAMENAME = 1;
    public static final int COL_YEARPUBLISHED = 2;
    public static final int COL_MINTIME = 6;
    public static final int COL_MAXTIME = 7;

    public static void main(String[] args) {

        if (args.length <= 0) {
            System.err.println("Missing boardgames CSV");
            System.exit(1);
        }

        System.out.printf("Processing %s\n", args[0]);

        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            Map<String, List<Game>> classified = br.lines()
            .skip(10000)
            .map(row -> row.trim().split(","))
            .map(field -> 
                new Game(field[COL_GAMENAME], 
                        field[COL_YEARPUBLISHED], 
                        field[COL_MINTIME], 
                        field[COL_MAXTIME]))
            .collect(Collectors.groupingBy(game -> game.getCategory()));
        
            for (String entry : classified.keySet()) {
                List<Game> games = classified.get(entry);
                System.out.printf("%s\n", entry);
                for (Game game : games) {
                    System.out.printf("\t%s, published in %d\n", game.getGameTitle(), game.getYearPublished());
                }
            }
        

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
