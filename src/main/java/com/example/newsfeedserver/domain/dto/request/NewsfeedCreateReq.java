package com.example.newsfeedserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewsfeedCreateReq {

    private String actor;
    private String recipient;
    private int activityNumber;
}
