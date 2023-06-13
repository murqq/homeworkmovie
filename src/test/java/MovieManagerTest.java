import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void testAddMovie() {
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        List<String> movies = manager.findAllMovies();
        assertEquals(2, movies.size());
        assertArrayEquals(new String[]{"Фильм 1", "Фильм 2"}, movies.toArray());
    }

    @Test
    public void testFindAllMovies() {
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        List<String> movies = manager.findAllMovies();
        assertEquals(2, movies.size());
    }

    @Test
    public void testFindLastMovies_DefaultLimit() {
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");
        manager.addMovie("Фильм 6");
        List<String> lastMovies = manager.findLastMovies();
        assertEquals(5, lastMovies.size());
        assertArrayEquals(new String[]{"Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2"}, lastMovies.toArray());
    }

    @Test
    public void testFindLastMovies_CustomLimit() {
        manager = new MovieManager(3);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        List<String> lastMovies = manager.findLastMovies();
        assertEquals(3, lastMovies.size());
        assertArrayEquals(new String[]{"Фильм 4", "Фильм 3", "Фильм 2"}, lastMovies.toArray());
    }
}
