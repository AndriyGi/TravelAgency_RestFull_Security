package by.step.test;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ServiceException;
import by.step.test.mapper.HumanMapper;
import by.step.test.mapper.VaucherMapper;
import by.step.test.service.IVaucherService;
import by.step.test.service.impl.VaucherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private IHumanRepository humanRepository;

    private Human human;
    private Vaucher vaucher;
    @Autowired
    private VaucherDto vaucherDto;

    @Autowired
    private HumanDto humanDto;
    @Autowired
    private HumanMapper humanMapper;
    @Autowired
    private VaucherMapper vaucherMapper;
    @Autowired
    private VaucherServiceImpl vaucherServiceImpl;


    @PostMapping("/save")
    public VaucherDto save(@RequestBody Vaucher vaucher) {
        return vaucherService.saveNewVaucher(vaucher);
    }

    @DeleteMapping("/delete/{vaucherid}")
    public void delete(@PathVariable("vaucherid") Long vaucherId) {
        vaucherServiceImpl.deleteById(vaucherId);
    }

    @GetMapping("/allvauchers")
    public List<VaucherDto> getAllVauchers() {
      return vaucherService.findAllVauchers();
    }

    @GetMapping("/findbyid")
    public VaucherDto findById(Long id) {
        VaucherDto vaucherDto = new VaucherDto();
        try {
            vaucherDto = vaucherService.findById(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return vaucherDto;
    }
//    @PutMapping("/attach_vauchers")
//    @Operation(summary = "ДОБАВИТЬ путевки(несколько) к человеку"
//            , description = "добавить путевку к человеку")
//    public VaucherDto attachVaucherssToHuman(@RequestParam Long humanId
//            , @RequestParam Long vaucherId) {
//        VaucherDto vaucherDto = vaucherMapper.vaucherToVaucherDto(iVaucherService
//                .attachVauchers_toHuman(humanId, vaucherId));
//        return vaucherDto;
//    }

    @GetMapping("/findallvauchersbyhumanid/{humanid}")
    @Operation(summary = "Найти ВСЕ путевки у 1 человека"
            , description = "ВСЕ путевки  человека")
    public List<VaucherDto> findAllByHuman_Id(@PathVariable("humanid") Long humanId){
        List<VaucherDto> vaucherDtoList = vaucherService.findAllVauchersByHuman_Id(humanId);
        return  vaucherDtoList;
    }


//    @PutMapping("/attach_vauchers")
//    @Operation(summary = "ДОБАВИТЬ путевки(несколько) к человеку"
//            , description = "добавить путевку к человеку")
//    public Integer attachVauchersToHuman(@RequestParam Long humanId, @RequestParam Long vaucherId) {
//        Integer integer = vaucherRepository.attachVaucherss_toHuman(humanId, vaucherId);
//        return integer;
//    }
//
//    @PutMapping("/attach_vauchers")
//    @Operation(summary = "ДОБАВИТЬ путевки(несколько) к человеку"
//            , description = "добавить путевку к человеку")
//    public VaucherDto attachVauchersToHuman(@RequestParam Long humanId, @RequestParam Long vaucherId) {
//        return vaucherMapper.vaucherToVaucherDto(
//                vaucherServiceImpl.attachVauchers_toHuman(humanId, vaucherId)
//        );
//    }




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