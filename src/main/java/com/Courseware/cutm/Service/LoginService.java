package com.Courseware.cutm.Service;

import com.Courseware.cutm.model.Login;

import java.util.List;

public interface LoginService {
    Login saveLogin(Login login);

    List<Login> getAllLoginDetail();

    Login getLoginDetailById(long id);

    Login updateLoginDetails(Login login, long id);

    Login deleteLoginDetails(Login login, long id);
}
