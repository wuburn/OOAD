public class Project {
    private String projectId;
    private String projectName;
    private String student;
    private String lecturer;
    private String comment;
    private String specialization;
    private Boolean active;

    public Project(String projectName){
        this.projectName = projectName;
        this.active = false;
    }

    public Project(String projectId, String projectName, String student, String lecturer, String comment,
        String specialization, Boolean active) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.student = student;
        this.lecturer = lecturer;
        this.comment = comment;
        this.specialization = specialization;
        this.active = active;
    }

    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStudent() {
        return student;
    }
    public void setStudent(String student) {
        this.student = student;
    }

    public String getLecturer() {
        return lecturer;
    }
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    


}

