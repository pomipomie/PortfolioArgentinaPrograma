
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Projects;
import com.yoprogramo.portfolioap.Service.IProjectsService;
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
public class ProjectsController {
    
    @Autowired
    public IProjectsService projeServ;
    
    @PostMapping ("/new/project") // NOT TESTED
    public void createProject (@RequestBody Projects project) {
        projeServ.createProject(project);
    }
    
    @DeleteMapping ("/project/delete/{id_projects}") //NOT TESTED
    public void deleteProject (@PathVariable Long id_projects) {
        projeServ.deleteProject(id_projects);
    }
    
    @PutMapping ("/project/edit") //NOT TESTED
    public Projects editProject (@RequestBody Projects project) {
        projeServ.editProject(project);
        return project;
    }
    
    @GetMapping ("/project/search/{id_projects}") //NOT TESTED
    @ResponseBody
    public Projects searchProject (@PathVariable Long id_projects) {
        return projeServ.searchProject(id_projects);
    }
}
