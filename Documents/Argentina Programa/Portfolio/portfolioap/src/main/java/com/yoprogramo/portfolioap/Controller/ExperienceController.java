
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
    
    @PostMapping ("/new/experience")
    public void createExp (@RequestBody Experience exp) {
       expServ.createExp(exp);
    }
    
    @DeleteMapping ("/delete/{id_exp}")
    public void deleteExp (@PathVariable Long id_exp) {
        expServ.deleteExp(id_exp);
    }
    
    @PutMapping ("/edit/{id_exp}")
    public void editExp (@PathVariable Long id_exp) {
        expServ.editExp(id_exp);
    }
    
    @GetMapping ("/search/{id_exp}")
    @ResponseBody
    public Experience searchExp (Long id_exp) {
        return expServ.searchExp(id_exp);
    }
    
}
