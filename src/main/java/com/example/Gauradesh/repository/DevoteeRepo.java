package com.example.Gauradesh.repository;

import com.example.Gauradesh.model.Devotee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface DevoteeRepo extends JpaRepository<Devotee, Integer> {
    @Query(value = "SELECT d FROM Devotee d WHERE LOWER(d.devoteeName) = LOWER(:keyword)")
    List<Devotee> findByParam(String keyword);
}
