package com.example.lib.InterfaceRepository;

import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.ChiTietChoNgoi;
import com.example.lib.Model.Item;
import com.example.lib.Model.PhimModel;
import com.example.lib.Model.Theloai;
import com.example.lib.Model.User;
import com.example.lib.Model.Ve;

import java.util.List;

import javax.mail.internet.InternetAddress;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Methods {
    @GET("/api/Phim")
    Call<List<PhimModel>> getPhim();

    @GET("/api/ChiTietChieu/{id}")
    Call<ChiTietChieu> getIdChitietchieu(@Path("id") Integer chitiet);

    @GET("/api/ChiTietChieu")
    Call<List<ChiTietChieu>> getChitietChieu();

    @GET("/api/User/{username}/{password}")
    Call<User> getUser(@Path("username") String u, @Path("password") String p);

    @POST("/api/User")
    Call<String> postUser(@Body User user);

    @PUT("/api/User/{id}")
    Call<User> PutUser(@Path("id") Integer ID,  @Body User user);

    @POST("/api/Ve")
    Call<Integer> postVe(@Body Ve ve);

    @GET("/api/Ve")
    Call<List<Ve>> GetVe();

    @GET("/phong/{idPhong}")
    Call<List<ChiTietChoNgoi>> getChiTietChoNgoi(@Path("idPhong") Integer chitietngoi);

    @GET("api/ChiTietChoNgoi")
    Call<List<ChiTietChoNgoi>> getcn();
    @GET("/xuatchieu/{idChiTietChieu}")
    Call<List<Ve>> getVeChiTietChieu(@Path("idChiTietChieu") Integer idChiTietChieu);

    @PUT("/api/User/changePassword")
    Call<User> ChangePasswWord(@Query("id") Integer id, @Query("newPass") String newPassword);

    @DELETE("api/Ve/{id}")
    Call<Void> delete(@Path("id") int itemId);

    @GET("/api/User")
    Call<List<User>> GetUser();

    @GET("/api/Ve/{idChoNgoi}/{idChiTietChieu}")
    Call<Ve> getvechoNgoi(@Path("idChoNgoi") Integer IDChoNgoi, @Path("idChiTietChieu") Integer IDChiTietChieu);
}
