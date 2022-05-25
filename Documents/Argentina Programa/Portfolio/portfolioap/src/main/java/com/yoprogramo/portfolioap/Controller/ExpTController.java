
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.ExpT;
import com.yoprogramo.portfolioap.Service.IExpTService;
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
public class ExpTController {
    
    @Autowired
    private IExpTService exptServ;
    
    @PostMapping ("/portfolioap/exptype/new")
    public void createExpT (@RequestBody ExpT expt) {
       exptServ.createExpT(expt);
    }
    @DeleteMapping ("/portfolioap/exptype/{id_expt}/delete")
    public void deleteExpT (@PathVariable Long id_expt) {
        exptServ.deleteExpT(id_expt);
    }
    
    @PutMapping ("/portfolioap/exptype/edit") //NOT TESTED
    public ExpT editExpT (@RequestBody ExpT expt) {
        exptServ.editExpT(expt);
        return expt;
    }
    
    @GetMapping ("/portfolioap/exptype/{id_expt}/search")
    @ResponseBody
    public ExpT searchExpT (@PathVariable Long id_expt) {
        return exptServ.searchExpT(id_expt);
    }
    
    @GetMapping ("/portfolioap/exptype/list")
    @ResponseBody
    public List<ExpT> expTList() {
        List<ExpT> expts = exptServ.expTList();
        return expts;
    }
}
