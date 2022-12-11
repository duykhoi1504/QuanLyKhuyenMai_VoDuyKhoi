/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author VoDuyKhoi
 */
public abstract class KhuyenMai {


    private Date ngayTao;
    private Date ngayHetHieuLuc;
    protected String maKM;
//    private SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    public KhuyenMai(Date ngayTao, Date ngayHetHieuLuc) {
        this.ngayTao = ngayTao;
        this.ngayHetHieuLuc = ngayHetHieuLuc;
    }

    public KhuyenMai(String ngayTao, String ngayHetHieuLuc) throws ParseException {
        this.ngayTao = CauHinh.f.parse(ngayTao);
        this.ngayHetHieuLuc = CauHinh.f.parse(ngayHetHieuLuc);
    }

    public KhuyenMai() {
    }

    public void nhapKhuyenMai() throws ParseException {
        System.out.print("Ngay Tao (dd/MM/yyyy): ");
        String dayStart = CauHinh.sc.nextLine();
        this.ngayTao = CauHinh.f.parse(dayStart);
        System.out.print("Ngay het han (dd/MM/yyyy): ");
        String dayEnd = CauHinh.sc.nextLine();
        this.ngayHetHieuLuc = CauHinh.f.parse(dayEnd);
        while (this.ngayHetHieuLuc.before(ngayTao)) {
            System.out.println("ngay het han khong duoc truoc ngay tao");
            System.out.println("---vui long nhap lai---");
            System.out.print("Ngay het han (dd/MM/yyyy): ");
            String dayEnd2 = CauHinh.sc.nextLine();
            dayEnd = dayEnd2;
            this.ngayHetHieuLuc = CauHinh.f.parse(dayEnd);
        }
    }

    public void xuatKhuyenMai() {
        System.out.printf("ngay tao ma Khuyen Mai: %s\n", CauHinh.f.format(this.ngayTao));
        System.out.printf("ngay het han Khuyen Mai: %s\n", CauHinh.f.format(this.ngayHetHieuLuc));
        if (getHanSuDung() > 0) {
            System.out.println("-->han su dung ma khuyen mai con lai: " + getHanSuDung() + " ngay");
        } else {
            System.out.println("-->khuyen mai da qua han!! ");

        }
    }
//phương thức lấy trả về số ngày còn lại của Khuyến mãi
    public long getHanSuDung() {
        Date n = new Date();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(n);
        c2.setTime(this.ngayHetHieuLuc);
//      long dateEnd = this.ngayHetHieuLuc.getTime();
        long xDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000) + 1;
        if (xDay >= 0) {
            return xDay;
        } else {
            return 0;
        }
    }
////////////////////////////////////////////////////////////////////////////////
    /**
     * @return the ngayTao
     */
    public Date getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    /**
     * @return the ngayHetHieuLuc
     */
    public Date getNgayHetHieuLuc() {
        return ngayHetHieuLuc;
    }

    /**
     * @param ngayHetHieuLuc the ngayHetHieuLuc to set
     */
    public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
        this.ngayHetHieuLuc = ngayHetHieuLuc;
    }

    public void themDichVu(DichVuTangKem dvtk1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the maKM
     */
    public String getMaKM() {
        return maKM;
    }

    /**
     * @param maKM the maKM to set
     */
    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

}
