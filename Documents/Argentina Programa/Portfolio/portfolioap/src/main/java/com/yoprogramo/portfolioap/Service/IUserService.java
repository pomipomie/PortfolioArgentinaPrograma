
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Experience;
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
    public UserP findByEmailAndPassword (String email, String password);
}
