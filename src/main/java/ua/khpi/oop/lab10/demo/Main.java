package ua.khpi.oop.lab10.demo;

import ua.khpi.oop.lab10.model.*;
import ua.khpi.oop.lab10.container.MediaContainer;

public class Main {
    public static void main(String[] args) {
        // контейнер для фільмів
        MediaContainer<Movie> movies = new MediaContainer<>();
        movies.add(new Movie("дюна", "дені вільнев"));
        movies.add(new Movie("матриця", "вачовскі"));

        System.out.println("каталог фільмів:");
        for (Movie m : movies) {
            System.out.println(m);
        }

        // перевірка видалення
        movies.remove(0);
        System.out.println("\nпісля видалення першого фільму:");
        for (Movie m : movies) {
            System.out.println(m);
        }

        // контейнер для епізодів
        MediaContainer<SeriesEpisode> episodes = new MediaContainer<>();
        episodes.add(new SeriesEpisode("пілот", 1));

        System.out.println("\nепізоди:");
        for (SeriesEpisode e : episodes) {
            System.out.println(e);
        }
    }
}