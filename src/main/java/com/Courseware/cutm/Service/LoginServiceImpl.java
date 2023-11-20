package com.Courseware.cutm.Service;

import com.Courseware.cutm.ExceptionHandling.ResourceNotFoundException;
import com.Courseware.cutm.model.Login;
import com.Courseware.cutm.repository.LoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login saveLogin(Login login) {
        return (Login)this.loginRepository.save(login);
    }

    public List<Login> getAllLoginDetail() {
        return this.loginRepository.findAll();
    }

    public Login getLoginDetailById(long id) {
        return (Login)this.loginRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("LoginCourseware", "id", id);
        });
    }
    public Login updateLoginDetails(Login loginCourseware, long id) {
        Login existingLogin = (Login)this.loginRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("LoginCourseware", "id", id);
        });
        existingLogin.setFirstname(loginCourseware.getFirstname());
        existingLogin.setLastname(loginCourseware.getLastname());
        existingLogin.setEmail(loginCourseware.getEmail());
        existingLogin.setPassword(loginCourseware.getPassword());
        this.loginRepository.save(existingLogin);
        return existingLogin;
    }

    public Login deleteLoginDetails(Login login, long id) {
        if (!this.loginRepository.existsById(id)) {
            throw new ResourceNotFoundException("LoginCourseware", "id", id);
        } else {
            this.loginRepository.deleteById(id);
            return (Login)this.loginRepository.save(login);
        }
    }
}
