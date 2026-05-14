package ua.khpi.oop.lab10.model;

// клас епізоду серіалу
public class SeriesEpisode {
    private final String title;
    private final int episodeNumber;

    public SeriesEpisode(String title, int episodeNumber) {
        this.title = title;
        this.episodeNumber = episodeNumber;
    }

    @Override
    public String toString() {
        return "епізод: " + title + " (серія " + episodeNumber + ")";
    }
}