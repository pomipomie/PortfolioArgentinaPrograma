package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Education;

public interface IEducationService {
    public void createEduc (Education educ);
    public void deleteEduc (Long id_educ);
    public Education searchEduc (Long id_educ);
    public void editEduc (Long id_educ);
}
