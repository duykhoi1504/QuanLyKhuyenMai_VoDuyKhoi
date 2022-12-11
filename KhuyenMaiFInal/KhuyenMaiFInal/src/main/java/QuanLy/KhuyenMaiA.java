/*
3 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

//import static QuanLy.SanPham.dem;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author VoDuyKhoi
 */
public class KhuyenMaiA extends KhuyenMai {
    private static int dem = 0;
    private static final String maA = "A";
    private static final double tyLeGiamGia = 20;
    {

        maKM=String.format("A%02d",++dem);
    }
    public KhuyenMaiA(String ngayTao, String ngayHetHieuLuc) throws ParseException {
        super(ngayTao, ngayHetHieuLuc);
    }

    public KhuyenMaiA() {
    }
    

    @Override
    public void xuatKhuyenMai() {
        super.xuatKhuyenMai();
        System.out.println("ma khuyen mai loai:"+ this.maKM);
        System.out.printf("ty le giam gia:%.1f%s\n", tyLeGiamGia,"%");
    }

}
