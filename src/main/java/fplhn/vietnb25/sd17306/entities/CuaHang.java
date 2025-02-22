package fplhn.vietnb25.sd17306.entities;

import fplhn.vietnb25.sd17306.request.CuaHangVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="ThanhPho")
    private String thanhPho;

    @Column(name="QuocGia")
    private String quocGia;

    public void loadFromVM(CuaHangVM vm)
    {
        this.setTen( vm.getTen() );
        this.setMa( vm.getMa() );
        this.setThanhPho( vm.getThanhPho() );
        this.setDiaChi( vm.getDiaChi() );
        this.setQuocGia( vm.getQuocGia() );
    }
}
