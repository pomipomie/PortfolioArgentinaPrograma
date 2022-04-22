
package com.yoprogramo.portfolioap.Service;

import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioap.Model.Projects;
import com.yoprogramo.portfolioap.Repository.IProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProjectsService implements IProjectsService {
    
    @Autowired
    public IProjectsRepository projeRepo;

    @Override
    public void createProject(Projects project) {
        projeRepo.save(project);
    }

    @Override
    public void deleteProject(Long id_projects) {
        projeRepo.deleteById(id_projects);
    }

    @Override
    public Projects searchProject(Long id_projects) {
        return projeRepo.findById(id_projects).orElse(null);
    }

    @Override
    public void editProject(Long id_projects) {
        Projects project = projeRepo.findById(id_projects).get();
        projeRepo.save(project);
    }
}
