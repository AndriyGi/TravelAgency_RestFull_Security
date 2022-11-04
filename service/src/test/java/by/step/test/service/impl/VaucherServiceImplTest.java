package by.step.test.service.impl;

import by.step.test.converterdto.HumanConverter;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.mapper.HumanMapper;
import by.step.test.mapper.VaucherMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class VaucherServiceImplTest {
    @Mock
    private Vaucher vaucher;
    @Mock
    private HumanConverter humanConverter;
    @Mock
    private IVaucherRepository vaucherRepository;
    @Mock
    private VaucherMapper vaucherMapper;
    @Mock
    private HumanMapper humanMapper;
    @Mock
    private IHumanRepository humanRepository;
    @InjectMocks
    private VaucherServiceImpl vaucherServiceImpl;
    @InjectMocks
    private HumanServiceImpl humanServiceImpl;


    @Test
    @DisplayName("test VAUCHER")
    public void calculatedVaucherPrice(){
        Vaucher vaucher = new Vaucher();
        vaucher.setPriceOneDay(12.00);
        vaucher.setDays(5);
        assertEquals(60.00,
                vaucherServiceImpl.calculatedVaucherPrice(vaucher));

    }


}