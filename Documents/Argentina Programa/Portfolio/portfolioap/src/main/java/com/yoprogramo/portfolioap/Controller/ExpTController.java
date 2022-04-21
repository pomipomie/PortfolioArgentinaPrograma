
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.ExpT;
import com.yoprogramo.portfolioap.Service.IExpTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpTController {
    
    @Autowired
    private IExpTService exptServ;
    
    @PostMapping ("/new/exptype")
    public void createExpT (@RequestBody ExpT expt) {
       exptServ.createExpT(expt);
    }
    @DeleteMapping ("/delete/{id_expt}")
    public void deleteExpT (@PathVariable Long id_expt) {
        exptServ.deleteExpT(id_expt);
    }
    @GetMapping ("/search/{id_expt}")
    @ResponseBody
    public ExpT searchExpT (Long id_expt) {
        return exptServ.searchExpT(id_expt);
    }
}