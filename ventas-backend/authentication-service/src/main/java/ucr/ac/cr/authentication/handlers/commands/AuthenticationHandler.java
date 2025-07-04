package ucr.ac.cr.authentication.handlers.commands;

import ucr.ac.cr.authentication.exceptions.BusinessException;
import ucr.ac.cr.authentication.handlers.queries.UserAuthenticationQuery;
import ucr.ac.cr.authentication.http.JwtService;
import ucr.ac.cr.authentication.models.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationHandler {

    @Autowired
    private UserAuthenticationQuery userAuthenticationQuery;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateWithJwt(String username, String password) {
        AuthenticatedUser authenticated = authenticate(username, password);
        return jwtService.generateToken(authenticated);
    }

    private AuthenticatedUser authenticate(String username, String password) {
        var user = userAuthenticationQuery.loadUserByUsername(username);
        if (user == null)
            throw new BusinessException("User not provided");
        if (user.password() == null)
            throw new BusinessException("Password not provided");

        if (!passwordEncoder.matches(password, user.password()))
            throw new BusinessException("Invalid user");

        return user;
    }
}
