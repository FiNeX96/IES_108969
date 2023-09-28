package ies_108969;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    private static Logger logger = LogManager.getLogger(WeatherStarter.class);


    public static void  main(String[] args ) {

    if (args.length == 0) {
        System.err.println("Usage: WeatherStarter <city-code>");
        return;
    }

       final int CITY_ID = Integer.parseInt(args[0]);

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.debug("Sucessfull API call for city with id: " + CITY_ID);
                CityForecast firstDay = forecast.getData().listIterator().next();

                System.out.printf( "max temp for %s is %4.1f %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));
            } else {
                System.out.println( "No results for this request!");
                logger.error("Unsucessfull API call for city with id: " + CITY_ID);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        System.exit(0);


    }
}

