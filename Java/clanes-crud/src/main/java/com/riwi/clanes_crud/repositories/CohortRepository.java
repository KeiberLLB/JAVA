package com.riwi.clanes_crud.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riwi.clanes_crud.entities.Clan;
import com.riwi.clanes_crud.entities.Cohort;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Long> {
  @Query("SELECT c FROM clan c WHERE"+
            "(c.name LIKE %:name%) AND"+
            "(c.description LIKE %:description%) AND"+
            "(:isActive IS NULL OR c.isActive = :isActive) AND"+
            "(:cohortId IS NULL OR c.cohort.id = :cohortId)")
    public Page<Clan> getAll(
        @Param("name") String name,
        @Param("description") String description,
        @Param("isActive") Boolean isActive,
        @Param("cohortId") Long cohortId,
        PageRequest pagination
    );
}
