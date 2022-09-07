package by.step.test;


import by.step.test.dao.entity.Human;
import by.step.test.service.impl.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/humans")
public class HumanController {

    @Autowired
    private HumanService humanService;

    @PostMapping
    public Human save(@RequestBody Human human){
        return  humanService.save(human);
    }

    @GetMapping
    public List<Human> findAll() {
        return humanService.findAll();
    }

}
