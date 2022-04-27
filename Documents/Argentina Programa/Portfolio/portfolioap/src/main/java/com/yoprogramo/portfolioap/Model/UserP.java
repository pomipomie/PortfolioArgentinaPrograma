
package com.yoprogramo.portfolioap.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
//import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class UserP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String lastName;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    
    private String phone;
    private String location;
    private String picUrl;
    private String aboutText;
    private String email;
    private String password;
    
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id")
    private Set<Experience> exps;
    
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id")
    private Set<Education> educs;
    
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id")
    private Set<Skills> skills;
    
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id")
    private Set<Projects> projects;

    public UserP() {
    }

    public UserP(Long id,
                String firstName,
                String lastName,
                LocalDate birthDate,
                String phone,
                String location,
                String picUrl,
                String aboutText,
                String email,
                String password,
                Set<Experience> exps,
                Set<Education> educs,
                Set<Skills> skills,
                Set<Projects> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.location = location;
        this.picUrl = picUrl;
        this.aboutText = aboutText;
        this.email = email;
        this.password = password;
        this.exps = exps;
        this.educs = educs;
        this.skills = skills;
        this.projects = projects;
    }
    
        public UserP(String firstName,
                String lastName,
                LocalDate birthDate,
                String phone,
                String location,
                String picUrl,
                String aboutText,
                String email,
                String password,
                Set<Experience> exps,
                Set<Education> educs,
                Set<Skills> skills,
                Set<Projects> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.location = location;
        this.picUrl = picUrl;
        this.aboutText = aboutText;
        this.email = email;
        this.password = password;
        this.exps = exps;
        this.educs = educs;
        this.skills = skills;
        this.projects = projects;
    }

        public Set<Experience> getExps(UserP us) {
        return us.exps;
    }
}
