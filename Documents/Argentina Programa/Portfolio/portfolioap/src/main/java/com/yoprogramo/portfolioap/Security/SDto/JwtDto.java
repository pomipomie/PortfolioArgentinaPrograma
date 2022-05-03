
package com.yoprogramo.portfolioap.Security.SDto;

//import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String email;
//    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String email /*, Collection<? extends GrantedAuthority> authorities*/) {
        this.token = token;
        this.email = email;
//        this.authorities = authorities;
    }
    
        
}
