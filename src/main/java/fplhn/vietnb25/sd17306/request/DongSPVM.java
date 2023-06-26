package fplhn.vietnb25.sd17306.request;

import fplhn.vietnb25.sd17306.entities.DongSP;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DongSPVM {
    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    public void loadFromDomain(DongSP domainModel)
    {
        this.setTen( domainModel.getTen() );
        this.setMa( domainModel.getMa() );

    }
}
