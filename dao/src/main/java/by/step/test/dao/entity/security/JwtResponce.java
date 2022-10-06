package by.step.test.dao.entity.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JwtResponce {

    private Long id;
    private String token;
    private String type = "Baerer";
    private List<String> roleList;

    public JwtResponce(Long id, String token, List<String> roleList) {
        this.id = id;
        this.token = token;
        this.roleList = roleList;
    }
}
