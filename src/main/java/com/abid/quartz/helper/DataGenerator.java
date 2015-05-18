package com.abid.quartz.helper;

import com.abid.quartz.job.SampleJob;
import com.abid.quartz.request.CronRequest;
import com.abid.quartz.request.JobRequest;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by abidk on 15/05/15.
 */
@Component
public class DataGenerator {

    @Autowired
    private SchedulerHelper schedulerHelper;

    @PostConstruct
    public void createSampleJob() {

        try {
            JobRequest request = new JobRequest();
            request.setJobName("Test Job");
            request.setGroupName("Test Group");
            request.setDescription("This is a test job");
            request.setIsDurable(true);
            request.setClassName(SampleJob.class);
            JobDetail jobDetail = schedulerHelper.createCronJob(request);

            CronRequest cronRequest = new CronRequest();
            cronRequest.setName("Cron");
            cronRequest.setCronExpression("30 * * * * ?");
            cronRequest.setJob(jobDetail);
            CronTrigger cronTrigger = schedulerHelper.createCronTrigger(cronRequest);

            schedulerHelper.scheduleCronJob(jobDetail, cronTrigger);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
