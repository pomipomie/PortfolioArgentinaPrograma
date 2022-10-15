
package com.yoprogramo.portfolioap.Model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_skills;
    
    private String skillname;
    private int skillvalue;
    
    @ManyToOne
    @JoinColumn (name = "id", nullable = false)
    private UserP id;
    
    @ManyToOne
    @JoinColumn (name="id_skillt", nullable= false)
    private SkillT id_skillt;
    
    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
   @JoinTable(name = "skills_skillfield",
            joinColumns = @JoinColumn(name = "id_skills"),
            inverseJoinColumns = @JoinColumn(name = "id_skillfield")
    )
    private Set<SkillField> skillfields;

    public Skills() {
    }

    public Skills(Long id_skills, String skillname, int skillvalue, UserP id, SkillT id_skillt, Set<SkillField> skillfields) {
        this.id_skills = id_skills;
        this.skillname = skillname;
        this.skillvalue = skillvalue;
        this.id = id;
        this.id_skillt = id_skillt;
        this.skillfields = skillfields;
    }
    
    
}
