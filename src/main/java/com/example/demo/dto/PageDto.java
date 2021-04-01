package com.example.demo.dto;

import com.example.demo.model.Page;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Convert;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class PageDto {

    @Size(min=5, message="Title is too short")
    private String title;
    @Size(min=10, max=8*1024*1024, message="Text is too short")
    private String text;

    private Long id;

    @Convert
    private User owner;

    public static PageDto from(Page page) {
        if (page == null) {
            return null;
        }
        return PageDto.builder()
                .title(page.getTitle())
                .text(page.getText())
                .id(page.getId())
                .owner(page.getOwner())
                .build();
    }

    public static List<PageDto> from(List<Page> pages) {
        return pages.stream()
                .map(PageDto::from)
                .collect(Collectors.toList());
    }
}
