package com.example.newsfeedserver.repository;

import com.example.newsfeedserver.domain.entity.Newsfeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsfeedRepository extends JpaRepository<Newsfeed,Long> {
}
