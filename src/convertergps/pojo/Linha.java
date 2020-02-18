
package convertergps.pojo;

/**
 *
 * @author felipeneves
 */
public class Linha {
    private String str_codigoIdentificadorLinha;
    private String str_sentido;
    private String str_numero;
    private String str_codigoDaParada;
    private String str_lugar;
    
    
    /*       Getter         */

    public String getStr_codigoIdentificadorLinha() {
        return str_codigoIdentificadorLinha;
    }

    public String getStr_sentido() {
        return str_sentido;
    }

    public String getStr_numero() {
        return str_numero;
    }

    public String getStr_codigoDaParada() {
        return str_codigoDaParada;
    }

    public String getStr_lugar() {
        return str_lugar;
    }
    
    
    /*       Setter         */

    public void setStr_codigoIdentificadorLinha(String str_codigoIdentificadorLinha) {
        this.str_codigoIdentificadorLinha = str_codigoIdentificadorLinha;
    }

    public void setStr_sentido(String str_sentido) {
        this.str_sentido = str_sentido;
    }

    public void setStr_numero(String str_numero) {
        this.str_numero = str_numero;
    }

    public void setStr_codigoDaParada(String str_codigoDaParada) {
        this.str_codigoDaParada = str_codigoDaParada;
    }

    public void setStr_lugar(String str_lugar) {
        this.str_lugar = str_lugar;
    }
    
}
