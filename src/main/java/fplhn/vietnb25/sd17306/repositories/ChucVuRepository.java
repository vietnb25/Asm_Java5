package fplhn.vietnb25.sd17306.repositories;

import fplhn.vietnb25.sd17306.entities.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    @Query("SELECT cv from ChucVu cv WHERE cv.ten like %:keyword%")
    Page<ChucVu> search(String keyword, Pageable pageable);
}
