
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
    public UserP editUser(Long id, UserP us) {
    //    us = userRepo.findById(id).get();
    //   UserP userp = userRepo.findById(id).get();
    //   us = userp;
       us.setLocation(us.getLocation());
    //   us = userRepo.save(us);   /// ME CREA UNA NUEVA INSTANCIA, SIN ESTO NO CREA NI MODIFICA NADA
       return us;
    }

    @Override
    public Set<Experience> seeExp(Long id) {
       UserP us = userRepo.findById(id).get();
       return us.getExps(us);
    }
    
}
