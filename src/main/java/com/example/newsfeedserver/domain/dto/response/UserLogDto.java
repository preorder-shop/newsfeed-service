package com.example.newsfeedserver.domain.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLogDto {

    private String actor; // 행위자
    private String recipient;
    private String activity; // 활동 내용.


}
