package by.step.test;


import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import by.step.test.service.IHumanService;
import by.step.test.service.impl.HumanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/humans")
@Tag(name = "люди", description = "для работы с людьми")
public class HumanController {

    @Autowired
    private IHumanService humanService;

    public HumanController(IHumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping
    @Operation(summary = "Найти всех людей", description = "All clients of Agency")
    public List<Human> findAll() {
        return humanService.findAll();
    }

    @GetMapping("/{humanId}")
    @Operation(summary = "Найти по АйДи", description = "All clients of Agency")
    public HumanDto findById(@PathVariable("humanId") Long id) {
        return humanService.findById(id);
    }

    @PostMapping
    @Operation(summary = "сохранить человека", description = "Добавляем человека")
    public Human save(@RequestBody Human human) {
        return humanService.save(human);
    }

    @DeleteMapping("/{humanId}")
    public void delete(@PathVariable("humanId") Long id) {
        humanService.delete(id);
    }

    @PutMapping("/attach_vauchers")
    @Operation(summary = "добавить путевки(несколько) к человеку", description = "добавить путевку к человеку")
    public Human attachVauchersToHuman(@RequestParam Long humanId,@RequestParam Long vaucherId){
        return humanService.attachVauchers_ToHuman(humanId, vaucherId);
    }

//    @GetMapping("/filter")
//    public List<Human> findAllByName(@RequestParam("name") String name) {
//        return humanService.findAllByName(name);
//    }

//    @GetMapping("/surnameage")
//    @Operation(summary = "пнайти по имени и возрасту", description = "ВСЕ по возрасту и фамилии")
//    public List<Human> findAllBySurnameAndAge(@RequestParam String surname, @RequestParam Integer age) {
//        return humanService.findAllBySurnameAndAge(surname, age);
//    }

//    @PutMapping("/attach_vaucher")
//    @Operation(summary = "добавить путевку к человеку", description = "добавить путевку к человеку")
//    public Human attachVaucherToHuman(@RequestParam Long humanId,@RequestParam Long vaucherId){
//        return humanService.attachVaucherToHuman(humanId, vaucherId);
//    }



}
