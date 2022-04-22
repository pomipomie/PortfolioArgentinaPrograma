
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Skills;
import com.yoprogramo.portfolioap.Repository.ISkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService {
    
    @Autowired
    public ISkillsRepository skillRepo;

    @Override
    public void createSkill(Skills skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id_skills) {
        skillRepo.deleteById(id_skills);
    }

    @Override
    public Skills searchSkill(Long id_skills) {
        return skillRepo.findById(id_skills).orElse(null);
    }

    @Override
    public void editSkill(Long id_skills) {
        Skills skill = skillRepo.findById(id_skills).get();
        skillRepo.save(skill);
    }
    
}
