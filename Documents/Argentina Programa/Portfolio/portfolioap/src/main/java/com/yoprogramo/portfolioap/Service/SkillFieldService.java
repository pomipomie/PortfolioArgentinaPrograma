
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.SkillField;
import com.yoprogramo.portfolioap.Repository.ISkillFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillFieldService implements ISkillFieldService {
    
    @Autowired
    public ISkillFieldRepository skillfRepo;

    @Override
    public void createSkillF(SkillField skillfield) {
        skillfRepo.save(skillfield);
    }

    @Override
    public void deleteSkillF(Long id_skillfield) {
        skillfRepo.deleteById(id_skillfield);
    }

    @Override
    public SkillField searchSkillF(Long id_skillfield) {
        return skillfRepo.findById(id_skillfield).orElse(null);
    }

    @Override
    public void editSkillF(Long id_skillfield) {
        SkillField skillfield = skillfRepo.findById(id_skillfield).get();
        skillfRepo.save(skillfield);
    }
    
}
