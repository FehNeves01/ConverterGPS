/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertergps.pojo;

/**
 *
 * @author felipeneves
 */
public class GPS {
    private String str_Latitude;
    private String str_Longitude;

    public String getStr_Latitude() {
        return str_Latitude;
    }

    public String getStr_Longitude() {
        return str_Longitude;
    }

    public void setStr_Latitude(String str_Latitude) {
        this.str_Latitude = str_Latitude;
    }

    public void setStr_Longitude(String str_Longitude) {
        this.str_Longitude = str_Longitude;
    }
    
    public void setGeral(String latitude, String longitude){
        this.str_Latitude = latitude;
        this.str_Longitude = longitude;
    }
    
    
    
    
}
