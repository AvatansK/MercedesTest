package com.mbrdi.poi.exception;

public class POISearchException extends RuntimeException {

  public POISearchException(){
    super();
  }

  public POISearchException(String message){
    super(message);
  }

  public POISearchException(String message,Throwable throwable){
    super(message,throwable);
  }
}
