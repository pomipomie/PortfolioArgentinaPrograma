
package com.yoprogramo.portfolioap.Model;

import java.util.Date;
import java.util.Set;
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
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_educ;
    
    private String institution;
    private String educInfo;
    private String educUrl;
    private String place;
    private String certif;
    private Date startDate;
    private Date endDate;
    
    @ManyToOne
    @JoinColumn (name = "id", nullable = false)
    private UserP id;
    
    @ManyToOne
    @JoinColumn (name="id_educt", nullable= false)
    private EducT id_educt;
    
    @ManyToMany(mappedBy="educs")
    private Set<EducField> educfields;
    
    public Education() {
    }

    public Education(Long id_educ, String institution, String educInfo, String educUrl, String place, String certif, Date startDate, Date endDate, UserP id, EducT id_educt, Set<EducField> educfields) {
        this.id_educ = id_educ;
        this.institution = institution;
        this.educInfo = educInfo;
        this.educUrl = educUrl;
        this.place = place;
        this.certif = certif;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
        this.id_educt = id_educt;
        this.educfields = educfields;
    }

    
      
    
}
