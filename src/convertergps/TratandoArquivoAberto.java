package convertergps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TratandoArquivoAberto {

    private ArrayList<String> Array_Str_LinhasDoArquivo;
    private AbrirArquivo open;

    public TratandoArquivoAberto(String diretorio) {
        open = new AbrirArquivo(diretorio);
        try {
            Array_Str_LinhasDoArquivo = open.abrirArquivo();
        } catch (IOException ex) {
            Logger.getLogger(TratandoArquivoAberto.class.getName()).log(Level.SEVERE, null, ex);
        }
        tratandoLinhaDoArquivo();
    }

    private void tratandoLinhaDoArquivo() {
        for (int i = 0; i < 2; i++) {
            
            String vet[] = Array_Str_LinhasDoArquivo.get(i).split(" ");
            for (int j = 0; j < vet.length; j++) {
                System.out.println(vet[j]);
                
            }
        }
    }
}
