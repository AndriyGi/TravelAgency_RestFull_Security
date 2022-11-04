package by.step.test.security;

import by.step.test.dao.entity.Human;
import by.step.test.dao.repository.IHumanRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IHumanRepository humanRepository;
    @Override
    public UserDetails loadUserByUsername(String mail)
            throws UsernameNotFoundException {

        Human human = new Human();
        human = humanRepository.findByMail(mail)
                .orElseThrow( ()->new ServiceException("user not found by username(mail) "));

        return UserDetailsImpl.build(human);
    }
}
