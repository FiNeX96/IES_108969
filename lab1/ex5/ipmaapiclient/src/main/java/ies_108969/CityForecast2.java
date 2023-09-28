package ies_108969;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityForecast2 {

    @SerializedName("local")
    @Expose
    private String local;
    @SerializedName("globalIdLocal")
    @Expose
    private int globalIdLocal;

    public String getLocal() {
        return local;
    }
    
    public int getGlobalID() {
        return globalIdLocal;
    }

    public void setGlobalID(int globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    
}
