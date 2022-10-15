
package com.yoprogramo.portfolioap.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SkillT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_skillt;
    
    private String skilltype;
    
    @JsonIgnore
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id_skillt")
    private Set<Skills> skills;

    public SkillT() {
    }

    public SkillT(Long id_skillt, String skilltype, Set<Skills> skills) {
        this.id_skillt = id_skillt;
        this.skilltype = skilltype;
        this.skills = skills;
    }
    
}
