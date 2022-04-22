
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.SkillT;
import com.yoprogramo.portfolioap.Service.ISkillTService;
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
public class SkillTController {
    
    @Autowired
    public ISkillTService skilltServ;
    
    @PostMapping ("/new/skilltype") // NOT TESTED
    public void createSkillT (@RequestBody SkillT skillt) {
        skilltServ.createSkillT(skillt);
    }
    
    @DeleteMapping ("/skilltype/delete/{id_skillt}") //NOT TESTED
    public void deleteSkillT (@PathVariable Long id_skillt) {
        skilltServ.deleteSkillT(id_skillt);
    }
    
    @PutMapping ("/skilltype/edit/{id_skillt}") //NOT TESTED
    public void editSkillT (@PathVariable Long id_skillt, @RequestBody SkillT skillt) {
        skilltServ.editSkillT(id_skillt);
    }
    
    @GetMapping ("/skilltype/search/{id_skillt}") //NOT TESTED
    @ResponseBody
    public SkillT searchSkillT (@PathVariable Long id_skillt) {
        return skilltServ.searchSkillT(id_skillt);
    }
}
