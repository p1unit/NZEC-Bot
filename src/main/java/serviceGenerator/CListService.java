package serviceGenerator;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import resources.ResourcesValues;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CListService {

    private static Retrofit.Builder builder
            = new Retrofit.Builder()
            .baseUrl(ResourcesValues.BASE_URL + ResourcesValues.API_VERSION)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient
            = new OkHttpClient.Builder();

    private static HttpLoggingInterceptor logging
            = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC);

    public static <S> S createService(Class<S> serviceClass) {
        httpClient.interceptors().clear();
        httpClient.addInterceptor( chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Authorization",ResourcesValues.API_TOKEN)
                    .build();
            return chain.proceed(request);
        });
        httpClient.addInterceptor(logging);
        builder.client(httpClient.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

}