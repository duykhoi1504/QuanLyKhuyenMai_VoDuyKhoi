/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

//import static QuanLy.SanPham.dem;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VoDuyKhoi
 */
public class KhuyenMaiC extends KhuyenMai {

    private static int dem = 0;
//    private int idC;
    private static final String maC = "C";
    private DanhMucSanPham loaiSanPhamGiam;
    private static final double tyLeGiamGia = 60;
    
    {
        maKM = String.format("C%04d", ++dem);
    }

    public KhuyenMaiC(String ngayTao, String ngayHetHieuLuc, DanhMucSanPham loaiSanPhamGiam) throws ParseException {
        super(ngayTao, ngayHetHieuLuc);
        this.loaiSanPhamGiam = loaiSanPhamGiam;
    }

    public KhuyenMaiC() {
    }

    @Override
    public void xuatKhuyenMai() {
        super.xuatKhuyenMai();
        System.out.println("Khuyen mai loai:" + this.maKM);
        System.out.print("Loai san Pham duoc giam:");
        this.loaiSanPhamGiam.xuatDanhMucSp();
        System.out.printf("ty le giam gia:%,.1f%s\n", this.tyLeGiamGia, "%");

    }

    @Override
    public void nhapKhuyenMai() throws ParseException {
        super.nhapKhuyenMai();
        DanhMucSanPham dmsp = new DanhMucSanPham();
        System.out.println("-nhap loai san pham duoc giam khi mua kem-");
        dmsp.nhapDanhMucSp();
        this.loaiSanPhamGiam = dmsp;

    }
/////////////////////////////////////////////////////////////////////////////////
    /**
     * @return the maC
     */
    public static String getMaC() {
        return maC;
    }

    /**
     * @return the loaiSanPhamGiam
     */
    public DanhMucSanPham getLoaiSanPhamGiam() {
        return loaiSanPhamGiam;
    }

    /**
     * @param loaiSanPhamGiam the loaiSanPhamGiam to set
     */
    public void setLoaiSanPhamGiam(DanhMucSanPham loaiSanPhamGiam) {
        this.loaiSanPhamGiam = loaiSanPhamGiam;
    }

    /**
     * @return the tyLeGiamGiam
     */
    public static double getTyLeGiamGia() {
        return tyLeGiamGia;
    }

}
