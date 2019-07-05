package com.yuong.library_base.retrofit;


import com.yuong.library_base.bean.ActorsDetailBean;
import com.yuong.library_base.bean.ComingBean;
import com.yuong.library_base.bean.HotMovieBean;
import com.yuong.library_base.bean.ImageAllBean;
import com.yuong.library_base.bean.MovieCreditsWithTypeBean;
import com.yuong.library_base.bean.MovieDetailBean;
import com.yuong.library_base.bean.TicketBean;
import com.yuong.library_base.bean.VideoBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetData {
    @GET("Movie/MovieComingNew.api?")
    Observable<ComingBean> getComingData(@Query("locationId") String locationId);

    @GET("movie/detail.api?")
    Observable<MovieDetailBean> getMovieDetailData(@Query("locationId") String locationId, @Query("movieId") String movieId);

    @GET("Movie/MovieCreditsWithTypes.api?")
    Observable<MovieCreditsWithTypeBean> getMovieCreditsWithTypes(@Query("movieId") String movieId);

    @GET("person/detail.api?")
    Observable<ActorsDetailBean> getActorsDetail(@Query("personId") String personId, @Query("cityId") String cityId);

    @GET("Movie/ImageAll.api?")
    Observable<ImageAllBean> getImageAll(@Query("movieId") String movieId);

    @GET("Movie/Video.api?")
    Observable<VideoBean> getVideo(@Query("pageIndex") int pageIndex, @Query("movieId") int movieId);

    @GET("Showtime/LocationMovies.api?")
    Observable<HotMovieBean> getHotMovieData(@Query("locationId") int locationId);

    @GET("PageSubArea/HotPlayMovies.api?")
    Observable<TicketBean> getTicketData(@Query("locationId") int locationId);



}
