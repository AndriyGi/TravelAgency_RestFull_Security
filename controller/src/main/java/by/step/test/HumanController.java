package by.step.test;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ServiceException;
import by.step.test.service.IHumanService;
import by.step.test.service.IVaucherService;
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
    private final IHumanService humanService;
    @Autowired
    private IVaucherService vaucherService;

    public HumanController(IHumanService humanService) {
        this.humanService = humanService;
    }

    @PostMapping
    @Operation(summary = "сохранить человека", description = "Добавляем человека")
    public HumanDto save(@RequestBody Human human) {
        return humanService.save(human);
    }

    @DeleteMapping("/{humanId}")
    @Operation(summary = "УДАЛИТЬ человека по АйДи", description = "УДАЛЯЕМ человека")
    public void delete(@PathVariable("humanId") Long id) {
        humanService.delete(id);
    }

    @GetMapping("find_all")
    @Operation(summary = "Найти всех людей", description = "All clients of Agency")
    public List<HumanDto> findAll() {
        return humanService.findAll();
    }

    @GetMapping("/{humanId}")
    @Operation(summary = "Найти по АйДи", description = "All clients of Agency")
    public HumanDto findById(@PathVariable("humanId") Long id) throws ServiceException {
        return humanService.findById(id);
    }

//    @GetMapping("/findhumanbyvaucherid/{vaucherid}")
//    @Operation(summary = "Найти человека по путевке ID"
//            , description = "Найти человека по путевке ID")
//    public HumanDto findHumanByVaucher_Id(@PathVariable("vaucherid") Long vaucherId){
//        return humanService.findHumanByVaucherId(vaucherId);
//    }


//    @GetMapping("/filter")
//    public List<Human> findAllByName(@RequestParam("name") String name) {
//        return humanService.findAllByName(name);
//    }

//    @GetMapping("/surnameage")
//    @Operation(summary = "пнайти по имени и возрасту", description = "ВСЕ по возрасту и фамилии")
//    public List<Human> findAllBySurnameAndAge(@RequestParam String surname, @RequestParam Integer age) {
//        return humanService.findAllBySurnameAndAge(surname, age);
//    }

}
