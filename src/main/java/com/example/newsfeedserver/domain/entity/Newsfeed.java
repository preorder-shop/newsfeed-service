package com.example.newsfeedserver.domain.entity;

import com.example.newsfeedserver.domain.ActivityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "newsfeed")
public class Newsfeed extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String actor; // 해당 활동을 한 유저

    @Column(nullable = false)
    private String recipient;  // 특정 행위를 당한 유저

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "activity_type")
    private ActivityType activityType;


    @Builder
    public Newsfeed(String actor, String recipient, ActivityType activityType){
        this.actor = actor;
        this.recipient = recipient;
        this.activityType = activityType;
    }


}
