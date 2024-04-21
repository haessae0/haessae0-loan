package com.haessae0.loan.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haessae0.loan.loan.domain.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
