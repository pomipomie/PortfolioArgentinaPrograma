package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository <Education, Long> {
    
}
