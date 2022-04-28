
package com.yoprogramo.portfolioap.Repository;

import com.yoprogramo.portfolioap.Model.UserP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository <UserP, Long> {
    UserP findByEmailAndPassword(String email, String password);
}
