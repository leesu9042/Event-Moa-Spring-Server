package com.example.eventmoa.domain.dong.persistence.repository;

import com.example.eventmoa.domain.dong.persistence.Dong;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DongRepository extends CrudRepository<Dong, Long> {
    List<Dong> findAllByOrderByDateAscTimeAscDongAsc();
}
