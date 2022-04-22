package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.SkillT;
import com.yoprogramo.portfolioap.Repository.ISkillTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillTService implements ISkillTService {
    
    @Autowired
    public ISkillTRepository skilltRepo;

    @Override
    public void createSkillT(SkillT skillt) {
        skilltRepo.save(skillt);
    }

    @Override
    public void deleteSkillT(Long id_skillt) {
        skilltRepo.deleteById(id_skillt);
    }

    @Override
    public SkillT searchSkillT(Long id_skillt) {
        return skilltRepo.findById(id_skillt).orElse(null);
    }

    @Override
    public void editSkillT(Long id_skillt) {
        SkillT skillt = skilltRepo.findById(id_skillt).get();
        skilltRepo.save(skillt);
    }
    
}
