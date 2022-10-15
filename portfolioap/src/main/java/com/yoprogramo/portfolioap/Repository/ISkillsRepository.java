
package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository <Skills, Long>{
    
}
