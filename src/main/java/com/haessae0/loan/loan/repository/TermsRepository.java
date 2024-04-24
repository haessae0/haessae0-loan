package com.haessae0.loan.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haessae0.loan.loan.domain.Terms;

@Repository
public interface TermsRepository extends JpaRepository<Terms, Long> {

}
