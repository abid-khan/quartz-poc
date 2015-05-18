package com.abid.quartz.helper;

import com.abid.quartz.request.CronRequest;
import com.abid.quartz.request.JobRequest;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * Created by abidk on 29/04/15.
 */
@Component
public class SchedulerHelper {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleCronJob(JobDetail job, Trigger trigger) throws SchedulerException {

        schedulerFactoryBean.getScheduler().scheduleJob(job, trigger);
    }

    public void scheduleCronJob(Trigger trigger) throws SchedulerException {

        schedulerFactoryBean.getScheduler().scheduleJob(trigger);
    }

    public void unScheduleJob(JobDetail job) throws SchedulerException {

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        if (!scheduler.checkExists(job.getKey())) {
            return;
        }
        scheduler.deleteJob(job.getKey());
    }


    public JobDetail createCronJob(JobRequest jobRequest) {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setDurability(jobRequest.isDurable());
        jobDetail.setName(jobRequest.getJobName());
        jobDetail.setGroup(jobRequest.getGroupName());
        jobDetail.setDescription(jobRequest.getDescription());
        jobDetail.setJobClass(jobRequest.getClassName());
        jobDetail.afterPropertiesSet();
        return jobDetail.getObject();
    }

    public CronTrigger createCronTrigger(CronRequest cronRequest) throws ParseException {
        CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
        cronTrigger.setJobDetail(cronRequest.getJob());
        cronTrigger.setStartDelay(0L);
        cronTrigger.setCronExpression(cronRequest.getCronExpression());
        cronTrigger.setName(cronRequest.getName());
        cronTrigger
                .setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
        cronTrigger.afterPropertiesSet();
        return cronTrigger.getObject();
    }

}
