
package com.yoprogramo.portfolioap.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.yoprogramo.portfolioap.Model.EducField;
import com.yoprogramo.portfolioap.Service.IEducFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class EducFieldController {
    
    @Autowired
    public IEducFieldService educfServ;
    
    @PostMapping ("/new/educfield") // NOT TESTED
    public void createEducF (@RequestBody EducField educfield) {
        educfServ.createEducF(educfield);
    }
    
    @DeleteMapping ("/educfield/delete/{id_educfield}") //NOT TESTED
    public void deleteEducF (@PathVariable Long id_educfield) {
        educfServ.deleteEducF(id_educfield);
    }
    
    @PutMapping ("/educfield/edit") //NOT TESTED
    public EducField editEducF (@RequestBody EducField educfield) {
        educfServ.editEducF(educfield);
        return educfield;
    }
    
    @GetMapping ("/educfield/search/{id_educfield}") //NOT TESTED
    @ResponseBody
    public EducField searchEducF (@PathVariable Long id_educfield) {
        return educfServ.searchEducF(id_educfield);
    }
}
