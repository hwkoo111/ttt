// MovieService.java
package deu.movietalk.service;

import deu.movietalk.dto.MovieDto;
import deu.movietalk.domain.Movie;
import deu.movietalk.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 메인 페이지 용도: 상영작, 호러, 액션, 로맨스 각 5개씩 반환
    public List<MovieDto> findAll() {
        List<MovieDto> result = new ArrayList<>();

        // 상영작 (releaseDts = 2025)
        result.addAll(convert(movieRepository.findRandom2025()));
        result.addAll(convert(movieRepository.findByGenre("호러")));
        result.addAll(convert(movieRepository.findByGenre("액션")));
        result.addAll(convert(movieRepository.findByGenre("로맨스")));

        return result;
    }

    public List<MovieDto> searchByTitle(String keyword) {
        return convert(movieRepository.findByTitleContaining(keyword));
    }

    private List<MovieDto> convert(List<Movie> movies) {
        List<MovieDto> list = new ArrayList<>();
        for (Movie m : movies) {
            list.add(MovieDto.builder()
                    .id(m.getMovieId())
                    .title(m.getTitle())
                    .genre(m.getGenre())
                    .posterUrl(m.getPosterUrl())
                    .build());
        }
        return list;
    }
}
