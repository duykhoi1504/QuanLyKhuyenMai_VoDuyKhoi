/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author VoDuyKhoi
 */
public class SanPham {

    private static int dem = 0;
    private int maSanPham;
    private String tenSanPham;
    private double giaBan;
    private DanhMucSanPham danhMucSanPham;
    private KhuyenMai km;

    {
        this.maSanPham=++dem;
    }

    public SanPham() {
    }

    public SanPham(String tenSanPham, double giaBan, DanhMucSanPham danhMucSanPham, KhuyenMai km) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.danhMucSanPham = danhMucSanPham;
        this.km = km;
    }

    public void nhapSanPham() throws ParseException {
        System.out.print("ten San Pham: ");
        this.tenSanPham = CauHinh.sc.nextLine();

        System.out.print("gia ban: ");
        this.giaBan = CauHinh.sc.nextDouble();
        CauHinh.sc.nextLine();

        DanhMucSanPham dmsp = new DanhMucSanPham();
        dmsp.nhapDanhMucSp();
        this.danhMucSanPham = dmsp;

        nhapKhuyenMai();
    }

    public void nhapKhuyenMai() throws ParseException {
        System.out.print("chon loai khuyen mai A/B/C or not  ");
        String chon = CauHinh.sc.nextLine();

        switch (chon) {
            case "A":
            case "a":
                KhuyenMai a = new KhuyenMaiA();
                a.nhapKhuyenMai();
                this.km = a;
                break;
            case "B":
            case "b":
                KhuyenMai b = new KhuyenMaiB();
                b.nhapKhuyenMai();
                this.km = b;
                break;
            case "C":
            case "c":
                KhuyenMai c = new KhuyenMaiC();
                c.nhapKhuyenMai();
                this.km = c;
                break;
            default:
                break;
        }
    }

    public void xuatSanPham() {
        System.out.println("==================================");
        System.out.printf("ma san Pham: %d\n", this.getMaSanPham());
        System.out.printf("ten san pham: %s\n", this.tenSanPham);
        System.out.printf("gia ban san pham: %,.0f VND\n", this.giaBan);
        System.out.printf("danh muc san pham: %s\n", this.danhMucSanPham);
        if (this.km != null) {
            xuatKhuyenMai();

        }
    }

    public void xuatKhuyenMai() {
        km.xuatKhuyenMai();
    }

    public void xuatLoaiSanPham() {
        System.out.printf("loai san pham:%s", this.danhMucSanPham);
    }

    public void xoaKhuyenMai() {
        this.km = null;
    }

////////////////////////////////////////////////////////////////////////////////
    /**
     * @return the tenSanPham
     */
    public String getTenSanPham() {
        return tenSanPham;
    }

    /**
     * @param tenSanPham the tenSanPham to set
     */
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    /**
     * @return the giaBan
     */
    public double getGiaBan() {
        return giaBan;
    }

    /**
     * @param giaBan the giaBan to set
     */
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    /**
     * @return the danhMucSanPham
     */
    public DanhMucSanPham getDanhMucSanPham() {
        return danhMucSanPham;
    }

    /**
     * @param danhMucSanPham the danhMucSanPham to set
     */
    public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    /**
     * @return the km
     */
    public KhuyenMai getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(KhuyenMai km) {
        this.km = km;
    }

    /**
     * @return the maSanPham
     */
    public int getMaSanPham() {
        return maSanPham;
    }

    /**
     * @param maSanPham the maSanPham to set
     */
    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

}
