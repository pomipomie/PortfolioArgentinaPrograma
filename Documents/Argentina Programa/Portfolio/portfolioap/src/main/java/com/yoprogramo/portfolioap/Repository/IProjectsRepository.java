package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectsRepository extends JpaRepository <Projects, Long> {
    
}
