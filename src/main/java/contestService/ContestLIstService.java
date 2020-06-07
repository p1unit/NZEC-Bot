package contestService;

import model.ContestList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public interface ContestLIstService {

    @GET("contest/")
    Call<ContestList> getContests(
            @Query("resource__name") String resource,
            @Query("start__gte") LocalDateTime startDate,
            @Query("start__lt") LocalDateTime endDate,
            @Query("order_by") String orderBy);
}