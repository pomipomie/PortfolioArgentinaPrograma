
package com.yoprogramo.portfolioap.Model;

import java.util.Date;
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
    private Date birthDate;
    private String phone;
    private String location;
    private String picUrl;
    private String aboutText;
    
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id")
    private Set<Experience> exps;

    public UserP() {
    }

    public UserP(Long id, String firstName, String lastName, Date birthDate, String phone, String location, String picUrl, String aboutText, Set<Experience> exps) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.location = location;
        this.picUrl = picUrl;
        this.aboutText = aboutText;
        this.exps = exps;
    }
    
        public Set<Experience> getExps(UserP us) {
        return us.exps;
    }
}
