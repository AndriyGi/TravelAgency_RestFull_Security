package by.step.test.security;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Role;
import by.step.test.dao.entity.Vaucher;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private List<Vaucher> vaucherList;
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String mail;
    private String pass;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(List<Role> roleList, Long id) {
    }

    public static UserDetailsImpl build(Human human) {
        List<GrantedAuthority> authorityList = human.getRoleList()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        UserDetailsImpl userDetails = new UserDetailsImpl(human.getVaucherList(), human.getId(), human.getName()
                , human.getSurname()
                , human.getAge(), human.getMail(), human.getPass(), authorityList);
        return userDetails;
    }

    public List<Vaucher> getVaucherList() {
        return vaucherList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
