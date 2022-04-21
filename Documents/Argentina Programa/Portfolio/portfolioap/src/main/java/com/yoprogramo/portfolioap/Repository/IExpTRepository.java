
package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.ExpT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpTRepository extends JpaRepository <ExpT, Long> {
    
}
