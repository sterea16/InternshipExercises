package com.example.internshipExercises.server;

import com.example.internshipExercises.model.post.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getPosts();
}
