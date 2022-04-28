
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Model.UserP;
import com.yoprogramo.portfolioap.Repository.IExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {
    
    @Autowired
    public IExperienceRepository expRepo;

    @Override
    public void createExp(Experience exp) {
        expRepo.save(exp);
    }

    @Override
    public void deleteExp(Long id_exp) {
       expRepo.deleteById(id_exp);
    }

    @Override
    public Experience searchExp(Long id_exp) {
        return expRepo.findById(id_exp).orElse(null);
    }

    @Override
    public Experience editExp(Experience exp) {
        Experience updatedexp = expRepo.save(exp);
        return updatedexp;
    }
    
}
