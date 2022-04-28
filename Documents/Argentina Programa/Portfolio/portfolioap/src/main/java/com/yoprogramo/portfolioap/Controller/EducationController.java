
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
    
    @PostMapping ("/portfolioap/education/new")
    public void createEduc (@RequestBody Education educ) {
        eduServ.createEduc(educ);
    }
    
    @DeleteMapping ("/portfolioap/education/{id_educ}/delete")
    public void deleteEduc (@PathVariable Long id_educ) {
        eduServ.deleteEduc(id_educ);
    }
    
    @PutMapping ("/portfolioap/education/edit")
    public Education editEduc (@RequestBody Education educ) {
        eduServ.editEduc(educ);
        return educ;
    }
    
    @GetMapping ("/portfolioap/education/{id_educ}/search")
    @ResponseBody
    public Education searchEduc (@PathVariable Long id_educ) {
        return eduServ.searchEduc(id_educ);
    }
}
