package com.tripaction_interview_assignment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsFeedsService {
    String API_KEY = "OKsEwghCzAPR3kRr7Hp51cFn2tMfXWgj";
    String API_BASE_URL = "https://api.nytimes.com/svc/search/v2/";
        @GET("/articlesearch.json")
        Call<ApiResponse> query(
                @Query("q") String query,
                @Query("fq") String filteredQuery,
                @Query("begin_date") String beginDate,
                @Query("end_date") String endDate,
                @Query("sort") String sort,
                @Query("page") Integer page);


}
