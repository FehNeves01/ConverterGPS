package convertergps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AbrirArquivo {

    private File file;
    private ArrayList<String> linhasDoArquivo = new ArrayList<>();

    public AbrirArquivo(String diretorio) {
        file = new File(diretorio);
    }

    public ArrayList<String> abrirArquivo() throws FileNotFoundException, IOException {
        String linhas;
        if (file.exists()) {
            try (FileReader lendoArquivo = new FileReader(file); 
                    BufferedReader objetoDeLeitura = new BufferedReader(lendoArquivo);) {
                while ((linhas = objetoDeLeitura.readLine()) != null) {
                    linhasDoArquivo.add(linhas);
              }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado" + file);
        }
        
        return linhasDoArquivo;
    }
}
