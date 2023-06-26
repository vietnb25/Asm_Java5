package fplhn.vietnb25.sd17306.entities;

import fplhn.vietnb25.sd17306.request.DongSPVM;
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

import java.util.UUID;

@Entity
@Table(name = "DongSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="ma")
    private String ma;

    @Column(name="ten")
    private String ten;

    public void loadFromVM(DongSPVM vm)
    {
        this.setTen( vm.getTen() );
        this.setMa( "DSP" + vm.getMa() );
    }
}
