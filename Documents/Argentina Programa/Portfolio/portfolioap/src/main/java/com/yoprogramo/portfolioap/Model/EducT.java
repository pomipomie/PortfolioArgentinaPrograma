
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
public class EducT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_educt;
    
    private String educType;
    
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id_educt")
    private Set<Education> educs;

    public EducT() {
    }

    public EducT(Long id_educt, String educType, Set<Education> educs) {
        this.id_educt = id_educt;
        this.educType = educType;
        this.educs = educs;
    }
    
}
