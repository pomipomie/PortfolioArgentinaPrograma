
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Skills;

public interface ISkillsService {
    public void createSkill (Skills skill);
    public void deleteSkill (Long id_skills);
    public Skills searchSkill (Long id_skills);
    public Skills editSkill (Skills skill);
}
