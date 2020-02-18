package convertergps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TratandoArquivoAberto {

    private Carro Carro_car;
    private Data Data_date;
    private GPS GPS_gps;
    private Linha Linha_linha;

    private ArrayList<String> Array_Str_LinhasDoArquivo;
    private ArrayList<Carro> Array_Carro_Prefixos;
    private ArrayList<Data> Array_Data_Hora;
    private ArrayList<GPS> Array_GPS_Gps;
    private ArrayList<Linha> Array_Linha_Linha;

    private AbrirArquivo open;

    public TratandoArquivoAberto(String diretorio) {
        open = new AbrirArquivo(diretorio);
        try {
            Array_Carro_Prefixos = new ArrayList();
            Array_Data_Hora = new ArrayList();
            Array_GPS_Gps = new ArrayList();
            Array_Linha_Linha = new ArrayList();

            Array_Str_LinhasDoArquivo = open.abrirArquivo();
        } catch (IOException ex) {
            Logger.getLogger(TratandoArquivoAberto.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Quando houver outros arquivos, colocar o if de comparação do tipo 
        tratandoLinhaDoArquivo();
    }

    private void tratandoLinhaDoArquivo() {
        for (int i = 0; i < Array_Str_LinhasDoArquivo.size(); i++) {
    

            String vet[] = Array_Str_LinhasDoArquivo.get(i).split("	");

            objetoData(vet[0], vet[1]);
            objetoGPS(vet[4], vet[5]);
            objetoCarro(vet[3]);
            objetoLinha(vet[8], vet[9], vet[2], vet[6], vet[7]);

//            for (int j = 0; j < vet.length; j++) {
//                System.out.print(vet[j] + " || ");
//            }
//            System.out.println("");
        }
    }

    private void objetoData(String x, String y) {
        Data_date = new Data();
        Data_date.setGeral0(x);
        Data_date.setGeral1(y);
        Array_Data_Hora.add(Data_date);
    }

    private void objetoGPS(String latitude, String longitude) {
        GPS_gps = new GPS();
        GPS_gps.setGeral(latitude, longitude);
        Array_GPS_Gps.add(GPS_gps);
    }

    private void objetoCarro(String x) {
        Carro_car = new Carro();
        Carro_car.setCarro(x);
        Array_Carro_Prefixos.add(Carro_car);
    }

    private void objetoLinha(String str_codigoIdentificador, String str_sentido, String str_numero, String str_codigoDaParada, String str_lugar) {

        Linha_linha = new Linha();

        Linha_linha.setStr_codigoIdentificadorLinha(str_codigoIdentificador);
        Linha_linha.setStr_sentido(str_sentido);
        Linha_linha.setStr_numero(str_numero);
        Linha_linha.setStr_codigoDaParada(str_codigoDaParada);
        Linha_linha.setStr_lugar(str_lugar);

        Array_Linha_Linha.add(Linha_linha);
    }

    /*      Getter      */
    public ArrayList<String> getArray_Str_LinhasDoArquivo() {
        return Array_Str_LinhasDoArquivo;
    }

    public ArrayList<Carro> getArray_Carro_Prefixos() {
        return Array_Carro_Prefixos;
    }

    public ArrayList<Data> getArray_Data_Hora() {
        return Array_Data_Hora;
    }

    public ArrayList<GPS> getArray_GPS_Gps() {
        return Array_GPS_Gps;
    }

    public ArrayList<Linha> getArray_Linha_Linha() {
        return Array_Linha_Linha;
    }

}
