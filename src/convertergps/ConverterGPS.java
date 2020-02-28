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
        String diretorio = "C:\\Users\\felip\\Desktop\\Felipe\\EXPRESS\\GPS\\04-02-2020.txt";
        String diretorioMacOS ="/Users/felipeneves/documents/ARQUIVOS_EMPRESAS/express/gps/04-02-2020.txt";
        
        //TratandoArquivoAberto trat = new TratandoArquivoAberto(diretorioMacOS);
        PreparandoArquivoGPS open = new PreparandoArquivoGPS(diretorioMacOS);
        try {
            open.gravandoArquivo();
        } catch (IOException ex) {
            Logger.getLogger(ConverterGPS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
