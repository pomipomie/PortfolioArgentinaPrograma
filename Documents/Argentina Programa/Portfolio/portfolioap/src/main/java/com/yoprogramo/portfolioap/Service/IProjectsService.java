
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Projects;

public interface IProjectsService {
    public void createProject (Projects project);
    public void deleteProject (Long id_projects);
    public Projects searchProject (Long id_projects);
    public void editProject (Long id_projects);
}
