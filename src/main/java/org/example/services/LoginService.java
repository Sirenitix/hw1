package org.example.services;

import org.apache.log4j.Logger;
import org.example.entity.LoginForm;
import org.example.entity.RegisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final Logger logger = Logger.getLogger(LoginService.class);
    private final RegisService regisService;

    @Autowired
    public LoginService(RegisService regisService) {
        this.regisService = regisService;
    }

    public boolean authenticate(LoginForm loginFrom) {
        Boolean boolvalue = false;
        logger.info("try auth with user-form: " + loginFrom);
        if (loginFrom.getUsername().equals("root") && loginFrom.getPassword().equals("123")) {
            boolvalue = true;
        }

        for (RegisForm users : regisService.getAllUsers()) {
            if (users.getUsername_reg().equals(loginFrom.getUsername()) && users.getPassword_first().equals(loginFrom.getPassword())) {
                boolvalue = true;
            }
        }
        return boolvalue;
    }

}
