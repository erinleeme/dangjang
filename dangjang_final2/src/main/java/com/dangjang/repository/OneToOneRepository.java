package com.dangjang.repository;

import com.dangjang.domain.OneToOneRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToOneRepository extends JpaRepository<OneToOneRequest, Long> {

}
