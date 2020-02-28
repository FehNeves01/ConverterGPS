package convertergps;

import convertergps.pojo.Linha;
import convertergps.pojo.Carro;
import convertergps.pojo.GPS;
import convertergps.pojo.Data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    private String array_str_Dir[];
    private String str_newDireotorio;
    

    public PreparandoArquivoGPS(String str_Diretorio) {
        tratandoArquivoAberto = new TratandoArquivoAberto(str_Diretorio);
        array_str_Dir = str_Diretorio.split("/");
        str_newDireotorio=corrigindoDiretorio(array_str_Dir);
        
        
        Array_Carro_Prefixos = tratandoArquivoAberto.getArray_Carro_Prefixos();
        Array_Data_Hora = tratandoArquivoAberto.getArray_Data_Hora();
        Array_GPS_Gps = tratandoArquivoAberto.getArray_GPS_Gps();
        Array_Linha_Linha = tratandoArquivoAberto.getArray_Linha_Linha();

        preparaArquivoPlanobusWeb();
    }

    private String preparaArquivoPlanobusWeb() {
        String str_arquivoPlanobusWeb = "";
        String str_cabecalho = "prefixo;hora;latitude;longitude;linha\n";
        str_arquivoPlanobusWeb += str_cabecalho;

        for (int i = 0; i < Array_GPS_Gps.size(); i++) {
            str_arquivoPlanobusWeb
                    += Array_Carro_Prefixos.get(i).getCarro() + ";"
                    + Array_Data_Hora.get(i).getHora1() + ";"
                    + Array_GPS_Gps.get(i).getStr_Latitude() + ";"
                    + Array_GPS_Gps.get(i).getStr_Longitude() + ";"
                    + Array_Linha_Linha.get(i).getStr_codigoIdentificadorLinha() + "\n";
        }
        return (str_arquivoPlanobusWeb);

    }

    public void gravandoArquivo() throws IOException{
        System.out.println(str_newDireotorio);
        
        File file = new File(str_newDireotorio);
        try(FileWriter arquivoGravar = new FileWriter(file);
                BufferedWriter objetoGravar = new BufferedWriter(arquivoGravar);){
                    objetoGravar.write(preparaArquivoPlanobusWeb());
                }
            JOptionPane.showMessageDialog(null, "Arquivo Gravado");
    }
    
    private String corrigindoDiretorio(String array_str_Dir[]) {
        String str_newDiretorio = "";
        int int_ultimalinha = (array_str_Dir.length)-1;
        String str_dataArquivo = array_str_Dir[int_ultimalinha];
        String array_str_dovidindoData[]= str_dataArquivo.split("-");
        String anoTxt = array_str_dovidindoData[array_str_dovidindoData.length-1];
        String array_str_ano[] = anoTxt.split(".txt");
        str_dataArquivo = array_str_ano[0]+"-"+array_str_dovidindoData[0]+"-"+array_str_dovidindoData[1];
        for (int i = 0; i < array_str_Dir.length-1; i++) {
            str_newDiretorio += array_str_Dir[i]+"/";
        }
        str_newDiretorio += str_dataArquivo + ".gps";
        
        return str_newDiretorio;
    }
}
