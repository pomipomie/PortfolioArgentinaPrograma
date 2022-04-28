
package com.yoprogramo.portfolioap.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class ExpT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_expt;
    
    private String jobType;
    
    @JsonManagedReference
    @JsonIgnore
    @OneToMany (cascade= CascadeType.ALL, mappedBy="id_expt")
    private Set<Experience> exps;

    public ExpT() {
    }

    public ExpT(Long id_expt, String jobType, Set<Experience> exps) {
        this.id_expt = id_expt;
        this.jobType = jobType;
        this.exps = exps;
    }

    public ExpT(String jobType, Set<Experience> exps) {
        this.jobType = jobType;
        this.exps = exps;
    }
    
    

}
