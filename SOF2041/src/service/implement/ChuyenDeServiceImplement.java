/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import java.util.ArrayList;
import model.ChuyenDe;
import repositories.IChuyenDeRespository;
import repositories.implement.ChuyenDeRespositoryImplement;
import service.IChuyenDeService;


public class ChuyenDeServiceImplement implements IChuyenDeService{
    
    private IChuyenDeRespository chuyenDeRespository = new ChuyenDeRespositoryImplement();
    @Override
    public ArrayList<ChuyenDe> getallChuyenDe() {
        return chuyenDeRespository.getallChuyenDe();
    }

    @Override
    public ChuyenDe finByMaCd(String macd) {
        return chuyenDeRespository.finByMaCd(macd);
    }
   

    @Override
    public ChuyenDe xoaChuyenDe(String macd) {
        return chuyenDeRespository.xoaChuyenDe(macd);
    }


    @Override
    public boolean themChuyenDe(ChuyenDe cd) {
        return chuyenDeRespository.ThemChuyenDe(cd);
    }

    @Override
    public boolean SuaChuyenDe(ChuyenDe cd, String Macd) {
        return chuyenDeRespository.SuaChuyenDe(cd, Macd);
    }
}
