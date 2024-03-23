package com.example.newsfeedserver.service;

import com.example.newsfeedserver.client.ActivityServiceClient;
import com.example.newsfeedserver.domain.ActivityType;
import com.example.newsfeedserver.domain.dto.request.GetNewsFeedReq;
import com.example.newsfeedserver.domain.dto.request.NewsfeedCreateReq;
import com.example.newsfeedserver.domain.dto.response.NewsFeedDto;
import com.example.newsfeedserver.domain.entity.Newsfeed;
import com.example.newsfeedserver.repository.NewsfeedRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewsfeedService {

    private final ActivityServiceClient activityServiceClient;
    private final NewsfeedRepository newsfeedRepository;


    public List<NewsFeedDto> getPostListByCondition(GetNewsFeedReq getNewsFeedReq){



        return null;

    }

    public void createNewsfeed(NewsfeedCreateReq req) {

        Newsfeed newsfeed = Newsfeed.builder()
                .actor(req.getActor())
                .recipient(req.getRecipient())
                .activityType(ActivityType.findType(req.getActivityNumber()))
                .build();
        newsfeedRepository.save(newsfeed);
    }

}
