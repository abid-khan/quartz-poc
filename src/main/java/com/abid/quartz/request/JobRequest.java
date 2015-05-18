package com.abid.quartz.request;

/**
 * Created by abidk on 15/05/15.
 */
public class JobRequest {
    private String jobName;

    private String groupName;

    private String description;

    private boolean isDurable;

    private Class<?> className;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isDurable() {
        return isDurable;
    }

    public void setIsDurable(boolean isDurable) {
        this.isDurable = isDurable;
    }

    public String getJobName() {
        return jobName;
    }

    public Class<?> getClassName() {
        return className;
    }

    public void setClassName(Class<?> className) {
        this.className = className;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }


}
