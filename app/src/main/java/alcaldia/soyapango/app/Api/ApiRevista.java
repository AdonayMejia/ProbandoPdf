package alcaldia.soyapango.app.Api;

import alcaldia.soyapango.app.Interface.EventoSocialService;
import alcaldia.soyapango.app.Interface.RevistaService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRevista {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apiclinica.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }


    public static RevistaService getRevistaService(){
        RevistaService revistaService = getRetrofit().create(RevistaService.class);
        return revistaService;
    }

}
