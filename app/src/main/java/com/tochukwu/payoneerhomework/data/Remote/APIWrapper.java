package com.tochukwu.payoneerhomework.data.Remote;

public class APIWrapper <T>{
    private T data;
    private Throwable err;
    private int code;
    private Status status;

    public APIWrapper(T data, Throwable err, int code, Status status) {
        this.data = data;
        this.err = err;
        this.code = code;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Throwable getErr() {
        return err;
    }

    public void setErr(Throwable err) {
        this.err = err;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public enum Status {
        SUCCESS, FAILURE
    }
}
