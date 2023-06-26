package fplhn.vietnb25.sd17306.repositories;

import fplhn.vietnb25.sd17306.entities.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CtspRepository extends JpaRepository<ChiTietSanPham, UUID> {
    @Query("SELECT ctsp from ChiTietSanPham ctsp WHERE ctsp.sanPham.ten like ?1")
    Page<ChiTietSanPham> findByName(String keyword, Pageable pageable);
}
