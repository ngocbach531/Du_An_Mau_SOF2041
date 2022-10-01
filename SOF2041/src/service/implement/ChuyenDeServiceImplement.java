/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import java.util.ArrayList;
import model.ChuyenDe;
import repositories.IChuyenDeRespository;
import repositories.implement.ChuyenDeRespositoryImplement;
import service.IChuyenDeSevice;


public class ChuyenDeServiceImplement implements IChuyenDeSevice{
    
    private IChuyenDeRespository chuyenDeRespository = new ChuyenDeRespositoryImplement();
    @Override
    public ArrayList<ChuyenDe> getallChuyenDe() {
        return chuyenDeRespository.getallChuyenDe();
    }

    @Override
    public ChuyenDe finById(String macd) {
        return chuyenDeRespository.finById(macd);
    }
    
    
}
