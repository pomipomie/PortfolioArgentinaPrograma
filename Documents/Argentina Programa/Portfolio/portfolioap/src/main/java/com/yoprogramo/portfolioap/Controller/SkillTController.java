
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.SkillT;
import com.yoprogramo.portfolioap.Service.ISkillTService;
import java.util.List;
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
@CrossOrigin(origins = {"https://portfolio-ap-mxb.web.app/"})
public class SkillTController {
    
    @Autowired
    public ISkillTService skilltServ;
    
    @PostMapping ("/portfolioap/skilltype/new")
    public void createSkillT (@RequestBody SkillT skillt) {
        skilltServ.createSkillT(skillt);
    }
    
    @DeleteMapping ("/portfolioap/skilltype/{id_skillt}/delete") 
    public void deleteSkillT (@PathVariable Long id_skillt) {
        skilltServ.deleteSkillT(id_skillt);
    }
    
    @PutMapping ("/portfolioap/skilltype/edit")
    public SkillT editSkillT (@RequestBody SkillT skillt) {
        skilltServ.editSkillT(skillt);
        return skillt;
    }
    
    @GetMapping ("/portfolioap/skilltype/{id_skillt}/search") 
    @ResponseBody
    public SkillT searchSkillT (@PathVariable Long id_skillt) {
        return skilltServ.searchSkillT(id_skillt);
    }
    
    @GetMapping ("/portfolioap/skilltype/list")
    @ResponseBody
    public List<SkillT> skillTList() {
        List<SkillT> skillts = skilltServ.SkillTList();
        return skillts;
    }
}
