
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.EducT;

public interface IEducTService {
    public void createEducT (EducT educt);
    public void deleteEducT (Long id_educt);
    public EducT searchEducT (Long id_educt);
    public void editEducT (Long id_educt);
}
