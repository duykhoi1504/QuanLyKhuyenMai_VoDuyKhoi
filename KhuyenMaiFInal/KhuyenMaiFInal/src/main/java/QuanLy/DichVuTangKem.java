/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author VoDuyKhoi
 */
public class DichVuTangKem {

    private String dichVu;

    public DichVuTangKem(String dichVu) {
        this.dichVu = dichVu;
    }

    public DichVuTangKem() {
    }

    public void nhapDichVuTangKem() {
        System.out.print("nhap dich vu tang kem:");
         this.dichVu = CauHinh.sc.nextLine();


    }

    public void xuatDichVuTangKem() {
        System.out.printf("dich vu tang kem : %s\n ", this.dichVu);
    }
}
