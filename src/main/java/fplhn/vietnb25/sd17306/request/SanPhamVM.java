package fplhn.vietnb25.sd17306.request;

import fplhn.vietnb25.sd17306.entities.SanPham;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SanPhamVM {

    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    public void loadFromDomain(SanPham domainModel)
    {
        this.setTen( domainModel.getTen() );
        this.setMa( domainModel.getMa() );

    }
}
