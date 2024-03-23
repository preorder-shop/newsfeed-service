package com.example.newsfeedserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class NewsFeedDto {

    private Long id; // pk
    private String title;
    private String content;
    private String writer;
}
