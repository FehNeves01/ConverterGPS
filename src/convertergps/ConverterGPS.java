/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertergps;

import convertergps.pojo.DataGps;
import convertergps.pojo.DataGpsRaw;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConverterGPS {

    public void converter(NewJFrame tela, String diretorioMacOS) throws Exception {
        new Thread() {
            public void run() {
//                String diretorioMacOS = "/Users/felipeneves/documents/ARQUIVOS_EMPRESAS/DUTRA/Setembro2018/12-09-2018.txt";

                System.out.println(diretorioMacOS);

                File fileIn = new File(diretorioMacOS);
                File fileOut = new File(corrigindoDiretorio(diretorioMacOS, ".gps"));
                String linhaStr;

                if (fileIn.exists()) {
                    BufferedReader brIn = null;
                    try {
                        brIn = new BufferedReader(new FileReader(fileIn));
                        BufferedWriter brOut = new BufferedWriter(new FileWriter(fileOut));
                        String cabecalho = "prefixo;hora;latitude;longitude;linha" + System.lineSeparator();
                        brOut.write(cabecalho);
                        int i = 0;
                        while ((linhaStr = brIn.readLine()) != null) {
                            i++;

                            if (i % 10000.0f == 0) {
                                tela.setjTextField_linhasConvertidas(i + "");
//                    System.out.println("i: " + i);
                            }

                            String vet[] = linhaStr.split("	");

                            DataGpsRaw raw = new DataGpsRaw();
                            raw.data = vet[0].split(" ")[0];
                            raw.hora = vet[0].split(" ")[1];
                            raw.data1 = vet[1].split(" ")[0];
                            raw.hora1 = vet[1].split(" ")[1];

                            raw.linha = vet[2];

                            raw.carro = vet[3];

                            raw.str_Latitude = vet[4];
                            raw.str_Longitude = vet[5];

                            DataGps dataGps = new DataGps();
                            dataGps.carro = raw.carro;
                            dataGps.hora = raw.hora1;
                            dataGps.str_Latitude = raw.str_Latitude;
                            dataGps.str_Longitude = raw.str_Longitude;
                            dataGps.linha = raw.linha;

                            String linhaOut = dataGps.carro + ";" + dataGps.hora + ";" + dataGps.str_Latitude + ";" + dataGps.str_Longitude + ";" + dataGps.linha + System.lineSeparator();
                            brOut.write(linhaOut);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ConverterGPS.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ConverterGPS.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            brIn.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ConverterGPS.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    System.out.println("Arquivo Nao Encontrado");
                }
            }
        }.start();
    }

    public String corrigindoDiretorio(String str_Diretorio, String tipoArquivo) {
        if (descobreSistemaOperacional() != "MacOs") {

            String[] array_str_Dir = str_Diretorio.split("\\\\");
            String str_newDiretorio = "";
            int int_ultimalinha = (array_str_Dir.length) - 1;

            String str_dataArquivo = array_str_Dir[int_ultimalinha];
            String array_str_dovidindoData[] = str_dataArquivo.split("-");
            String anoTxt = array_str_dovidindoData[array_str_dovidindoData.length - 1];

            String array_str_ano[] = anoTxt.split(".txt");

            str_dataArquivo = array_str_ano[0] + "-" + array_str_dovidindoData[1] + "-" + array_str_dovidindoData[0];
            for (int i = 0; i < array_str_Dir.length - 1; i++) {
                str_newDiretorio += array_str_Dir[i] + "\\";
            }
            str_newDiretorio += str_dataArquivo + tipoArquivo;

            System.out.println(str_newDiretorio);
            return str_newDiretorio;
        } else {

            String[] array_str_Dir = str_Diretorio.split("/");
            String str_newDiretorio = "";
            int int_ultimalinha = (array_str_Dir.length) - 1;

            String str_dataArquivo = array_str_Dir[int_ultimalinha];
            String array_str_dovidindoData[] = str_dataArquivo.split("-");
            String anoTxt = array_str_dovidindoData[array_str_dovidindoData.length - 1];

            String array_str_ano[] = anoTxt.split(".txt");

            str_dataArquivo = array_str_ano[0] + "-" + array_str_dovidindoData[1] + "-" + array_str_dovidindoData[0];
            
            for (int i = 0; i < array_str_Dir.length - 1; i++) {
                str_newDiretorio += array_str_Dir[i] + "/";
            }
            str_newDiretorio += str_dataArquivo + tipoArquivo;

            System.out.println(str_newDiretorio);
            return str_newDiretorio;
        }
    }

    private String descobreSistemaOperacional() {

        return System.getProperty("os.name");
    }
}
