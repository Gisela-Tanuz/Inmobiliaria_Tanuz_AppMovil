package com.tanuz.inmobiliariatanuz.request;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tanuz.inmobiliariatanuz.modelo.Contrato;

import com.tanuz.inmobiliariatanuz.modelo.Inmueble;

import com.tanuz.inmobiliariatanuz.modelo.Inquilino;
import com.tanuz.inmobiliariatanuz.modelo.Pago;
import com.tanuz.inmobiliariatanuz.modelo.Propietario;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;


public class ApiRetroFit {
    private static final String URLBASE = "http://192.168.0.103:45455/api/";
    private static PostInterface postInterface;


    public static PostInterface getMyApiClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLBASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        postInterface = retrofit.create(PostInterface.class);

        return postInterface;
    }


    public static String recuperarToken(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("dato.dat", 0);
        Log.d("salida2",sharedPreferences.getString("token","Token no valido")+"");
        return sharedPreferences.getString("token", "Token no valido");
    }
    public interface PostInterface {

        @FormUrlEncoded
        @POST("Propietarios/login")
        Call<String> login(@Field("Email") String email, @Field("Clave") String clave);

        @GET("Propietarios")
        Call<Propietario> perfil(@Header("Authorization") String token);

        @PUT("Propietarios")
        Call<Propietario> editarPerfil(@Header("Authorization") String token, @Body Propietario p);

        @GET("Inmuebles/listaInm")
        Call<List<Inmueble>> listaInmuebles(@Header("Authorization") String token);


        @PUT("Inmuebles/{id}")
        Call<Inmueble> modificarEstado(@Header("Authorization") String token, @Path("id") int id );


         @GET("Contratos")
        Call<List<Contrato>> InmueblePorContratos(@Header("Authorization") String token);


         @GET("Pagos/listaPagos/{id}")
         Call<List<Pago>> listaDePagos(@Header("Authorization") String token,@Path("id") int id );
    }
}