
package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.SkillT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillTRepository extends JpaRepository <SkillT, Long>{
    
}
