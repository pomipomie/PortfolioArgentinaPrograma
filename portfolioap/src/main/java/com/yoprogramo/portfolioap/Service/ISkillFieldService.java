
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.SkillField;


public interface ISkillFieldService {
    public void createSkillF (SkillField skillfield);
    public void deleteSkillF (Long id_skillfield);
    public SkillField searchSkillF (Long id_skillfield);
    public SkillField editSkillF (SkillField skillfield);    
}
