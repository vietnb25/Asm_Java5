package fplhn.vietnb25.sd17306.entities;

import fplhn.vietnb25.sd17306.request.ChiTietSanPhamVM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int namBaoHanh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    public void loadFromVM(ChiTietSanPhamVM vm)
    {
        this.setSanPham( vm.getSanPham() );
        this.setNhaSanXuat( vm.getNhaSanXuat() );
        this.setMauSac( vm.getMauSac() );
        this.setDongSP( vm.getDongSP() );
        this.setNamBaoHanh( vm.getNamBaoHanh() );
        this.setMoTa( vm.getMoTa() );
        this.setSoLuongTon( vm.getSoLuongTon() );
        this.setGiaNhap( vm.getGiaNhap() );
        this.setGiaBan( vm.getGiaBan() );

    }

}
