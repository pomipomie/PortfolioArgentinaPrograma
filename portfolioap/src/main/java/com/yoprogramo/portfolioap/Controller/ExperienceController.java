
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Service.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class ExperienceController {
    
    @Autowired
    private IExperienceService expServ;
    
    @PostMapping ("/portfolioap/experience/new")
    public void createExp (@RequestBody Experience exp) {
        expServ.createExp(exp);
    }
    
    @DeleteMapping ("/portfolioap/experience/{id_exp}/delete") 
    public void deleteExp (@PathVariable Long id_exp) {
        expServ.deleteExp(id_exp);
    }
    
    @PutMapping ("/portfolioap/experience/edit") 
    public Experience editExp (@RequestBody Experience exp) {
        expServ.editExp(exp);
        return exp;
    }
    
    @GetMapping ("/portfolioap/experience/{id_exp}/search")
    @ResponseBody
    public Experience searchExp (@PathVariable Long id_exp) {
        return expServ.searchExp(id_exp);
    }
    
}
