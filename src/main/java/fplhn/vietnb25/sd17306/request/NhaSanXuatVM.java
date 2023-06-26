package fplhn.vietnb25.sd17306.request;

import fplhn.vietnb25.sd17306.entities.NhaSanXuat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NhaSanXuatVM {
    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    public void loadFromDomain(NhaSanXuat domainModel)
    {
        this.setTen( domainModel.getTen() );
        this.setMa( domainModel.getMa() );

    }
}
