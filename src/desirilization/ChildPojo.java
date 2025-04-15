package desirilization;

import java.util.List;

public class ChildPojo {
	private List<SubChildWebAutoamtion>  webAutomation;
	private List<SubChildApi> api;
	private List<SubChildMobile> mobile; 
	public List<SubChildWebAutoamtion> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<SubChildWebAutoamtion> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<SubChildApi> getApi() {
		return api;
	}
	public void setApi(List<SubChildApi> api) {
		this.api = api;
	}
	public List<SubChildMobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<SubChildMobile> mobile) {
		this.mobile = mobile;
	}
	
	
}
