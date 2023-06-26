package fplhn.vietnb25.sd17306.request;

import fplhn.vietnb25.sd17306.entities.ChucVu;
import fplhn.vietnb25.sd17306.entities.CuaHang;
import fplhn.vietnb25.sd17306.entities.NhanVien;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienVM {
    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    @NotBlank(message = "Không được để trống")
    private String tenDem;

    @NotBlank(message = "Không được để trống")
    private String ho;

    @NotBlank(message = "Không được để trống")
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    private String gioiTinh;

    @NotBlank(message = "Không được để trống")
    private String ngaySinh;

    @NotBlank(message = "Không được để trống")
    private String sdt;

    @NotBlank(message = "Không được để trống")
    private String matKhau;

    @NotBlank(message = "Không được để trống")
    private String trangThai;

    private CuaHang cuaHang;

    private ChucVu chucVu;



    public void loadFromDomain(NhanVien domainModel)
    {
        this.setTen( domainModel.getTen() );
        this.setMa( domainModel.getMa() );
        this.setGioiTinh( domainModel.getGioiTinh() );
        this.setDiaChi( domainModel.getDiaChi() );
        this.setMatKhau( domainModel.getMatKhau() );
        String ngaySinhStr = String.valueOf(domainModel.getNgaySinh());
        this.setNgaySinh(ngaySinhStr);
        this.setTenDem( domainModel.getTenDem() );
        this.setHo( domainModel.getHo() );
        this.setTrangThai( domainModel.getTrangThai() );
        this.setSdt( domainModel.getSdt() );
        this.setCuaHang(domainModel.getCuaHang());
        this.setChucVu(domainModel.getChucVu());
    }


}
