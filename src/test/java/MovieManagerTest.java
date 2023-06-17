import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    @Test
    public void testDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5",};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        String[] expected = {"Movie 2", "Movie 1"};
        assertArrayEquals(expected, manager.findLastMovie());

        manager.addMovie("Movie 3");

        String[] expectedUpdated = {"Movie 3", "Movie 2", "Movie 1"};
        assertArrayEquals(expectedUpdated, manager.findLastMovie());

        manager.addMovie("Movie 4");

        String[] expectedFull = {"Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expectedFull, manager.findLastMovie());
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLast() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");

        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        assertArrayEquals(expected, manager.findLastMovie());
    }
}
