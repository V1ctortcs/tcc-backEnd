package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.FinancialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialRepository extends JpaRepository<FinancialEntity, Integer> {
}