package deu.movietalk.controller;

import deu.movietalk.dto.MovieDto;
import deu.movietalk.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // ✅ 메인 페이지용 API (장르별 영화 5개씩 + 상영작 랜덤)
    @GetMapping("/main")
    public List<MovieDto> getMainMovies() {
        return movieService.findAll();
    }

    // ✅ 검색용 API (?keyword=어벤져스)
    @GetMapping("/search")
    public List<MovieDto> searchMovies(@RequestParam String keyword) {
        return movieService.searchByTitle(keyword);
    }
}
