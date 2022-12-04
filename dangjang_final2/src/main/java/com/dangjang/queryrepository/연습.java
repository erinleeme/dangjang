package com.dangjang.queryrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class 연습 {

    private final EntityManager em;

    public void hello(Long memberId){
        List<doubleCheckForm> resultList = em.createQuery(
                "select new com.dangjang.queryrepository.doubleCheckForm" +
                "(m.loginId, m.nickname, m.phone, a.address1, a.address2, a.zipcode) " +
                "from Member m  join fetch Address a where m.memberId=:memberId", doubleCheckForm.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }


}
