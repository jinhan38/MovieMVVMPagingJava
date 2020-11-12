package com.example.moviemvvmpagingjava.repository;


enum Status{
    RUNNING,
    SUCCESS,
    FAILED
}
public class NetworkState {

    public static NetworkState LOADED;
    public static NetworkState LOADING;
    public static NetworkState ERROR;

    private Status status;
    private String msg;

    public NetworkState(Status status, String msg) {

        init();

    }

    void init(){
        LOADED = new NetworkState(Status.SUCCESS, "Success");
        LOADING = new NetworkState(Status.RUNNING, "Running");
        ERROR = new NetworkState(Status.FAILED, "Something went wrong");
    }
}
