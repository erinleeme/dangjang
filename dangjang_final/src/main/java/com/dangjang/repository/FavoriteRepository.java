package com.dangjang.repository;

import com.dangjang.domain.Favorite;
import com.dangjang.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findAllByMemberOrderByCreateDate(Member member);


    // int getFavoriteCount(String memberId);
}
