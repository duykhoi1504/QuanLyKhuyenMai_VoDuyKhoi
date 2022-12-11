/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.khuyenmai;

import QuanLy.CauHinh;
import QuanLy.DanhMucSanPham;
import QuanLy.DichVuTangKem;
import QuanLy.KhuyenMai;
import QuanLy.KhuyenMaiA;
import QuanLy.KhuyenMaiB;
import QuanLy.KhuyenMaiC;
import QuanLy.QuanLySanPham;
import QuanLy.SanPham;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author VoDuyKhoi
 */
public class QLKM {

    public static void main(String[] args) throws ParseException {
        QuanLySanPham ds = new QuanLySanPham();
//cac  dich vu tang kem
        DichVuTangKem dvtk1 = new DichVuTangKem("ve xem phim");
        DichVuTangKem dvtk2 = new DichVuTangKem("ve xem hai kich");
//cac loai san pham->danh muc san pham
        DanhMucSanPham loai1 = new DanhMucSanPham("thiet bi dien tu");
        DanhMucSanPham loai2 = new DanhMucSanPham("do gia dung");
        DanhMucSanPham loai3 = new DanhMucSanPham("do thu cong");
//cac loai khuyen mai
        KhuyenMai kma = new KhuyenMaiA("16/04/2003", "15/12/2022");
        KhuyenMai kmb = new KhuyenMaiB("15/04/2001", "07/12/2022");
        KhuyenMai kmc = new KhuyenMaiC("15/04/2002", "22/12/2022", loai2);
//them dich vu tang kem vao khuyen mai        
        kmb.themDichVu(dvtk1);
//      kmb.themDichVu(dvtk2);
// tao san Pham
        SanPham sp1 = new SanPham("iphone", 23000000, loai1, kma);
        SanPham sp2 = new SanPham("noi com dien", 10000000, loai2, kmb);
        SanPham sp3 = new SanPham("tui giay", 15000, loai3, kmc);

//them san pham vao danh sach
        ds.themSp(sp1);
        ds.themSp(sp2);
        ds.themSp(sp3);
//        ds.themSp(sp4);

        Scanner sc = new Scanner(System.in);
        int choose = 0;
        do {

            System.out.println("================MENU==============");        
            System.out.println(
                    "1. Them San Pham vao danh sach\n"
                    + "2. Tim kiem san pham theo ten, theo khoang gia chi dinh va theo tung loai khuyen mai\n"
                    + "3. Them khuyen mai vao mot san pham\n"
                    + "4. Xoa cac khuyen mai het hieu luc khoi cac san pham\n"
                    + "5. Cho phep nguoi dung nhap so ngay x, xac dinh tat ca cac khuyen mai con x ngay het hieu luc\n"
                    + "6. hien thi thong tin khuyen mai cua san pham  chi dinh theo ma san pham hoac ten san pham\n"
                    + "7. Xem danh sach san pham co chua khuyen mai theo tung loai khuyen mai chi dinh\n"
                    + "8. Sap xep danh sach san pham giam dan theo so luong khuyen mai con hieu luc\n"
                    + "9. Xuat San Pham\n"
                    + "10. thoat"
            );
            System.out.println("==================================");
            System.out.print("Moi ban chon: ");
            choose = sc.nextInt();
            if (choose < 1 || choose > 10) {
                System.out.println("Vui long nhap trong menu");
            }
            sc.nextLine();
            switch (choose) {
                case 1: {
                    System.out.println("====Tao san pham====");
                    System.out.print("Nhap so luong san pham muon them: ");
                    int n = CauHinh.sc.nextInt();
                    CauHinh.sc.nextLine();
                    ds.nhapSp(n);
                    ds.xuatDsSp();
                    break;
                }
                case 2: {
                    ds.timKiemSanPham();
                    break;
                }
                case 3: {
                    ds.nhapKhuyenMai();
                    ds.xuatDsSp();
                    break;
                }
                case 4: {
                    ds.xoaKhuyenMaiHetHan();
                    ds.xuatDsSp();
                    break;
                }
                case 5: {
                    ds.kiemTraXNgayHanSuDung();
                    break;
                }
                case 6: {
                    ds.hienThiThongTinTheoTenVaMaSPChiDinh();
                    break;
                }
                case 7: {
                    ds.timKiemMaKhuyenMaiTheoChiDinh();
                    break;
                }
                case 8: {
                    ds.sapXepGiam();
                    ds.xuatDsSp();
                    break;
                }
                case 9: {
                    ds.xuatDsSp();
                    break;
                }
                case 10: {
                    System.out.println("Tam biet quy khach!!!");
                    break;
                }
            }
        } while (choose != 10);

    }
}
