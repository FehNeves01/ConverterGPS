
package convertergps;

import java.util.ArrayList;

/**
 *
 * @author felipeneves
 */
public class PreparandoArquivoGPS {
    private TratandoArquivoAberto tratandoArquivoAberto;
//    private String tipoAserLido;  Vai ser Usada no Futuro
//    private String tipoAserGravado;  Vai ser Usada no Futuro
    private ArrayList<Carro> Array_Carro_Prefixos;
    private ArrayList<Data> Array_Data_Hora;
    private ArrayList<GPS> Array_GPS_Gps;
    private ArrayList<Linha> Array_Linha_Linha;
   
    
    
    

    public PreparandoArquivoGPS(String str_Diretorio) {
        tratandoArquivoAberto = new TratandoArquivoAberto(str_Diretorio);
        
        Array_Carro_Prefixos = tratandoArquivoAberto.getArray_Carro_Prefixos();
        Array_Data_Hora = tratandoArquivoAberto.getArray_Data_Hora();
        Array_GPS_Gps = tratandoArquivoAberto.getArray_GPS_Gps();
        Array_Linha_Linha=tratandoArquivoAberto.getArray_Linha_Linha();
        
        preparaArquivoPlanobusWeb();
    }

    private void preparaArquivoPlanobusWeb() {
        String str_arquivoPlanobusWeb = "";
        String str_cabecalho ="prefixo;hora;latitude;longitude;linha";
        str_arquivoPlanobusWeb += str_cabecalho;
        System.out.println(str_arquivoPlanobusWeb);
        
        for (int i = 0; i < Array_GPS_Gps.size(); i++) {
            str_arquivoPlanobusWeb = 
                    Array_Carro_Prefixos.get(i).getCarro() +";"
                    + Array_Data_Hora.get(i).getHora1() +";"
                    + Array_GPS_Gps.get(i).getStr_Latitude()+";"
                    + Array_GPS_Gps.get(i).getStr_Longitude()+";"
                    + Array_Linha_Linha.get(i).getStr_codigoIdentificadorLinha()+"\n";
            System.out.println(str_arquivoPlanobusWeb);
        }
        
        
        
        
    }
    
    
}
