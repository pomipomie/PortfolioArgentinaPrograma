
package com.yoprogramo.portfolioap.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.yoprogramo.portfolioap.Model.EducT;
import com.yoprogramo.portfolioap.Service.IEducTService;
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

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class EducTController {
    
    @Autowired
    public IEducTService eductServ;
    
    @PostMapping ("/portfolioap/educt/new")
    public void createEducT (@RequestBody EducT educt) {
        eductServ.createEducT(educt);
    }
    
    @DeleteMapping ("/portfolioap/educt/{id_educt}/delete")
    public void deleteEducT (@PathVariable Long id_educt) {
        eductServ.deleteEducT(id_educt);
    }
    
    @PutMapping ("/portfolioap/educt/edit")
    public EducT editEducT (@RequestBody EducT educt) {
        eductServ.editEducT(educt);
        return educt;
    }
    
    @GetMapping ("/portfolioap/educt/{id_educt}/search")
    @ResponseBody
    public EducT searchEducT (@PathVariable Long id_educt) {
        return eductServ.searchEducT(id_educt);
    }
    
    @GetMapping ("/portfolioap/educt/list")
    @ResponseBody
    public List<EducT> educTList() {
        List<EducT> educts = eductServ.educTList();
        return educts;
    }
}
