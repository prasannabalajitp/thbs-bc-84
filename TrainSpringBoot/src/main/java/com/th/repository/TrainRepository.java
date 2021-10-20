package com.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.th.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer>{

}
