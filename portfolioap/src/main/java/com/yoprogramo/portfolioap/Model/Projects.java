
package com.yoprogramo.portfolioap.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Projects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_projects;
    
    private String pname;
    private String pdescription;
    private String purl;
    private String ppreview;
    
    @ManyToOne
    @JoinColumn (name = "id", nullable = false)
    private UserP id;

    public Projects() {
    }

    public Projects(Long id_projects, String pname, String pdescription, String purl, String ppreview, UserP id) {
        this.id_projects = id_projects;
        this.pname = pname;
        this.pdescription = pdescription;
        this.purl = purl;
        this.ppreview = ppreview;
        this.id = id;
    }
    
}
