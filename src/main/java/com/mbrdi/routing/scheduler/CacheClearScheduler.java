package com.mbrdi.routing.scheduler;

import java.sql.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheClearScheduler {

  private CacheManager cacheManager;

  @Autowired
  public CacheClearScheduler(CacheManager cacheManager){
    this.cacheManager=cacheManager;
  }

  @Scheduled(fixedRateString = "${cache.clear-time}")
  public void evictAllcachesAtIntervals() {
    log.info("Clearing poiCache according to given time period at {}",new Timestamp(System.currentTimeMillis()));
    cacheManager.getCache("poiCache").clear();
  }
}
