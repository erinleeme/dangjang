package com.dangjang.repository;


import com.dangjang.domain.Address;
import com.dangjang.domain.Member;
import com.dangjang.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {


    @Query("select a from Address a where a.member = ?1")
    List<Address> findAllByMember(Member member);

    List<Address> findTop1ByOrderByIdDesc();
}
