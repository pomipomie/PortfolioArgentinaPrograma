
package com.yoprogramo.portfolioap.Model;

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
    
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id_skillt")
    private Set<Skills> skills;
}
