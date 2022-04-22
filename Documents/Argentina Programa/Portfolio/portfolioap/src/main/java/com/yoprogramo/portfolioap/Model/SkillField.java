
package com.yoprogramo.portfolioap.Model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @ManyToMany (cascade= CascadeType.ALL, mappedBy="id_skillfield")
    private Set<Skills> skills;
    
}
