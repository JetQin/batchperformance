package com.github.jetqin;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by jet on 16/5/18.
 */

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzJob extends QuartzJobBean {

    public  static  final String COUNT = "count";

    private String name;


    @Override
    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {

        JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
        int cnt = dataMap.getInt(COUNT);
        JobKey jobKey = ctx.getJobDetail().getKey();
        System.out.println(jobKey + ":"+name+":"+cnt);
        cnt++;
        dataMap.put(COUNT,cnt);
    }


    public void setName(String name) {
        this.name = name;
    }
}
