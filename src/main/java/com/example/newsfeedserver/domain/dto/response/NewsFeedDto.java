package com.example.newsfeedserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class NewsFeedDto {

    private Long postId;
    private String writer; // 글 쓴 사람
    private String title;
    private String content;
}
