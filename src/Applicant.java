/**
 * @author Sai Kalagotla
 * ID: 113033883
 * Recotation section: R07
 * Professor Esmaili
 * 9/2/2019
 *
 * Homework #1
 * CSE 214
 * Fall 2019
 *
 * An abstract data type that represents an applicant and there
 * properties. Contains methods to manipulate the data stored in
 * each member variable.
 */

public class Applicant{
    private String[] companyName;
    private String applicantName;
    private double applicantGPA;
    private String applicantCollege;
    private String[] applicantSkills;

    /**
     * Default constructor
     */
    public Applicant() {

    }

    /**
     * Overloaded constructor that sets the attributes of the applicant
     * @param companyName Applicant's company names.
     * @param applicantName Applicant's name.
     * @param applicantGPA Applicant's GPA.
     * @param applicantCollege Applicant's college.
     * @param applicantSkills Applicant's skills.
     */
    public Applicant(String[] companyName, String applicantName, double applicantGPA,
    		String applicantCollege, String[] applicantSkills){
        this.companyName = companyName;
        this.applicantName = applicantName;
        this.applicantGPA = applicantGPA;
        this.applicantCollege = applicantCollege;
        this.applicantSkills = applicantSkills;
    }

    /**
     * A method that sets the name of the applicants company.
     * @param companyName The applicants company name that needs to be set.
     * @throws IllegalArgumentException Indicates if the value entered is invalid.
     */
    public void setCompanyName(String[] companyName){
    	try{
    		this.companyName = companyName;
    	}
    	catch(IllegalArgumentException e) {
            System.out.println("The input is not valid");
        }
    }

    /**
     * A method that sets the name of the applicant.
     * @param applicantName The applicants name that needs to be set.
     * @throws IllegalArgumentException Indicates if the value entered is invalid.
     */
    public void setApplicantName(String applicantName){
        try{
        	this.applicantName = applicantName;
        }
        catch(IllegalArgumentException e) {
        	System.out.println(e.getMessage());
        }
    }

    /**
     * A method that sets the GPA of the applicant.
     * @param applicantGPA The applicants GPA that needs to be set.
     * @throws IllegalArgumentException Indicates if the value entered is invalid.
     */
    public void setApplicantGPA(double applicantGPA){
        if(applicantGPA >= 0 && applicantGPA <= 4.0) {
        	this.applicantGPA = applicantGPA;
        }
        else {
        	throw new IllegalArgumentException("Value is invalid");
        }
    }

    /**
     * A method that sets the college of the applicant.
     * @param applicantCollege The applicants college that needs to be set.
     * @throws IllegalArgumentException Indicates if the value entered is invalid.
     */
    public void setApplicantCollege(String applicantCollege){
        try{
        	this.applicantCollege = applicantCollege;
        }
        catch(IllegalArgumentException e) {
        	System.out.println("The input is not valid");
        }
    }

    /**
     * A method that sets the skills of the applicant.
     * @param applicantSkills The applicants skills that needs to be set.
     * @throws IllegalArgumentException Indicates if the value entered is invalid.
     */
    public void setApplicantSkills(String[] applicantSkills){
        try{
        	this.applicantSkills = applicantSkills;
        }
        catch(IllegalArgumentException e) {
        	System.out.println("The input is not valid");
        }
    }

    /**
     * A method that returns the applicant's company names.
     * @return The applicant's company names.
     */
    public String[] getCompanyName(){
        return companyName;
    }

    /**
     * A method that returns the applicant's name.
     * @return The applicant's name.
     */
    public String getApplicantName(){
        return applicantName;
    }

    /**
     * A method that returns the applicant's GPA.
     * @return The applicant's GPA.
     */
    public double getApplicantGPA(){
        return applicantGPA;
    }

    /**
     * A method that returns the applicant's college.
     * @return The applicant's college.
     */
    public String getApplicantCollege(){
        return applicantCollege;
    }

    /**
     * A method that returns the applicant's skills.
     * @return The applicant's skills.
     */
    public String[] getApplicantSkills(){
        return applicantSkills;
    }

    /**
     * A method that makes a copy of the original applicant.
     * @return The cloned copy of the applicant
     */
    public Applicant clone(){
        Applicant newApp = new Applicant(companyName, applicantName, applicantGPA, applicantCollege, applicantSkills);

        return newApp;
    }

    /**
     * A method that checks if the original applicant is equal to the applicant
     * the user provides.
     * @param app The applicant that the user provides to check if the original is the same as the given applicant
     * @return If the applicant is the same or not
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

    /**
     * A method that returns a formatted string of the summary of the applicant
     * @return The formatted string of the summary of the applicant
     */
    public String toString(){
    	String compNames = "";
        String skills = "";

        int i = 0;

        while(i < companyName.length && !companyName[i].equals("")) {
            compNames += companyName[i];
            if (i < companyName.length - 1) {
                if (!(companyName[i + 1].isEmpty())) {
                    compNames += ", ";
                }
            }
            i++;
        }

        i = 0;

        while(i < applicantSkills.length && !applicantSkills[i].equals("")) {
            skills += applicantSkills[i];
            if (i < applicantSkills.length - 1) {
                if (!(applicantSkills[i + 1].isEmpty())) {
                    skills += ", ";
                }
            }
            i++;
        }
        
        String applicantSummary = String.format("%-33s%-16s%-11.2f%-17s%-3s", compNames, applicantName,
        		applicantGPA, applicantCollege, skills);
        
        return applicantSummary;
    }
}