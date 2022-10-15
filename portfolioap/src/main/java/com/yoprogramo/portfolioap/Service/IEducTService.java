
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.EducT;
import java.util.List;

public interface IEducTService {
    public void createEducT (EducT educt);
    public void deleteEducT (Long id_educt);
    public EducT searchEducT (Long id_educt);
    public EducT editEducT (EducT educt);
    public List<EducT> educTList();
}
