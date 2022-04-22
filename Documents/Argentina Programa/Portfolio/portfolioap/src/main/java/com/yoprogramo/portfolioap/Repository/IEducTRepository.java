
package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.EducT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducTRepository extends JpaRepository <EducT, Long> {
    
}
