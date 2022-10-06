package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Role;
import by.step.test.dao.entity.security.ERole;
import by.step.test.dao.entity.security.JwtResponce;
import by.step.test.dao.entity.security.LoginRequest;
import by.step.test.dao.entity.security.SignUpRequest;
import by.step.test.service.AuthService;
import by.step.test.service.IHumanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final IHumanService humanService;

    public AuthServiceImpl(IHumanService humanService) {
        this.humanService = humanService;
    }

    @Override
    public Human registration(SignUpRequest signUpRequest) {
        if (signUpRequest.getMail() != null && !humanService.existByEmail(signUpRequest.getMail())) {
            Human human = new Human(signUpRequest.getVaucherList(), signUpRequest.getId()
                    , signUpRequest.getName()
                    , signUpRequest.getSurname(), signUpRequest.getAge(), signUpRequest.getMail()
                    , signUpRequest.getPass(), null);
            List<String> signUpListRoles = signUpRequest.getRoleList();
            List<Role> roleList = new ArrayList<>();
            if (signUpListRoles == null){
                roleList.add(ERole.ROLE_GUEST.name())
                        //todo create Service & Repository for Roles Entities
            }else{
                for (String r  :  signUpListRoles
                     ) {
                    switch (r){
                        case "ADMIN": roleList.add(ERole.ROLE_GUEST.name())
                    }
                }
            }
        }
        return null;
    }

    @Override
    public JwtResponce authentication(LoginRequest loginRequest) {
        return null;
    }
}
