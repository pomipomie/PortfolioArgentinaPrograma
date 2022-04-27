
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Model.UserP;
import com.yoprogramo.portfolioap.Service.IUserService;
import java.util.Set;
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
public class UserController {
    
    @Autowired
    private IUserService userServ;
    
    @PostMapping ("/new/user")
    public void createUser (@RequestBody UserP us) {
       userServ.createUser(us);
    }
    
    @DeleteMapping ("/user/delete{id}")
    public void deleteUser (@PathVariable Long id) {
        userServ.deleteUser(id);
    }
    
    @PutMapping ("/user/edit")
    public UserP editUser (@RequestBody UserP us) {   
        userServ.editUser(us);
         return us;
    }
    
    @GetMapping ("/user/search{id}")
    @ResponseBody
    public UserP searchUser(@PathVariable Long id) {
        return userServ.searchUser(id);
    }
    
    @GetMapping ("/{id}/experience")
    @ResponseBody 
    public Set<Experience> seeExp(@PathVariable Long id) {
        return userServ.seeExp(id);
    }
    
     @PostMapping ("user/login")
     public UserP login (@RequestBody UserP us) {
         return(userServ.login(us.getEmail(),us.getPassword()));
     }
}
