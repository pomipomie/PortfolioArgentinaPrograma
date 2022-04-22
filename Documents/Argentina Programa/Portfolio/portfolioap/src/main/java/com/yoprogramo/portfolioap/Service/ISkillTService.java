
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.SkillT;


public interface ISkillTService {
    public void createSkillT (SkillT skillt);
    public void deleteSkillT (Long id_skillt);
    public SkillT searchSkillT (Long id_skillt);
    public void editSkillT (Long id_skillt);
}
