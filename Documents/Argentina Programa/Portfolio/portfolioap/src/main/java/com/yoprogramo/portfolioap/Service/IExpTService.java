
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.ExpT;

public interface IExpTService {
    public void createExpT (ExpT expt);
    public void deleteExpT (Long id_expt);
    public ExpT searchExpT (Long id_expt);
}
