package ies_108969;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.HashMap;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    private static Logger logger = LogManager.getLogger(WeatherStarter.class);

    public static void getWeatherForecast() {

        // get a retrofit instance, loaded with the GSon lib to convert JSON into
        // objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);

        // prepare the call to remote endpoint

        HashMap<String, Integer> cities_ids = new HashMap<String, Integer>();
        Call<IpmaCityForecast2> callSync2 = service.getCityName();


        try {

            Response<IpmaCityForecast2> apiResponse2 = callSync2.execute();

            IpmaCityForecast2 forecast2 = apiResponse2.body();

            for (CityForecast2 city : forecast2.getData()) {
                cities_ids.put(city.getLocal(), city.getGlobalID());
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        // choose a random id from a city
        int random_id = (int) (Math.random() * cities_ids.size());
        // get corresponding name
        String random_city = (String) cities_ids.keySet().toArray()[random_id];
        // get corresponding id
        int random_city_id = cities_ids.get(random_city);

        try {
            Call<IpmaCityForecast> callSync = service.getForecastForACity(random_city_id);
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                //logger.debug("Sucessfull API call for city with id: " + random_city_id);
                CityForecast firstDay = forecast.getData().listIterator().next();

                logger.debug(" City : " + random_city + " , day : " +firstDay.getForecastDate() + " , Data : Max Temp -> " + Double.parseDouble(firstDay.getTMax()) + "  , Min Temp ->  " + Double.parseDouble(firstDay.getTMin()));

            } else {
                System.out.println("No results for this request!");
                logger.error("Unsucessfull API call for city with id: " + random_city_id);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }

    }
}

    

