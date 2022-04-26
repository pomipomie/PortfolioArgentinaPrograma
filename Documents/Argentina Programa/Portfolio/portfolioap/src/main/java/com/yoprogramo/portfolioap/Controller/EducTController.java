
package com.yoprogramo.portfolioap.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.yoprogramo.portfolioap.Model.EducT;
import com.yoprogramo.portfolioap.Service.IEducTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class EducTController {
    
    @Autowired
    public IEducTService eductServ;
    
    @PostMapping ("/new/educt") // NOT TESTED
    public void createEducT (@RequestBody EducT educt) {
        eductServ.createEducT(educt);
    }
    
    @DeleteMapping ("/educt/delete/{id_educt}") //NOT TESTED
    public void deleteEducT (@PathVariable Long id_educt) {
        eductServ.deleteEducT(id_educt);
    }
    
    @PutMapping ("/educt/edit") //NOT TESTED
    public EducT editEducT (@RequestBody EducT educt) {
        eductServ.editEducT(educt);
        return educt;
    }
    
    @GetMapping ("/educt/search/{id_educt}") //NOT TESTED
    @ResponseBody
    public EducT searchEducT (@PathVariable Long id_educt) {
        return eductServ.searchEducT(id_educt);
    }
}
