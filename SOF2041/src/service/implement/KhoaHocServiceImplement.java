/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import java.util.ArrayList;
import model.KhoaHoc;
import repositories.IKhoaHocRepository;
import repositories.implement.KhoaHocRepositoryImplement;
import service.IKhoaHocService;

/**
 *
 * @author HA NGOC BACH
 */
public class KhoaHocServiceImplement implements IKhoaHocService {

    private IKhoaHocRepository KhoaHocRepository = new KhoaHocRepositoryImplement();
    
    @Override
    public ArrayList<KhoaHoc> getallKhoaHoc() {
        return KhoaHocRepository.getallKhoaHoc();
    }
    
}
