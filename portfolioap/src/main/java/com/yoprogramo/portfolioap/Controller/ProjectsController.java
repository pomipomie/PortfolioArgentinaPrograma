
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Projects;
import com.yoprogramo.portfolioap.Service.IProjectsService;
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
public class ProjectsController {
    
    @Autowired
    public IProjectsService projeServ;
    
    @PostMapping ("/portfolioap/project/new") 
    public void createProject (@RequestBody Projects project) {
        projeServ.createProject(project);
    }
    
    @DeleteMapping ("/portfolioap/project/{id_projects}/delete")
    public void deleteProject (@PathVariable Long id_projects) {
        projeServ.deleteProject(id_projects);
    }
    
    @PutMapping ("/portfolioap/project/edit") 
    public Projects editProject (@RequestBody Projects project) {
        projeServ.editProject(project);
        return project;
    }
    
    @GetMapping ("/portfolioap/project/{id_projects}/search")
    @ResponseBody
    public Projects searchProject (@PathVariable Long id_projects) {
        return projeServ.searchProject(id_projects);
    }
}
