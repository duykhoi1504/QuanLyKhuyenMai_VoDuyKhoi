/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author VoDuyKhoi
 */
public class QuanLySanPham {

    public static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    private List<SanPham> ds = new ArrayList<>();

    public QuanLySanPham() {
    }

//Phương thức Xuất danh sách sản phẩm
    public void xuatDsSp() {
        this.ds.forEach(h -> h.xuatSanPham());
    }

//Phương thức thêm san phẩm vào danh sách
    public void themSp(SanPham s) {
        this.ds.add(s);
    }

//Phương thưc nhập sản phẩm
    public void nhapSp(int n) throws ParseException {
        for (int i = 0; i < n; i++) {
            System.out.printf("== Nhap San Pham thu %d\n", i + 1);
            SanPham s = new SanPham();
            s.nhapSanPham();
            this.ds.add(s);
        }
    }

//Phương thức nhập khuyến mãi cho sản phẩm
    public void nhapKhuyenMai() throws ParseException {
        System.out.print("nhap ma san pham can them Khuyen Mai : ");
        int key = CauHinh.sc.nextInt();
        CauHinh.sc.nextLine();
        timKiemTheoMaSanPham(key).nhapKhuyenMai();
    }

//Phương thức tìm theo tên 
    public SanPham timKiemTheoTen(String key) {
        for (SanPham h : this.ds) {
            if (h.getTenSanPham().indexOf(key) >= 0) {
                return h;
            }
        }
        return null;
    }

//phuong thức tìm kiếm theo Ma Khuyen Mai (EX:A01,C0001,B....)
//chỉ trả về 1 sản phẩm
    public SanPham timKiemTheoMaKhuyenMai(String key_KM) {
        for (SanPham h : this.ds) {
            if (h.getKm().maKM.indexOf(key_KM) >= 0) {
                return h;
            }
        }
        return null;
    }
//phuong thức tìm kiếm theo mã sản phẩm(EX:1 ,2 ,3 ,4,....)

    public SanPham timKiemTheoMaSanPham(int key) {
        for (SanPham h : this.ds) {
            if (h.getMaSanPham() == key) {
                return h;
            }
        }
        return null;
    }

