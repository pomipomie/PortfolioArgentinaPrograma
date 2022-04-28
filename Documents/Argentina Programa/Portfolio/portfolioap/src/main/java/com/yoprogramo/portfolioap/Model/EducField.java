
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
public class EducField {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_educfield;

    private String field;
    
    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "education_educfield",
            joinColumns = @JoinColumn(name = "id_educfield"),
            inverseJoinColumns = @JoinColumn(name = "id_educ")
    )
    private Set<Education> educs;

    public EducField() {
    }

    public EducField(Long id_educfield, String field, Set<Education> educs) {
        this.id_educfield = id_educfield;
        this.field = field;
        this.educs = educs;
    }
    
    
}
