package com.example.demo.repository;

import com.example.demo.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository extends JpaRepository<TareaEntity, Long> {
}
