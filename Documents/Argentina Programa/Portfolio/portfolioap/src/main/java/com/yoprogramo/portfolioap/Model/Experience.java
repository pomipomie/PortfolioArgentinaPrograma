package com.yoprogramo.portfolioap.Model;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
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
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_exp;
    
    private String workplace;
    
    @JsonFormat(pattern="yyyy-MM")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM")
    private LocalDate endDate;
    
    private String job;
    private String description;
    private String place;
    
   // @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "id", nullable = false)
    private UserP id;
    
   // @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "id_exp_t", nullable = false)
    private ExpT id_expt;

    public Experience() {
    }

    public Experience(Long id_exp,
                      String workplace,
                      LocalDate startDate,
                      LocalDate endDate,
                      String job,
                      String description,
                      String place,
                      UserP id,
                      ExpT id_expt) {
        this.id_exp = id_exp;
        this.workplace = workplace;
        this.startDate = startDate;
        this.endDate = endDate;
        this.job = job;
        this.description = description;
        this.place = place;
        this.id = id;
        this.id_expt = id_expt;
    }

}
