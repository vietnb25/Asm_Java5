//package fplhn.tiennh21.sd17306.service;
//
//import fplhn.tiennh21.sd17306.entities.ChucVu;
//import fplhn.tiennh21.sd17306.repositories.ChucVuRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//    @Service
//    public class ChucVuService {
//        @Autowired
//        private ChucVuRepository repo;
//
//        public List<ChucVu> listAll(String keyword, Pageable pageable) {
//            if (keyword != null) {
//                return repo.search(keyword, pageable);
//            }
//            return repo.findAll();
//        }
//    }
//
