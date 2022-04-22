
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Education;
import com.yoprogramo.portfolioap.Service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {
    
    @Autowired
    public IEducationService eduServ;
    
    @PostMapping ("/new/education") // NOT TESTED
    public void createEduc (@RequestBody Education educ) {
        eduServ.createEduc(educ);
    }
    
    @DeleteMapping ("/education/delete/{id_educ}") //NOT TESTED
    public void deleteEduc (@PathVariable Long id_educ) {
        eduServ.deleteEduc(id_educ);
    }
    
    @PutMapping ("/education/edit/{id_educ}") //NOT TESTED
    public void editEduc (@PathVariable Long id_educ, @RequestBody Education educ) {
        eduServ.editEduc(id_educ);
    }
    
    @GetMapping ("/education/search/{id_educ}") //NOT TESTED
    @ResponseBody
    public Education searchEduc (@PathVariable Long id_educ) {
        return eduServ.searchEduc(id_educ);
    }
}
