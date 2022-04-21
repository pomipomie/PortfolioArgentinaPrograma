
package com.yoprogramo.portfolioap.Service;

import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Model.UserP;
import com.yoprogramo.portfolioap.Repository.IUserRepository;
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
    public void editUser(Long id) {
       UserP us = userRepo.findById(id).get();
       us.setLocation(us.getLocation());
       userRepo.save(us);
    }

    @Override
    public Set<Experience> seeExp(Long id) {
       UserP us = userRepo.findById(id).get();
       return us.getExps(us);
    }
    
}
