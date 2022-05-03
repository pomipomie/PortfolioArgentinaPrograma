
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Education;
import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Model.Projects;
import com.yoprogramo.portfolioap.Model.Skills;
import com.yoprogramo.portfolioap.Model.UserP;
import com.yoprogramo.portfolioap.Repository.IUserRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    
    @Autowired
    public IUserRepository userRepo;

    @Override
    public void createUser(UserP us) {
        userRepo.save(us);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserP searchUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public UserP editUser(UserP us) {
       UserP updatedUs = userRepo.save(us);
       return updatedUs;
    }

    @Override
    public Set<Experience> seeExp(Long id) {
       UserP us = userRepo.findById(id).get();
       return us.getExps();
    }

    @Override
    public List<UserP> userList() {
        List<UserP> users = userRepo.saveAll(userRepo.findAll());
        return users;
    }

    @Override
    public UserP findByEmailAndPassword(String email, String password) {
        UserP us = userRepo.findByEmailAndPassword(email, password);
        return us; 
    }

    @Override
    public Set<Education> seeEduc(Long id) {
        UserP us = userRepo.findById(id).get();
        return us.getEducs();
    }

    @Override
    public Set<Skills> seeSkill(Long id) {
        UserP us = userRepo.findById(id).get();
        return us.getSkills();
    }

    @Override
    public Set<Projects> seeProj(Long id) {
        UserP us = userRepo.findById(id).get();
        return us.getProjects();
    }

    @Override
    public UserP findByEmail(String email) {
        UserP us = userRepo.findByEmail(email);
        return us;
    }
    
}
