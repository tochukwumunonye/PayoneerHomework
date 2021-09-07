package com.tochukwu.payoneerhomework.di;

import com.tochukwu.payoneerhomework.data.Remote.APIService;
import com.tochukwu.payoneerhomework.data.Repository.PayoneerRepository;
import com.tochukwu.payoneerhomework.data.Repository.Repository;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public class AppModule {

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

    }




    @Singleton
    @Provides
    PayoneerRepository provideDefaultShoppingRepository(APIService apiService){

        return (PayoneerRepository) new Repository(apiService);
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okhttp) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://raw.githubusercontent.com/")
                .client(okhttp)
                .build();

    }

    @Singleton
    @Provides
    APIService providesAPIService(Retrofit retrofit) {
        return retrofit.create(APIService.class);
    }
}
