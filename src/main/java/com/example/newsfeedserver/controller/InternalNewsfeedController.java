package com.example.newsfeedserver.controller;

import com.example.newsfeedserver.domain.dto.request.NewsfeedCreateReq;
import com.example.newsfeedserver.service.NewsfeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/internal/newsfeeds")
@RestController
public class InternalNewsfeedController {

    private final NewsfeedService newsfeedService;

    @PostMapping
    public ResponseEntity<?> createNewsfeed(@RequestBody NewsfeedCreateReq req){
        log.info("InternalNewsfeedController createNewsfeed start");
        newsfeedService.createNewsfeed(req);
        return ResponseEntity.ok().build();
    }
}
