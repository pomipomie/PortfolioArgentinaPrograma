
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Service.IExperienceService;
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
public class ExperienceController {
    
    @Autowired
    private IExperienceService expServ;
    
    @PostMapping ("/new/experience")  //NOT WORKING
    public void createExp (@RequestBody Experience exp) {
       expServ.createExp(exp);
    }
    
    @DeleteMapping ("/experience/delete/{id_exp}") // STILL NOT TESTED
    public void deleteExp (@PathVariable Long id_exp) {
        expServ.deleteExp(id_exp);
    }
    
    @PutMapping ("/experience/edit/{id_exp}") // STILL NOT TESTED
    public void editExp (@PathVariable Long id_exp, @RequestBody Experience exp) {
        expServ.editExp(id_exp);
    }
    
    @GetMapping ("/experience/search/{id_exp}") // STILL NOT TESTED
    @ResponseBody
    public Experience searchExp (@PathVariable Long id_exp) {
        return expServ.searchExp(id_exp);
    }
    
}
