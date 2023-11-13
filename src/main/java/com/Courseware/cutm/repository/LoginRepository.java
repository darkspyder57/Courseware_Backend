package com.Courseware.cutm.repository;

import com.Courseware.cutm.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
}