    //phương thức tìm kiếm mã khuyến mãi theo chỉ định(EX:A01,......)
    //xuất ra nhiều Sản phẩm có cùng tên
    public void timKiemMaKhuyenMaiTheoChiDinh() {
        System.out.print("nhap Ma khuyen mai can tim: ");
        String key_KM = CauHinh.sc.nextLine();

        String temp3[] = new String[1];
        for (SanPham h : this.ds) {
            if (h.getKm().maKM.indexOf(key_KM) >= 0) {
                temp3[0] = h.getKm().maKM;
                System.out.println("===san pham tim duoc=== ");
                h.xuatSanPham();
            }
        }
        if (temp3[0] == null) {
            System.out.println("!!!Khong tim duoc!!! ");
        }
    }

//phuong thức tìm kiếm San Phẩm (kết hơp nhiều Phương thức khác đã viết)
    /**
     * 1.timKiemTheoTen(); 2..... 3.timKiemMaKhuyenMaiTheoChiDinh()
     */
    public void timKiemSanPham() {
        System.out.println("1.tim theo ten san pham");
        System.out.println("2.tim theo khoang gia chi chi dinh");
        System.out.println("3.tim theo tung loai khuyen mai");
        System.out.print("chon:");

        int choose = CauHinh.sc.nextInt();
        CauHinh.sc.nextLine();
        switch (choose) {
            case 1:
                System.out.print("nhap ten san pham can tim: ");
                String keyWord = CauHinh.sc.nextLine();
                if (timKiemTheoTen(keyWord) != null) {
                    System.out.println("===san pham tim duoc=== ");
                    timKiemTheoTen(keyWord).xuatSanPham();
                } else {
                    System.out.println("!!!Không tìm duoc!!! ");
                }
                break;
            case 2:
                System.out.print("nhap gia san pham can tim: ");
                double key_Cost = CauHinh.sc.nextDouble();
                for (SanPham h : this.ds) {
                    if (h.getGiaBan() <= key_Cost) {
                        System.out.printf("***san pham duoi %,.1f*** \n ", key_Cost);
                        h.xuatSanPham();
                    }
                }
                break;
            case 3:
                timKiemMaKhuyenMaiTheoChiDinh();
                break;
            default:
                break;
        }

    }

//phương thức xóa khuyến mãi đã hết hạn
    public void xoaKhuyenMaiHetHan() {
        Date n = new Date();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        for (SanPham h : this.ds) {
            if (h.getKm() != null) {
                c1.setTime(n);
                c2.setTime(h.getKm().getNgayHetHieuLuc());

                if (c1.after(c2)) {
                    h.xoaKhuyenMai();
                }
            } else {
                continue;
            }
        }
    }
//phương thức cho người nhập nhập số ngày x
// tìm các Sản phẩm có khuyến mãi còn lại x ngày
    public void kiemTraXNgayHanSuDung() {
        boolean temp = false;
        System.out.print("nhap so ngay han su dung con lai:");
        long xDayIP = CauHinh.sc.nextLong();
        CauHinh.sc.nextLine();
        for (SanPham h : this.ds) {
            if (h.getKm() != null) {
                if (xDayIP == h.getKm().getHanSuDung()) {
                    temp = true;
                    System.out.println("ma khuyen mai cua san pham: " + h.getTenSanPham()
                            + " ->con lai :" + h.getKm().getHanSuDung() + " ngay ");
                    h.xuatSanPham();
                }
            } else {
                continue;
            }
        }
        if (temp == false) {
            System.out.println("!!khong co san pham nao con " + xDayIP + " ngay han su dung!!");
        }
    }
//phương thức cho người dùng nhập tên sản phẩm và mã sản phẩm(1,2,3,...)
// nếu tìm thấy sẽ xuất ra màn hình
    public void hienThiThongTinTheoTenVaMaSPChiDinh() {
        boolean temp = false;
        System.out.print("nhap ten san pham hoac ma san pham: ");
        String key = CauHinh.sc.nextLine();
        for (SanPham h : this.ds) {
            if (String.valueOf(h.getMaSanPham()).equals(key) || h.getTenSanPham().indexOf(key) >= 0) {
                h.xuatSanPham();
                temp = true;
            }
        }
        if (temp == false) {
            System.out.println("!!khong tim thay san pham!!");
        }

    }
//phương thức sắp xếp giảm nhưng bị lỗi nullpointer khi xóa sản Phẩm
//chỉ thực hiện được khi tất cả sản phẩm có khuyến mãi
//    public void sapXepGiam() {
//        this.ds.sort((s1, s2) -> {
//            long g1 = s1.getKm().getHanSuDung();
//            long g2 = s2.getKm().getHanSuDung();
//
//            return -(g1 > g2 ? 1 : ((g1 > g2) ? -1 : 0));
//        });
//    }

//phương thức sắp xếp giảm dần theo số ngày còn lại của hạn dụng
    public void sapXepGiam() {
        Collections.sort(ds, new Comparator<SanPham>() {

            @Override
            public int compare(SanPham str1, SanPham str2) {
                if (null == str1.getKm()) {
                    return null == str2 ? 0 : 1;
                } else if (null == str2.getKm()) {
                    return -1;
                } else {
                    long g1 = str1.getKm().getHanSuDung();
                    long g2 = str2.getKm().getHanSuDung();

                    return -(g1 > g2 ? 1 : ((g1 > g2) ? -1 : 0));
                }
            }
        });
    }

////////////////////////////////////////////////////////////////////////////////
    /**
     * @return the ds
     */
    public List<SanPham> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<SanPham> ds) {
        this.ds = ds;
    }

}
