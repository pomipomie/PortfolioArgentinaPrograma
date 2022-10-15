
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.SkillT;
import java.util.List;


public interface ISkillTService {
    public void createSkillT (SkillT skillt);
    public void deleteSkillT (Long id_skillt);
    public SkillT searchSkillT (Long id_skillt);
    public SkillT editSkillT (SkillT skillt);
    public List<SkillT> SkillTList();
}
