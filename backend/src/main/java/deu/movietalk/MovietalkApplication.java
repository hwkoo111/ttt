package deu.movietalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MovietalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovietalkApplication.class, args);
    }

    /**
     * CORS 설정: 프론트 개발 서버(http://localhost:5173)에서 오는
     * 모든 경로, 모든 메서드를 허용합니다.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                    .addMapping("/**")                           // 전체 엔드포인트
                    .allowedOrigins("http://localhost:5173")     // 허용할 오리진
                    .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
            }
        };
    }
}
