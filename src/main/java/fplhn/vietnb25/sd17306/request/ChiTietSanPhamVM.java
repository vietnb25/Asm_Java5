package fplhn.vietnb25.sd17306.request;

import fplhn.vietnb25.sd17306.entities.ChiTietSanPham;
import fplhn.vietnb25.sd17306.entities.SanPham;
import fplhn.vietnb25.sd17306.entities.DongSP;
import fplhn.vietnb25.sd17306.entities.MauSac;
import fplhn.vietnb25.sd17306.entities.NhaSanXuat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSanPhamVM {

    private SanPham sanPham;

    private NhaSanXuat nhaSanXuat;

    private MauSac mauSac;

    private DongSP dongSP;

    private int namBaoHanh;

    @NotBlank
    private String moTa;

    private int soLuongTon;

    private BigDecimal giaNhap;

    private BigDecimal giaBan;

    public void loadFromDomain(ChiTietSanPham domainModel) {
        this.setSanPham(domainModel.getSanPham());
        this.setNhaSanXuat(domainModel.getNhaSanXuat());
        this.setMauSac(domainModel.getMauSac());
        this.setDongSP(domainModel.getDongSP());
        this.setNamBaoHanh(domainModel.getNamBaoHanh());
        this.setMoTa(domainModel.getMoTa());
        this.setSoLuongTon(domainModel.getSoLuongTon());
        this.setGiaNhap(domainModel.getGiaNhap());
        this.setGiaBan(domainModel.getGiaBan());
    }
}
