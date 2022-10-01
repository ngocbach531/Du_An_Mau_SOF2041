/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.NhanVien;

/**
 *
 * @author HA NGOC BACH
 */
public interface INhanVienService {
    public NhanVien getNVbyMaAndPass(String maNv, String password);
}
