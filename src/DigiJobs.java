public class DigiJobs {
    private String jobId;
    private JobPosition jobPosition;
    private String jobAddress;

    public DigiJobs() {
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public JobPosition getJobPosition() {
        return this.jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobAddress() {
        return this.jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public void print() {
        String var10001 = this.jobId;
        System.out.println("Job Id : " + var10001 + ", job address " + this.jobAddress + ", job postion id : " + this.jobPosition.getJobPositionId() + ", job position name : " + this.jobPosition.getJobPositionName());
    }
}


