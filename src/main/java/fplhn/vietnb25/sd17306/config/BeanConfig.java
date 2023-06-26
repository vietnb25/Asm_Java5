package fplhn.vietnb25.sd17306.config;

import fplhn.vietnb25.sd17306.request.KhachHangVM;
import fplhn.vietnb25.sd17306.request.NhanVienVM;
import fplhn.vietnb25.sd17306.request.ChiTietSanPhamVM;
import fplhn.vietnb25.sd17306.request.ChucVuVM;
import fplhn.vietnb25.sd17306.request.CuaHangVM;
import fplhn.vietnb25.sd17306.request.DongSPVM;
import fplhn.vietnb25.sd17306.request.MauSacVM;
import fplhn.vietnb25.sd17306.request.NhaSanXuatVM;
import fplhn.vietnb25.sd17306.request.SanPhamVM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("cuaHangVM1")
    public CuaHangVM getCuaHangVM1()
    {
        CuaHangVM vm = new CuaHangVM();
        return vm;
    }

    @Bean("nhanVienVM")
    public NhanVienVM getNhanVienVM()
    {
        NhanVienVM vm = new NhanVienVM();
        return vm;
    }

    @Bean("chucVuVM")
    public ChucVuVM getChucVuVM()
    {
        ChucVuVM vm = new ChucVuVM();
        return vm;
    }

    @Bean("mauSacVM")
    public MauSacVM getMauSacVM()
    {
        MauSacVM vm = new MauSacVM();
        return vm;
    }

    @Bean("nsxVM")
    public NhaSanXuatVM getNSX()
    {
        NhaSanXuatVM vm = new NhaSanXuatVM();
        return vm;
    }

    @Bean("spVM")
    public SanPhamVM getSPVM()
    {
        SanPhamVM vm = new SanPhamVM();
        return vm;
    }

    @Bean("dspVM")
    public DongSPVM getDSPVM()
    {
        DongSPVM vm = new DongSPVM();
        return vm;
    }

    @Bean("khVM")
    public KhachHangVM getKHVM()
    {
        KhachHangVM vm = new KhachHangVM();
        return vm;
    }

    @Bean("ctspVM")
    public ChiTietSanPhamVM getChiTietSanPhamVM()
    {
        ChiTietSanPhamVM vm = new ChiTietSanPhamVM();
        return vm;
    }
//
//    @Bean("cvSV")
//    public ChucVuService getCVSV()
//    {
//        ChucVuService sv = new ChucVuService();
//        return sv;
//    }
}
