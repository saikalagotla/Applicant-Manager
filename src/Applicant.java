public class Applicant{
    String[] companyName;
    String applicantName;
    double applicantGPA;
    String applicantCollege;
    String[] applicantSkills;

    public Applicant(){
    	applicantName = "Bob";
    }

    public Applicant(String[] companyName, String applicantName, double applicantGPA,
    		String applicantCollege, String[] applicantSkills){
        this.companyName = companyName;
        this.applicantName = applicantName;
        this.applicantGPA = applicantGPA;
        this.applicantCollege = applicantCollege;
        this.applicantSkills = applicantSkills;
    }

    public void setCompanyName(String[] companyName){
    	try{
    		this.companyName = companyName;
    	}
    	catch(IllegalArgumentException e) {
    		System.out.println("The input is not valid");
    	}
    	catch(ArrayIndexOutOfBoundsException e) {
    		System.out.println("The array is too large");
    	}
    }

    public void setApplicantName(String applicantName){
        try{
        	this.applicantName = applicantName;
        }
        catch(IllegalArgumentException e) {
        	System.out.println("The input is not valid");
        }
    }

    public void setApplicantGPA(double applicantGPA){
        if(applicantGPA >= 0 && applicantGPA <= 4.0) {
        	this.applicantGPA = applicantGPA;
        }
        else {
        	throw new IllegalArgumentException("Value is invalid");
        }
    }

    public void setApplicantCollege(String applicantCollege){
        try{
        	this.applicantCollege = applicantCollege;
        }
        catch(IllegalArgumentException e) {
        	System.out.println("The input is not valid");
        }
    }

    public void setApplicantSkills(String[] applicantSkills){
        try{
        	this.applicantSkills = applicantSkills;
        }
        catch(IllegalArgumentException e) {
        	System.out.println("The input is not valid");
        }
        catch(ArrayIndexOutOfBoundsException e) {
        	System.out.println("The array is too large");
        }
    }

    public String[] getCompanyName(){
        return companyName;
    }

    public String getApplicantName(){
        return applicantName;
    }

    public double getApplicantGPA(){
        return applicantGPA;
    }

    public String getApplicantCollege(){
        return applicantCollege;
    }

    public String[] getApplicantSkills(){
        return applicantSkills;
    }

    public Applicant clone(){
        Applicant newApp = new Applicant(companyName, applicantName, applicantGPA, applicantCollege, applicantSkills);

        return newApp;
    }

    /*
     * Ask if this is right
     */
    public boolean equals(Applicant app){
        if(companyName == app.getCompanyName() && applicantGPA == app.getApplicantGPA() && 
        		applicantCollege == app.getApplicantCollege() && applicantSkills == app.getApplicantSkills()){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
    	String compNames = "";
        String skills = "";

        for(int i = 0; i < 3; i++) {
        	if(companyName[i] != null) {
        		compNames += companyName[i] + ", ";
        	}
        	else {
        		break;
        	}
        }
        
        for(int x = 0; x < 3; x++) {
        	if(applicantSkills[x] != null) {
        		skills += applicantSkills[x] + ", ";
        	}
        	else {
        		break;
        	}
        }
        
        String applicantSummary = compNames + "   " + applicantName + "   " + applicantGPA + "   " + applicantCollege + "   " + skills;
        
        return applicantSummary;
    }
}