package com.example.newsfeedserver.controller;

import static com.example.newsfeedserver.common.response.BaseResponseStatus.INVALID_REQUEST_PARAMETER;

import com.example.newsfeedserver.common.exceptions.BaseException;
import com.example.newsfeedserver.common.response.BaseResponse;
import com.example.newsfeedserver.domain.dto.request.GetNewsFeedReq;
import com.example.newsfeedserver.domain.dto.response.NewsFeedDto;
import com.example.newsfeedserver.service.NewsfeedService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/newsfeeds")
@RestController
public class NewsfeedController {


    private final NewsfeedService newsfeedService;

    /**
     * 포스트 리스트 조회 API
     */
    @GetMapping("")
    public BaseResponse<List<NewsFeedDto>> getPostListByCondition(
            @RequestParam(name = "type", defaultValue = "all") String type, // 모든글 or 내가 팔로우한 사용자의 글
            @RequestParam(name = "sort", defaultValue = "date") String sort, // 날짜순 or 인기순
            @RequestParam(name = "startPage", defaultValue = "0") int startPage) { // 시작 페이지

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();

        if (!type.equals("all") && !type.equals("follow")) {  // 예외처리
            throw new BaseException(INVALID_REQUEST_PARAMETER);
        }

        if (!sort.equals("date") && !sort.equals("like")) {
            throw new BaseException(INVALID_REQUEST_PARAMETER);
        }

        if(startPage<0)
        {
            throw new BaseException(INVALID_REQUEST_PARAMETER);
        }

        GetNewsFeedReq getNewsFeedReq = new GetNewsFeedReq(userId, type, sort, startPage);
        List<NewsFeedDto> feedList = newsfeedService.getPostListByCondition(getNewsFeedReq);

        return new BaseResponse<>(feedList);
    }

    /**
     * 내가 팔로우한 사용자의 활동
     */
//    @GetMapping("/my-following")
//    public BaseResponse<List<UserLogDto>> getMyFollowingActivity() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userId = auth.getName();
//
//        List<UserLogDto> result = activityServiceClient.getMyFollowingActivity(userId);
//
//        return new BaseResponse<>(result);
//    }
//
//    /**
//     * 나를 팔로우하는 사용자의 활동
//     */
//    @GetMapping("/my-follower")
//    public BaseResponse<List<UserLogDto>> getMyFollowerActivity() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userId = auth.getName();
//
//        List<UserLogDto> result = activityServiceClient.getMyFollowerActivity(userId);
//        return new BaseResponse<>(result);
//
//    }
//
//    /**
//     * 내 포스트 알림 (댓글 , 좋아요)
//     */
//    @GetMapping("/my-post-alarm")
//    public BaseResponse<List<MyPostAlarm>> getMyPostAlarm() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userId = auth.getName();
//
//        List<MyPostAlarm> result = activityServiceClient.getMyPostAlarm(userId);
//
//        return new BaseResponse<>(result);
//
//
//    }

}