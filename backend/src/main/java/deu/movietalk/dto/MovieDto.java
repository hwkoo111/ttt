// MovieDto.java
package deu.movietalk.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {
    private Long id;             // 추가
    private String title;
    private String genre;
    private String posterUrl;
}