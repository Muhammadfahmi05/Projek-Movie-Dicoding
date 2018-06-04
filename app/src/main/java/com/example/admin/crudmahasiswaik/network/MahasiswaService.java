package com.example.admin.crudmahasiswaik.network;

import com.example.admin.crudmahasiswaik.model.Mahasiswa;
import com.example.admin.crudmahasiswaik.model.MahasiswaResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MahasiswaService {
    @GET("mahasiswa")
    Call<MahasiswaResult> getMahasiswas();

    @GET("mahasiswa/{id}")
    Call<MahasiswaResult> getMahasiswa(@Path("id")int id);

    @POST("mahasiswa")
    Call<String> setMahasiswa(@Body Mahasiswa mahasiswa);

    //put nanti dulu

    @DELETE("mahasiswa/{id}")
    Call<String> hapusMahasiswa (@Path("id")int id);
}
