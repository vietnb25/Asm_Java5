package fplhn.vietnb25.sd17306.repositories;

import fplhn.vietnb25.sd17306.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepo extends JpaRepository<SanPham, UUID> {
}
