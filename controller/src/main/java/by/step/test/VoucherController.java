package by.step.test;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.exception.ServiceException;
import by.step.test.service.IVaucherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/vouchers")
@Tag(name = "Путевки", description = "для работы с путевками")
public class VoucherController {

    @Autowired
    private IVaucherService vaucherService;

    @PostMapping("/save")
    public Vaucher save(@RequestBody Vaucher vaucher) {
        return vaucherService.saveNewVaucher(vaucher);
    }

    @DeleteMapping("/delete")
    public Vaucher delete(@RequestBody Vaucher vaucher) {
        return vaucherService.deleteVaucher(vaucher);
    }

    @GetMapping("/calcvaucherprice")
    public double calculateVaucherPrice(Vaucher vaucher) {
        return vaucher.getPriceOneDay() * vaucher.getDays();
    }


    @GetMapping("/allvauchers")
    public List<Vaucher> getAllVauchers() {
        return vaucherService.findAllVauchers();
    }

    @GetMapping("/findbyid")
    public Vaucher findById(Long id) {
        Vaucher vaucher = new Vaucher();
        try {
            vaucher = vaucherService.findById(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return vaucher;
    }

    @GetMapping("/buildvaucher")
    public Vaucher buildVaucher(VaucherType type, int price, int days) {
        Vaucher vaucherResult = vaucherService.findAllVauchers().stream()
                .filter(vaucherType -> vaucherType.getVaucherType().equals(type))
                .filter(vaucherPrice -> vaucherPrice.getPriceOneDay() == price)
                .filter(vaucherDays -> vaucherDays.getDays() == days)
                .findAny().orElseThrow(RuntimeException::new);
        return vaucherResult;
    }

//    @PostMapping("/savetype")
//    public VaucherType saveNewVaucherType(@RequestBody VaucherType vaucherType) {
////        return vaucherRepository.saveNewVaucherType(vaucherType);
//        return vaucherService.saveNewVaucherType(vaucherType);
//    }
//
//    @GetMapping("/findallbytype")
//    List<VaucherType> findAllByVaucherType(VaucherType vaucherType) throws ServiceException {
//        List<VaucherType> vaucherType1 = new ArrayList<>();
//        try {
//            vaucherType1 = (List<VaucherType>) vaucherService.findAllByVaucherType(vaucherType);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        return vaucherType1;
//
//
//    }
}
//        return vaucherService.findAllByVaucherType(vaucherType);