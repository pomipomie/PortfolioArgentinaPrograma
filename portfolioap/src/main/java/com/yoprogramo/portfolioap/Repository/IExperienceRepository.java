package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IExperienceRepository extends JpaRepository <Experience, Long> {
    
}
