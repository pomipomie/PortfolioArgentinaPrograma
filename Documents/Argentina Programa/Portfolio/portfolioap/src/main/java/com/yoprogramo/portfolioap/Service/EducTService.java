
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.EducT;
import com.yoprogramo.portfolioap.Repository.IEducTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducTService implements IEducTService {
    
    @Autowired
    public IEducTRepository eductRepo;

    @Override
    public void createEducT(EducT educt) {
        eductRepo.save(educt);
    }

    @Override
    public void deleteEducT(Long id_educt) {
        eductRepo.deleteById(id_educt);
    }

    @Override
    public EducT searchEducT(Long id_educt) {
        return eductRepo.findById(id_educt).orElse(null);
    }

    @Override
    public EducT editEducT(EducT educt) {
       EducT updatedEduct = eductRepo.save(educt);
       return updatedEduct;
    }
    
}
