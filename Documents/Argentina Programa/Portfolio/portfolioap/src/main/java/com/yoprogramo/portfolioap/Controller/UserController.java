
package com.yoprogramo.portfolioap.Controller;

import com.yoprogramo.portfolioap.Model.Education;
import com.yoprogramo.portfolioap.Model.Experience;
import com.yoprogramo.portfolioap.Model.Projects;
import com.yoprogramo.portfolioap.Model.Skills;
import com.yoprogramo.portfolioap.Model.UserP;
import com.yoprogramo.portfolioap.Service.IUserService;
import java.util.List;
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
    
    @PostMapping ("/portfolioap/user/new")
    public void createUser (@RequestBody UserP us) {
       userServ.createUser(us);
    }
    
    @DeleteMapping ("/portfolioap/user/{id}/delete")
    public void deleteUser (@PathVariable Long id) {
        userServ.deleteUser(id);
    }
    
    @PutMapping ("/portfolioap/user/edit")
    public UserP editUser (@RequestBody UserP us) {   
        userServ.editUser(us);
         return us;
    }
    
    @GetMapping ("/portfolioap/user/{id}/search")
    @ResponseBody
    public UserP searchUser(@PathVariable Long id) {
        return userServ.searchUser(id);
    }
    
    @GetMapping ("/portfolioap/user/list")
    @ResponseBody
    public List<UserP> userList() {
        List<UserP> users = userServ.userList();
        return users;
    }
    
    @GetMapping ("/portfolioap/user/{id}/experience")
    @ResponseBody 
    public Set<Experience> seeExp(@PathVariable Long id) {
        return userServ.seeExp(id);
    }
    
    @GetMapping ("/portfolioap/user/{id}/education")
    @ResponseBody 
    public Set<Education> seeEduc(@PathVariable Long id) {
        return userServ.seeEduc(id);
    }
    
    @GetMapping ("/portfolioap/user/{id}/skills")
    @ResponseBody 
    public Set<Skills> seeSkill(@PathVariable Long id) {
        return userServ.seeSkill(id);
    }
    
    @GetMapping ("/portfolioap/user/{id}/projects")
    @ResponseBody 
    public Set<Projects> seeProj(@PathVariable Long id) {
        return userServ.seeProj(id);
    }
    
    @PostMapping ("/portfolioap/user/login")
    @ResponseBody
    public UserP login (@RequestBody UserP us) {
        return userServ.findByEmailAndPassword(us.getEmail(),us.getPassword());
    }
}
