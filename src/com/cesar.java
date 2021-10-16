package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class cesar {
    public static void main(String[] args) {

        Path path = Path.of("C:/Users/c-cas/OneDrive/Cursos/Java/Futurama.txt");
        boolean exists = Files.exists(path);
        if (Files.exists(path)){
                try (BufferedReader reader =
                             Files.newBufferedReader(path);) {

                    String line = reader.readLine();
                    while (line != null) {
                        String season = line.substring(line.indexOf('S')+1,line.indexOf('E'));
                        String episodes = line.substring(line.indexOf('E')+1);
                        System.out.println("Season = " + season + "\nEpisodes = " + episodes);

                        CreateDirectory(season, episodes);

                        line = reader.readLine();
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                //Path path = Paths.get("C:/Users/c-cas/OneDrive/Cursos/Java/Lara");

                //java.nio.file.Files;
        }else{
            System.out.println("Arquivo não encontrado");
        }
    }

    private static void CreateDirectory(String season, String episodes){

        String stringPathSeason = "C:/Users/c-cas/OneDrive/Cursos/Java/Lara/Season " + season;
        Path pathSeason = Path.of(stringPathSeason);

        //Cria o diretório da temporada
        try {
            Files.createDirectories(pathSeason);
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

        //Cria o diretório dos episódios
        for(int i = 1;i <= Integer.parseInt(episodes);i++){
            String stringEpisodeSeason = "C:/Users/c-cas/OneDrive/Cursos/Java/Lara/Season "  + season + "/Episode " + i;
            Path pathEpisodes = Path.of(stringEpisodeSeason);
            try {
                Files.createDirectories(pathEpisodes);
            } catch (IOException e) {
                System.err.println("Failed to create directory!" + e.getMessage());
            }
        }
    }
}
