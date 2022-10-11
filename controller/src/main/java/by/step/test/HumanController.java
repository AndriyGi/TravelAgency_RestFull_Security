package by.step.test;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import by.step.test.excemption.ControllerExcemtion;
import by.step.test.exception.ExcEmptyHumansList;
import by.step.test.exception.ExcHumanIsPresent;
import by.step.test.exception.ExcVaucherNotFound;
import by.step.test.exception.ExcHumanNotFound;
import by.step.test.service.IHumanService;
import by.step.test.service.IVaucherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public HumanDto save(@RequestBody Human human) throws ControllerExcemtion
           {
        try {
            HumanDto humanDto = humanService.save(human);
            return humanDto;
        } catch (ExcHumanIsPresent humanIsPresent) {
            throw new ControllerExcemtion(humanIsPresent.getMessage(), humanIsPresent);
        }
    }

    @GetMapping("find_all")
    @PreAuthorize("hasAnyRole('ADMIN','USER','GUEST')")
    @Operation(summary = "Найти всех людей", description = "All clients of Agency")
    public List<HumanDto> findAll() throws ExcEmptyHumansList, ControllerExcemtion {
        try{

            List<HumanDto> humanDtoList = humanService.findAll();
            return humanDtoList;
        }catch (ExcEmptyHumansList excEmptyHumansList){
            throw new ControllerExcemtion(excEmptyHumansList.getMessage(),excEmptyHumansList);
        }
    }

    @GetMapping("/{humanId}")
    @Operation(summary = "Найти по АйДи", description = "All clients of Agency")
    @PreAuthorize("hasAnyRole('ADMIN','USER','GUEST')")
    public HumanDto findById(@PathVariable("humanId") Long id) throws ExcHumanNotFound {
        return humanService.findById(id);
    }
    @DeleteMapping("/{humanId}")
    @Operation(summary = "УДАЛИТЬ человека по АйДи", description = "УДАЛЯЕМ человека")
    public Long delete(@PathVariable("humanId") Long id) {
        humanService.delete(id);
        return id;
    }



    @GetMapping("/findallhumansbyvaucherid/{vaucherid}")
    @Operation(summary = "Найти ВСЕХ ЛЮДЕЙ по АйДи путевки"
            , description = "Найти ВСЕХ Л по АйДи П")
    public List<HumanDto> findAllHumansByVaucher_Id(@PathVariable("vaucherid") Long vaucherId)
            throws ExcVaucherNotFound {
        return humanService.findAllHumansByVaucher_Id(vaucherId);
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
