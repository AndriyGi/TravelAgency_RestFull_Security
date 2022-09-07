package by.step.test;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.service.impl.VaucherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VaucherServiceImpl vaucherService;

    @PostMapping
    public Vaucher save(@RequestBody Vaucher vaucher){
        return vaucherService.saveNewVaucher(vaucher);
    }

    @GetMapping
    public List<Vaucher> findAll(){
        return vaucherService.findAllVauchers();
    }
}
