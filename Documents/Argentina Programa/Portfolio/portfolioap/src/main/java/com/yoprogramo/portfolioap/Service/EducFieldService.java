
package com.yoprogramo.portfolioap.Service;

import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioap.Model.EducField;
import com.yoprogramo.portfolioap.Repository.IEducFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EducFieldService implements IEducFieldService {
    
    @Autowired
    public IEducFieldRepository educfRepo;

    @Override
    public void createEducF(EducField educfield) {
        educfRepo.save(educfield);
    }

    @Override
    public void deleteEducF(Long id_educfield) {
        educfRepo.deleteById(id_educfield);
    }

    @Override
    public EducField searchEducF(Long id_educfield) {
        return educfRepo.findById(id_educfield).orElse(null);
    }

    @Override
    public void editEducF(Long id_educfield) {
        EducField educfield = educfRepo.findById(id_educfield).get();
        educfRepo.save(educfield);
    }
    
}
