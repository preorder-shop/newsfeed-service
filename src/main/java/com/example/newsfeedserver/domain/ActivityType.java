package com.example.newsfeedserver.domain;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum ActivityType {

    FOLLOW("팔로우",1),
    FOLLOW_CANCEL("팔로우 취소",2),
    POST_LIKE("포스트 좋아요",3),
    POST_LIKE_CANCEL("포스트 좋아요 취소",4),
    COMMENT_LIKE("댓글 좋아요",5),
    COMMENT_LIKE_CANCEL("댓글 좋아요 취소",6),
    POST_WRITE("포스트 작성",7),
    COMMENT_WRITE("댓글 작성",8);

    private String text;
    private int number;

    ActivityType(String text,int num){
        this.text = text;
        this.number = num;

    }

    public static ActivityType findType(int num){
        return Arrays.stream(values())
                .filter(value -> value.number==num)
                .findAny()
                .orElse(null);
    }


}
