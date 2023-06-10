import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<String> movies;
    private int limit;

    public MovieManager() {
        this.movies = new ArrayList<>();
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.movies = new ArrayList<>();
        this.limit = limit;
    }

    public void addMovie(String movieTitle) {
        movies.add(movieTitle);
    }

    public List<String> findAllMovies() {
        return movies;
    }

    public List<String> findLastMovies() {
        int resultLength = Math.min(limit, movies.size());
        List<String> result = new ArrayList<>();
        for (int i = movies.size() - 1; i >= movies.size() - resultLength; i--) {
            result.add(movies.get(i));
        }
        return result;
    }
}
