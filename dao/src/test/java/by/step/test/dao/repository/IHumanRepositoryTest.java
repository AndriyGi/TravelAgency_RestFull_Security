//package by.step.test.dao.repository;
//
//import by.step.test.dao.entity.Human;
//import by.step.test.dao.entity.Vaucher;
//import org.junit.jupiter.api.Test;
//import org.springframework.data.jpa.repository.Query;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class IHumanRepositoryTest {
//    Human human;
//    IHumanRepository iHumanRepository;
//
//
//    @Test
//    void attachVauchers_toHuman() {
//        Vaucher vaucher;
//        Human human = iHumanRepository.attachVauchers_toHuman(1L, 2L);
//        assertEquals(human.getId() == 1L, vaucher.getId() == 2L);
//    }
//}