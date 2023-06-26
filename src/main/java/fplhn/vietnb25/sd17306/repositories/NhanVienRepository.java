package fplhn.vietnb25.sd17306.repositories;

import fplhn.vietnb25.sd17306.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query(value = "select Ma from NhanVien nv order by len(nv.Ma) desc, nv.Ma desc offset 0 row fetch next 1 row only", nativeQuery = true)
    String getBiggestMa();
}
