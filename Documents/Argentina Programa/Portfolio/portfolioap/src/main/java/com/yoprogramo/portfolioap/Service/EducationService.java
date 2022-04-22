
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
    public void editEduc(Long id_educ) {
        Education educ = eduRepo.findById(id_educ).get();
        eduRepo.save(educ);
    }
    
}
