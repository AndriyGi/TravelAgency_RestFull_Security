//package by.step.test.dao.repository.impl;
//
//import by.step.test.dao.entity.Vaucher;
//import by.step.test.dao.entity.VaucherType;
//import by.step.test.dao.repository.IVaucherRepository;
//import lombok.NoArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@NoArgsConstructor
//@Repository
//public class VaucherRepositoryImpl implements IVaucherRepository {
//
//
//    private List<Vaucher> vaucherList;
//    private Vaucher vaucher;
//
//
//    public VaucherRepositoryImpl(Vaucher vaucher) {
//        this.vaucherList = new ArrayList<>();
//        this.vaucher = vaucher;
////        vaucherList.add(new Vaucher(1L,VaucherType.REST, 1200.00, 21));
//    }
//
//    @Override
//    public List<Vaucher> findAllVauchers() {
//        return vaucherList;
//    }
//
//    @Override
//    public Vaucher findById(Long id) {
//        return vaucherList.stream().filter(vaucher -> vaucher.getId().equals(id)
////        {
////            if(vaucher.getId() == id){
////                return true;
////            }else {
////                return false;
////            }
////        }
//        ).findAny().get();
//    }
//
//    @Override
//    public Vaucher saveNewVaucher(Vaucher vaucher) {
//        boolean val = vaucherList.add(vaucher);
//        return vaucher;
//    }
//
//    @Override
//    public Vaucher deleteVaucher(Vaucher vaucher) {
//        boolean val = vaucherList.remove(vaucher);
//        if(val == true){
//            return vaucher;
//        }
//        return null;
//    }
//
//    @Override
//    public List<VaucherType> findAllVauchersByTupe() {
//        return null;
//    }
//
//    @Override
//    public VaucherType saveNewVaucherType(VaucherType vaucherType) {
//        return null;
//    }
//
//
////    @Override
////    public List<VaucherType> findAllVauchersByTupe() {
////        return vaucherTypesList;
////    }
//
////    @Override
////    public VaucherType saveNewVaucherType(VaucherType vaucherType) {
////        boolean val = vaucherTypesList.add(vaucherType);
////        if (val == true) {
////            return vaucherType;
////        } else {
////            return null;
////        }
////    }
//}
//
//
//
//