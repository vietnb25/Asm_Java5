package fplhn.vietnb25.sd17306.entities;

import fplhn.vietnb25.sd17306.request.NhanVienVM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;
@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NhanVien {
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

    @Column(name="gioiTinh")
    private String gioiTinh;

    @Column(name="ngaySinh")
    private Date ngaySinh;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="Sdt")
    private String sdt;

    @Column(name="MatKhau")
    private String matKhau;

    @Column(name="TrangThai")
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "IdCH")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;


    public void loadFromVM(NhanVienVM vm)
    {
        this.setTen( vm.getTen() );
        this.setMa( vm.getMa() );
        this.setGioiTinh( vm.getGioiTinh() );
        this.setDiaChi( vm.getDiaChi() );
        this.setMatKhau( vm.getMatKhau() );
        Date ngaySinhDate = Date.valueOf(vm.getNgaySinh());
        this.setNgaySinh(ngaySinhDate);
        this.setTenDem( vm.getTenDem() );
        this.setHo( vm.getHo() );
        this.setTrangThai( vm.getTrangThai() );
        this.setSdt( vm.getSdt() );
        this.setCuaHang(vm.getCuaHang());
        this.setChucVu(vm.getChucVu());
    }
}
