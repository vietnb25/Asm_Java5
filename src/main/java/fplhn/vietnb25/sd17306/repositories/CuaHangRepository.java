package fplhn.vietnb25.sd17306.repositories;


import fplhn.vietnb25.sd17306.entities.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Query("SELECT ch from CuaHang ch WHERE ch.ten = ?1")
    public List<CuaHang> findByTen(String ten);
}
