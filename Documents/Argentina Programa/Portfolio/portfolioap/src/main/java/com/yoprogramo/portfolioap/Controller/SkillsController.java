
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Skills;
import com.yoprogramo.portfolioap.Service.ISkillsService;
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
public class SkillsController {
    
    @Autowired
    public ISkillsService skillServ;
    
    @PostMapping ("/new/skill") // NOT TESTED
    public void createSkill (@RequestBody Skills skill) {
        skillServ.createSkill(skill);
    }
    
    @DeleteMapping ("/skill/delete/{id_skills}") //NOT TESTED
    public void deleteSkill (@PathVariable Long id_skills) {
        skillServ.deleteSkill(id_skills);
    }
    
    @PutMapping ("/skill/edit") //NOT TESTED
    public Skills editSkill (@RequestBody Skills skill) {
        skillServ.editSkill(skill);
        return skill;
    }
    
    @GetMapping ("/skill/search/{id_skills}") //NOT TESTED
    @ResponseBody
    public Skills searchSkill (@PathVariable Long id_skills) {
        return skillServ.searchSkill(id_skills);
    }
}