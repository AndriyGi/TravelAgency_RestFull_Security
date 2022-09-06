package by.step.test;


import by.step.test.dao.entity.Human;
import by.step.test.service.AbstractHumanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/step")
public class HumanController {
//    private AbstractHumanService abstractHumanService;
//
//    public HumanController(AbstractHumanService abstractHumanService) {
//        this.abstractHumanService = abstractHumanService;
//    }

    @GetMapping
    String name (@RequestParam String name){
        return name + " Pupkin";
    }

    @GetMapping("/{name}")
    String nameVar (@PathVariable String name){
        return name + " Pupkin";
    }
//    @GetMapping("/humans/human")
//    Human getHuman (){
//        return abstractHumanService.getHumanObject();
//    }
}
