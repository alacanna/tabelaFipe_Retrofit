package br.com.tabelafipe.repository;


import br.com.tabelafipe.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {

        return  new Retrofit.Builder()
                .baseUrl(BuildConfig.REST_SERVICE_URL)
                .client(new OkHttpClient().newBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(serviceClass);

    }

}
