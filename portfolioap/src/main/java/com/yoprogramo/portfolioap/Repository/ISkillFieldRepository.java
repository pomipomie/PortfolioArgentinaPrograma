
package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.SkillField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillFieldRepository extends JpaRepository <SkillField, Long>{
    
}
