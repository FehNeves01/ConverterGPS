/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertergps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipeneves
 */
public class ConverterGPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <String> linhasDoArquivo = new ArrayList<String>();
        
        AbrirArquivo open = new AbrirArquivo("C:\\Users\\felip\\Desktop\\Felipe\\EXPRESS\\GPS\\06-02-2020.txt");
        try {
            linhasDoArquivo = open.abrirArquivo();
        } catch (IOException ex) {
            Logger.getLogger(ConverterGPS.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Quantidades Linhas do Arquivo  ||  " + linhasDoArquivo.size() );
        
        for (int i = 0; i < linhasDoArquivo.size(); i++) {
            System.out.println(linhasDoArquivo.get(i));
            
        }
    }
    
}
