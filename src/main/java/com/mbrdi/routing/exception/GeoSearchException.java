package com.mbrdi.routing.exception;

public class GeoSearchException extends RuntimeException {

  public GeoSearchException(){
    super();
  }

  public GeoSearchException(String message){
    super(message);
  }

  public GeoSearchException(String message,Throwable throwable){
    super(message,throwable);
  }
}
