
package Security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.yoprogramo.portfolioap.Model.UserP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class UserDetailsImpl implements UserDetails {
    Authentication authentication = 
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
    
    IUserDetails userDetails = (IUserDetails) authentication.getPrincipal();
     userDetails.getUsername()
     userDetails.getPassword()
}

// https://github.com/bezkoder/spring-boot-login-example/blob/master/src/main/java/com/bezkoder/spring/login/security/services/UserDetailsImpl.java
// https://www.bezkoder.com/spring-boot-login-example-mysql/

//OTHER TUTORIALS
// https://www.youtube.com/watch?v=L9oWG6aj_U8 
// https://github.com/RameshMF/registration-login-spring-boot-security-thymeleaf-hibernate/blob/master/src/main/java/net/javaguides/springboot/service/UserServiceImpl.java 
// https://github.com/cavanosa/crudBACK/blob/master/src/main/java/com/tutorial/crud/controller/ProductoController.java
