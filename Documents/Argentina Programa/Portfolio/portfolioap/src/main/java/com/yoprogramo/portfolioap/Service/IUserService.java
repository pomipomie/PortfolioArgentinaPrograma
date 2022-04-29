
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Education;
import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Model.Projects;
import com.yoprogramo.portfolioap.Model.Skills;
import com.yoprogramo.portfolioap.Model.UserP;
import java.util.List;
import java.util.Set;


public interface IUserService {
    public void createUser (UserP us);
    public void deleteUser (Long id);
    public UserP searchUser (Long id);
    public UserP editUser (UserP us);
    public List<UserP> userList();
    public Set<Experience> seeExp(Long id);
    public Set<Education> seeEduc(Long id);
    public Set<Skills> seeSkill(Long id);
    public Set<Projects> seeProj(Long id);
    public UserP findByEmailAndPassword (String email, String password);
}
