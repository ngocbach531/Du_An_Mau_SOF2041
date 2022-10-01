package service.impl;

import model.NhanVien;
import repositories.INhanvienRespository;
import repositories.impl.NhanVienRepositoryImpl;
import service.INhanVienService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HA NGOC BACH
 */
public class NhanVienServiceImpl implements INhanVienService {

    private INhanvienRespository iNhanvienRespository = new NhanVienRepositoryImpl();

    @Override
    public NhanVien getNVbyMaAndPass(String maNv, String password) {
        NhanVien nhanVien = null;
        if (maNv.isBlank() || password.isBlank()) {
            Helper.DialogHelper.alert(null, "Username và password không được để trống");
            return nhanVien;
        } else {
            nhanVien = iNhanvienRespository.getNVbyMaAndPass(maNv, password);
            if (nhanVien == null) {
                Helper.DialogHelper.alert(null, "Username và password không đúng");
            }else{
                Helper.ShareHelper.USER = nhanVien;
            }
            return nhanVien;
        }
    }

}
