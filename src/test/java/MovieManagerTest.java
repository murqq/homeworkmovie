import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertEquals("Фильм 1", movies.get(0));
        assertEquals("Фильм 2", movies.get(1));
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
        assertEquals("Фильм 6", lastMovies.get(0));
        assertEquals("Фильм 5", lastMovies.get(1));
        assertEquals("Фильм 4", lastMovies.get(2));
        assertEquals("Фильм 3", lastMovies.get(3));
        assertEquals("Фильм 2", lastMovies.get(4));
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
        assertEquals("Фильм 4", lastMovies.get(0));
        assertEquals("Фильм 3", lastMovies.get(1));
        assertEquals("Фильм 2", lastMovies.get(2));
    }
}
