package com.tochukwu.payoneerhomework;

import com.tochukwu.payoneerhomework.Repository.FakeRepository;
import com.tochukwu.payoneerhomework.data.Remote.APIService;
import com.tochukwu.payoneerhomework.data.Repository.PayoneerRepository;
import com.tochukwu.payoneerhomework.data.Repository.Repository;
import com.tochukwu.payoneerhomework.di.AppModule;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.testing.TestInstallIn;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@TestInstallIn(
        components = SingletonComponent.class,
        replaces = AppModule.class
)
public class HiltTestModule {

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



    @Provides
    PayoneerRepository provideDefaultShoppingRepository(APIService apiService){

        return (PayoneerRepository) new FakeRepository();
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
