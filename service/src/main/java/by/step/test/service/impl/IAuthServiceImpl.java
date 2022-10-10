package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Role;
import by.step.test.dao.entity.security.ERole;
import by.step.test.dao.entity.security.JwtResponce;
import by.step.test.dao.entity.security.LoginRequest;
import by.step.test.dao.entity.security.SignUpRequest;
import by.step.test.exception.ExcHumanIsPresent;
import by.step.test.exception.ExcHumanNotFound;
import by.step.test.security.UserDetailsImpl;
import by.step.test.security.utill.JwtUtill;
import by.step.test.service.IAuthService;
import by.step.test.service.IHumanService;
import by.step.test.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@Slf4j
public class IAuthServiceImpl implements IAuthService {

    private final JwtUtill jwtUtill;
    private final AuthenticationManager authenticationManager;
    private final IHumanService humanService;
    private final IRoleService roleService;

    public IAuthServiceImpl(JwtUtill jwtUtill,
                            AuthenticationManager authenticationManager,
                            IHumanService humanService,
                            IRoleService roleService) {
        this.jwtUtill = jwtUtill;
        this.authenticationManager = authenticationManager;
        this.humanService = humanService;
        this.roleService = roleService;
    }

    @Override
    public Human registration(SignUpRequest signUpRequest) throws ExcHumanNotFound, ExcHumanIsPresent {
        if (signUpRequest.getMail() != null && !humanService.existByEmail(signUpRequest.getMail())) {
            Human human = new Human(signUpRequest.getVaucherList(), null
                    , signUpRequest.getId(), signUpRequest.getName()
                    , signUpRequest.getSurname(), signUpRequest.getAge()
                    , signUpRequest.getMail(), signUpRequest.getPass());
            List<String> signUpListRoles = signUpRequest.getRoleList();
            List<Role> roleList = new ArrayList<>();
            if (signUpListRoles == null) {
                String roleName = ERole.ROLE_GUEST.name();
//                String roleName = "ROLE_GUEST";     //  -- same
                Role role = roleService.findByName(roleName);
                roleList.add(role);
                //todo create Service & Repository for Roles Entities
            } else {
                for (String r : signUpListRoles
                ) {
                    switch (r) {
                        case "ADMIN":
                            String adminName = ERole.ROLE_ADMIN.name();
//                          String roleName = "ROLE_ADMIN";     //  -- same
                            Role roleAdmin = roleService.findByName(adminName);
                            roleList.add(roleAdmin);
                            break;
                        case "USER":
                            String userName = ERole.ROLE_USER.name();
//                          String roleName = "ROLE_USER";     //  -- same
                            Role roleUser = roleService.findByName(userName);
                            roleList.add(roleUser);
                            break;
                        default:
                            String userGuest = ERole.ROLE_GUEST.name();
//                           String roleName = "ROLE_GUEST";     //  -- same
                            Role roleGuest = roleService.findByName(userGuest);
                            roleList.add(roleGuest);
                    }
                }
            }
            human.setRoleList(roleList);
            humanService.save(human);
            return human;
        }

        throw new ExcHumanIsPresent(" no MAIL  input " +

                "?????????????????" +

                "OR Human is  ALEADY  exist ! ");
    }

    @Override
    public JwtResponce authentication(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getMail()
                        , loginRequest.getPass())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtill.generateJwtToken(authentication);

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roleList = userDetailsImpl
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return new JwtResponce(userDetailsImpl.getId(), jwtToken, roleList);
    }
}
