package by.step.test;

import by.step.test.dao.entity.Vaucher;
import by.step.test.service.IVaucherService;
import by.step.test.service.impl.VaucherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private IVaucherService vaucherService;

    @PostMapping("/save")
    public Vaucher save(@RequestBody Vaucher vaucher) {
        return vaucherService.saveNewVaucher(vaucher);
    }

    @DeleteMapping("/delete")
    public Vaucher delete(@RequestBody Vaucher vaucher){
        return vaucherService.deleteVaucher(vaucher);
    }

//    @GetMapping
//    public List<Vaucher> getAllVauchers(){
//        return  vaucherService.findAllVauchers();
//    }

//    @GetMapping("/voucher")
//    public List<Vaucher> getAllVauchers() {
//        return v;
//    }


//    @GetMapping
//    public List<VaucherType> findAllVauchersTypes(){
//        return vaucherService.findAllVaucherTypes();
//    }
//


//
//    @GetMapping
//    public List<Vaucher> findAllVauchers(){
//        return vaucherService.findAllVauchers();
//    }


}
