package desirilization;

public class MainPojoClass {
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private ChildPojo courses;
	private String linkedIn;
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public ChildPojo getCourses() {
		return courses;
	}
	public void setCourses(ChildPojo courses) {
		this.courses = courses;
	}
	public String getlinkedIn() {
		return linkedIn;
	}
	public void setlinkedIn(String linklind) {
		this.linkedIn = linklind;
	}
	
	

}
