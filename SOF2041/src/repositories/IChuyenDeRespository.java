/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import java.util.ArrayList;
import model.ChuyenDe;

/**
 *
 * @author HA NGOC BACH
 */
public interface IChuyenDeRespository extends IDBConnection{
    public ArrayList<ChuyenDe> getallChuyenDe();

    public ChuyenDe finByMaCd(String macd);
    
    public ChuyenDe xoaChuyenDe(String macd);
    
    public boolean ThemChuyenDe(ChuyenDe cd);
    
    public ChuyenDe SuaChuyenDe(ChuyenDe cd,String Macd );
}
