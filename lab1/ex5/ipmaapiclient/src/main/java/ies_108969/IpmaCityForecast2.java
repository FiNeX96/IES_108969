package ies_108969;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IpmaCityForecast2 {
       
    
    @SerializedName("data")
    @Expose
    private List<CityForecast2> data = null;
    @SerializedName("globalIdLocal")
    @Expose
    private Integer globalIdLocal;
    
    

    public List<CityForecast2> getData() {
        return data;
    }

    public void setData(List<CityForecast2> data) {
        this.data = data;
    }

    public Integer getGlobalIdLocal() {
        return globalIdLocal;
    }

    public void setGlobalIdLocal(Integer globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    
    }

        

