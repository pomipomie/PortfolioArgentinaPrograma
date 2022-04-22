
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
public class EducField {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_educfield;

    private String field;
    
    @ManyToMany (cascade= CascadeType.ALL, mappedBy="id_educfield")
    private Set<Education> educs;

    public EducField() {
    }

    public EducField(Long id_educfield, String field, Set<Education> educs) {
        this.id_educfield = id_educfield;
        this.field = field;
        this.educs = educs;
    }
    
    
}
