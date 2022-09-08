package by.step.test;


import by.step.test.dao.entity.Human;
import by.step.test.service.IHumanService;
import by.step.test.service.impl.HumanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/humans")
@Tag(name="люди", description = "для работы с людьми")
public class HumanController {

    private IHumanService iHumanService;

    public HumanController(IHumanService iHumanService, HumanService humanService) {
        this.iHumanService = iHumanService;
        this.humanService = humanService;
    }



    @Autowired
    private HumanService humanService;

    @PostMapping
    @Operation(summary="сохранить человека", description = "Добавляем человека")
    public Human save(@RequestBody Human human){
        return  humanService.save(human);
    }

    @GetMapping
    @Operation(summary = "Найти всех людей" ,description = "All clients of Agency")
    public List<Human> findAll() {
        return humanService.findAll();
    }

    @GetMapping("deliteHuman")
    public Human delite(@RequestBody Human human){
        return humanService.delite(human);
    }
}
