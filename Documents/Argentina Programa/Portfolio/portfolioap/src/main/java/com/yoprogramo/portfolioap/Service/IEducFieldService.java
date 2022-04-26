
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.EducField;

public interface IEducFieldService {
    public void createEducF (EducField educfield);
    public void deleteEducF (Long id_educfield);
    public EducField searchEducF (Long id_educfield);
    public EducField editEducF (EducField educfield);
}
