package com.example.newsfeedserver.client;

import com.example.newsfeedserver.domain.dto.request.GetNewsFeedReq;
import com.example.newsfeedserver.domain.dto.response.MyPostAlarm;
import com.example.newsfeedserver.domain.dto.response.NewsFeedDto;
import com.example.newsfeedserver.domain.dto.response.UserLogDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "activityServer")
public interface ActivityServiceClient {

    @PostMapping("/internal/activity/post")
    List<NewsFeedDto> getPostListByCondition(@RequestBody GetNewsFeedReq getNewsFeedReq);

//    @PostMapping("/internal/activity/newsfeed/my-following")
//    List<UserLogDto> getMyFollowingActivity(@RequestBody String userId);
//
//    @PostMapping("/activity/internal/newsfeed/my-follower")
//    List<UserLogDto> getMyFollowerActivity(@RequestBody String userId);
//
//    @PostMapping("/activity/internal/newsfeed/my-post-alarm")
//    List<MyPostAlarm> getMyPostAlarm(@RequestBody String userId);

}
