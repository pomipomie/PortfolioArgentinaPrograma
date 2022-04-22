
package com.yoprogramo.portfolioap.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    
    @ManyToMany 
    @JoinColumn (name="id_skillfield", nullable= false)
    private SkillField id_skillfield;
}
