
package com.yoprogramo.portfolioap.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class SkillField {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_skillfield;
    
    private String skillfield;
    
    @JsonIgnore
    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
   @JoinTable(name = "skills_skillfield",
            joinColumns = @JoinColumn(name = "id_skillfield"),
            inverseJoinColumns = @JoinColumn(name = "id_skills")
    )
    private Set<Skills> skills;

    public SkillField() {
    }

    public SkillField(Long id_skillfield, String skillfield, Set<Skills> skills) {
        this.id_skillfield = id_skillfield;
        this.skillfield = skillfield;
        this.skills = skills;
    }
    
}
