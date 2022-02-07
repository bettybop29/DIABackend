import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClass {
    public MainClass() {
    }

    public static void main(String[] args) {
        ArrayList<DigiJobs> digiJobs = new ArrayList();
        Scanner sc = new Scanner(System.in);

        //Menu Utama
        while(true) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("==============DigiJobs==============");
            System.out.println("Please choose following command : ");
            System.out.println("1. Add new job");
            System.out.println("2. Print all jobs");
            System.out.println("3. Delete job");
            System.out.println("4. Exit");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("4")) {
                return;
            }
            //input job id,job,addres
            String jobId;
            if (input.equalsIgnoreCase("1")) {
                System.out.println("Please input new job using following format : [job_id], [job_address], [job_position_id], [job_position_name]");
                jobId = sc.nextLine();
                //split dengan ,
                String[] split = jobId.split(",");
                //jika command 4 maka return and stop loop
                if (split.length == 4) {
                    DigiJobs newJob = new DigiJobs();
                    newJob.setJobId(split[0]);
                    newJob.setJobAddress(split[1]);
                    JobPosition jobPosition = new JobPosition();
                    jobPosition.setJobPositionId(Integer.parseInt(split[2]));
                    jobPosition.setJobPositionName(split[3]);
                    newJob.setJobPosition(jobPosition);
                    digiJobs.add(newJob);
                    // else jika salah atau benar dalam input command
                    System.out.println("Success add new job");
                } else {
                    System.out.println("Wrong format");
                }
                //fungsi tampilin joblist dari input
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("Your current jobs : ");
                digiJobs.forEach((job) -> {
                    job.print();
                });
                //fungsi delete job
            } else if (input.equalsIgnoreCase("3")) {
                System.out.println("Please input job id to delete : ");
                jobId = sc.nextLine();
                List<DigiJobs> collect = (List)digiJobs.stream().filter((job) -> {
                    return job.getJobId().equalsIgnoreCase(jobId);
                }).collect(Collectors.toList());
                //jika kosong muncul pesan error not found
                if (collect.isEmpty()) {
                    System.out.println("Job with job id " + jobId + " not found");
                } else {
                    digiJobs.removeAll(collect);
                    System.out.println("Success delete job with job id " + jobId);
                }
            }
        }
    }
}
