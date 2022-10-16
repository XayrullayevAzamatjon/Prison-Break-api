package com.azik.repository;


import com.azik.model.PrisonBreak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrisonBreakRepository extends JpaRepository<PrisonBreak,Long> {

}
