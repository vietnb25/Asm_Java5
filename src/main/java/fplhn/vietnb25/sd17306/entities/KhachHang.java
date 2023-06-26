package fplhn.vietnb25.sd17306.entities;

import fplhn.vietnb25.sd17306.request.KhachHangVM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    @Column(name="TenDem")
    private String tenDem;

    @Column(name="Ho")
    private String ho;

    @Column(name="ngaySinh")
    private Date ngaySinh;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="Sdt")
    private String sdt;

    @Column(name="thanhPho")
    private String thanhPho;

    @Column(name="MatKhau")
    private String matKhau;

    @Column(name="quocGia")
    private String quocGia;

    public void loadFromVM(KhachHangVM vm)
    {
        this.setTen( vm.getTen() );
        this.setMa("KH" + vm.getMa() );
        this.setDiaChi( vm.getDiaChi() );
        Date ngaySinhDate = Date.valueOf(vm.getNgaySinh());
        this.setNgaySinh(ngaySinhDate);
        this.setTenDem( vm.getTenDem() );
        this.setHo( vm.getHo() );
        this.setMatKhau( vm.getMatKhau() );
        this.setSdt( vm.getSdt() );
        this.setThanhPho(vm.getThanhPho());
        this.setQuocGia(vm.getQuocGia());
    }


}
