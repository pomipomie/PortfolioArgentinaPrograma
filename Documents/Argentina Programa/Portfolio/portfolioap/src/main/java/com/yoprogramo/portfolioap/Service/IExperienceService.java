
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Experience;

public interface IExperienceService {
    public void createExp (Experience exp);
    public void deleteExp (Long id_exp);
    public Experience searchExp (Long id_exp);
    public void editExp (Long id_exp);
}
