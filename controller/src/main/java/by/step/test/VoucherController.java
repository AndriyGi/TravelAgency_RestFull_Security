package by.step.test;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ServiceException;
import by.step.test.mapper.HumanMapper;
import by.step.test.mapper.VaucherMapper;
import by.step.test.service.IVaucherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/vouchers")
@Tag(name = "Путевки", description = "для работы с путевками")
public class VoucherController {

    @Autowired
    private IVaucherService vaucherService;

    @Autowired
    private IVaucherRepository vaucherRepository;
    private IHumanRepository humanRepository;
    private Vaucher vaucher;
    private VaucherDto vaucherDto;
    private Human human;
    private HumanDto humanDto;
    private HumanMapper humanMapper;
    private VaucherMapper vaucherMapper;

    @PostMapping("/save")
    public Vaucher save(@RequestBody Vaucher vaucher) {
        return vaucherService.saveNewVaucher(vaucher);
    }

    @DeleteMapping("/delete")
    public Vaucher delete(@RequestBody Vaucher vaucher) {
        return vaucherService.deleteVaucher(vaucher);
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

    @PutMapping("/attach_vauchers")
    @Operation(summary = "ДОБАВИТЬ путевки(несколько) к человеку"
            , description = "добавить путевку к человеку")
    public VaucherDto attachVauchersToHuman(@RequestParam Long humanId, @RequestParam Long vaucherId) {
        VaucherDto vaucherDto = vaucherMapper.vaucherToVaucherDto(vaucherService
                .attachVauchers_toHuman(humanId, vaucherId));
        return vaucherDto;
    }

//    @GetMapping("/calcvaucherprice")
//    public double calculateVaucherPrice(Vaucher vaucher) {
//        return vaucher.getPriceOneDay() * vaucher.getDays();
//    }


//    @GetMapping("/buildvaucher")
//    public Vaucher buildVaucher(VaucherType type, int price, int days) {
//        Vaucher vaucherResult = vaucherService.findAllVauchers().stream()
//                .filter(vaucherType -> vaucherType.getVaucherType().equals(type))
//                .filter(vaucherPrice -> vaucherPrice.getPriceOneDay() == price)
//                .filter(vaucherDays -> vaucherDays.getDays() == days)
//                .findAny().orElseThrow(RuntimeException::new);
//        return vaucherResult;
//    }

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