package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.IndividualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<IndividualEntity, Integer> {
}