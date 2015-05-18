package com.abid.quartz.request;

import org.quartz.JobDetail;

/**
 * Created by abidk on 15/05/15.
 */
public class CronRequest {

    private String name;
    private String cronExpression;
    private JobDetail job;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public JobDetail getJob() {
        return job;
    }

    public void setJob(JobDetail job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
