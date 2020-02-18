package convertergps;

import java.util.Calendar;


public class Data {

    private String data;
    private String hora;
    
    private String data1;
    private String hora1;

    /*            Getter           */
    public String getData() {
        return data;
    }
    public String getHora() {
        return hora;
    }
    public String getData1() {
        return data1;
    }
    public String getHora1() {
        return hora1;
    }
    

    /*            Setter           */
    public void setData(String data) {
        this.data = data;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setData1(String data0) {
        this.data1 = data0;
    }
    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }
    


    public void setGeral0(String informacao){
        String inform[] = informacao.split(" ");
        this.data = inform[0];
        this.hora = inform[1];
    }
     public void setGeral1(String informacao){
        String inform[] = informacao.split(" ");
        this.data1 = inform[0];
        this.hora1 = inform[1];
    }
}
