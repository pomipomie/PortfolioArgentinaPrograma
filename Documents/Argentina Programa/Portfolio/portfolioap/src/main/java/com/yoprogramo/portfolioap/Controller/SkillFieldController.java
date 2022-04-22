
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.SkillField;
import com.yoprogramo.portfolioap.Service.ISkillFieldService;
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
public class SkillFieldController {
    
    @Autowired
    public ISkillFieldService skillfServ;
    
    @PostMapping ("/new/skillfield") // NOT TESTED
    public void createSkillF (@RequestBody SkillField skillfield) {
        skillfServ.createSkillF(skillfield);
    }
    
    @DeleteMapping ("/skillfield/delete/{id_skillfield}") //NOT TESTED
    public void deleteSkillF (@PathVariable Long id_skillfield) {
        skillfServ.deleteSkillF(id_skillfield);
    }
    
    @PutMapping ("/skillfield/edit/{id_skillfield}") //NOT TESTED
    public void editSkillF (@PathVariable Long id_skillfield, @RequestBody SkillField skillfield) {
        skillfServ.editSkillF(id_skillfield);
    }
    
    @GetMapping ("/skillfield/search/{id_skillfield}") //NOT TESTED
    @ResponseBody
    public SkillField searchSkillF (@PathVariable Long id_skillfield) {
        return skillfServ.searchSkillF(id_skillfield);
    }
}
