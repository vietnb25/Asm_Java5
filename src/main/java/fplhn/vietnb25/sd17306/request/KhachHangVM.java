package fplhn.vietnb25.sd17306.request;

import fplhn.vietnb25.sd17306.entities.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangVM {
    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    private String tenDem;

    @NotBlank(message = "Không được để trống")
    private String ho;

    @NotBlank(message = "Không được để trống")
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    private String ngaySinh;

    @NotBlank(message = "Không được để trống")
    private String sdt;

    @NotBlank(message = "Không được để trống")
    private String thanhPho;

    @NotBlank(message = "Không được để trống")
    private String matKhau;

    @NotBlank(message = "Không được để trống")
    private String quocGia;

    public void loadFromDomain(KhachHang domainModel)
    {
        this.setTen( domainModel.getTen() );
        this.setMa( domainModel.getMa() );
        this.setThanhPho( domainModel.getThanhPho() );
        this.setDiaChi( domainModel.getDiaChi() );
        this.setMatKhau( domainModel.getMatKhau() );
        String ngaySinhStr = String.valueOf(domainModel.getNgaySinh());
        this.setNgaySinh(ngaySinhStr);
        this.setTenDem( domainModel.getTenDem() );
        this.setHo( domainModel.getHo() );
        this.setQuocGia( domainModel.getQuocGia() );
        this.setSdt( domainModel.getSdt() );

    }
}
