
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.ExpT;
import com.yoprogramo.portfolioap.Repository.IExpTRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpTService implements IExpTService {
    
    @Autowired
    public IExpTRepository exptRepo;

    @Override
    public void createExpT(ExpT expt) {
        exptRepo.save(expt);
    }

    @Override
    public void deleteExpT(Long id_expt) {
        exptRepo.deleteById(id_expt);
    }

    @Override
    public ExpT searchExpT(Long id_expt) {
        return exptRepo.findById(id_expt).orElse(null);
    }

    @Override
    public ExpT editExpT(ExpT expt) {
       ExpT updatedExpt = exptRepo.save(expt);
       return updatedExpt;
    }

    @Override
    public List<ExpT> expTList() {
        List<ExpT> expts = exptRepo.saveAll(exptRepo.findAll());
        return expts;
    }
    
}
