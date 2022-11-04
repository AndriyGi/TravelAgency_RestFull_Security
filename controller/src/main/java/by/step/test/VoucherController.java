package by.step.test;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ExcVaucherNotFound;
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
    public VaucherDto findById(Long id) throws ExcVaucherNotFound {
        return vaucherService.findById(id);
    }

    @PutMapping("/attach_vauchers")
    @Operation(summary = "ДОБАВИТЬ путевки(несколько) к человеку"
            , description = "добавить путевку к человеку")
    public List<VaucherDto> attachVaucherssToHuman(@RequestParam Long humanId
            , @RequestParam Long vaucherId) throws ExcVaucherNotFound{
        List<VaucherDto> vaucherDtoList = vaucherService.attachVauchers_toHuman(humanId,vaucherId);
        return vaucherDtoList;
    }

    @GetMapping("/findallvauchersbyhumanid/{humanid}")
    @Operation(summary = "Найти ВСЕ путевки у 1 человека"
            , description = "ВСЕ путевки  человека")
    public List<VaucherDto> findAllByHuman_Id(@PathVariable("humanid") Long humanId) {
        List<VaucherDto> vaucherDtoList = vaucherService.findAllVauchersByHuman_Id(humanId);
        return vaucherDtoList;
    }

}
