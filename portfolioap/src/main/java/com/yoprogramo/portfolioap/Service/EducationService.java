
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Education;
import com.yoprogramo.portfolioap.Repository.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
    
    @Autowired
    public IEducationRepository eduRepo;

    @Override
    public void createEduc(Education educ) {
        eduRepo.save(educ);
    }

    @Override
    public void deleteEduc(Long id_educ) {
        eduRepo.deleteById(id_educ);
    }

    @Override
    public Education searchEduc(Long id_educ) {
        return eduRepo.findById(id_educ).orElse(null);
    }

    @Override
    public Education editEduc(Education educ) {
        Education updatededuc = eduRepo.save(educ);
        return updatededuc;
    }
    
}
