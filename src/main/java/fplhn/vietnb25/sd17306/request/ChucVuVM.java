package fplhn.vietnb25.sd17306.request;

import fplhn.vietnb25.sd17306.entities.ChucVu;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ChucVuVM {
    @NotBlank(message = "Không được để trống")
    @Length(max = 6, message = "Không nhập quá 6 số")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    public void loadFromDomain(ChucVu domainModel)
    {
        this.setTen( domainModel.getTen() );
        this.setMa(  domainModel.getMa() );

    }
}
