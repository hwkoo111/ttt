// MovieRepository.java
package deu.movietalk.repository;

import deu.movietalk.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);

    @Query(value = "SELECT * FROM movie WHERE release_dts = '2025' ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Movie> findRandom2025();

    List<Movie> findByTitleContaining(String keyword);
}