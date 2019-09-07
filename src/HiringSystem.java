/*
 * Sai Kalagotla
 * 113033883
 * Professor Esmaili
 * 9/2/2019
 * 
 * Homework #1
 * CSE 214
 * Fall 2019
 */

import java.util.Scanner;

public class HiringSystem{
	
	static HiringTable HTab = new HiringTable();
	static HiringTable newHT = new HiringTable();
	static Scanner keyboard = new Scanner(System.in);
	
	public static String askName() {
		System.out.print("Enter Applicant Name: ");
        String appName = keyboard.nextLine();
        return appName;
	}
	
	public static String askCollege() {
		System.out.print("Enter Applicant College: ");
        String college = keyboard.nextLine();
        return college;
	}
	
	public static String[] askCompanies() {
		HiringTable HT = new HiringTable();
		String[] companies = new String[HT.getMaxCompanies()];
		for(int i = 0; i < HT.getMaxCompanies(); i++){
            System.out.print("Enter up to " + (HT.getMaxCompanies()-i) + " Companies: ");
            companies[i] = keyboard.nextLine();
            if(companies[i] == null){
                return companies;
            }
        }
		return companies;
	}
	
	public static String[] askSkills() {
		HiringTable HT = new HiringTable();
		String[] skills = new String[HT.getMaxSkills()];
		for(int i = 0; i < HT.getMaxSkills(); i++){
            System.out.print("Enter up to " + (HT.getMaxSkills()-i) + " Skills: ");
            skills[i] = keyboard.nextLine();
            if(skills[i] == null){
                break;
            }
        }
		return skills;
	}
	
	public static Applicant addApp() throws FullTableException{
		Applicant newApp = new Applicant();
    	
        String appName = askName();
        newApp.setApplicantName(appName);
        System.out.print("Enter Applicant GPA: ");
        double GPA = keyboard.nextDouble();
        keyboard.nextLine();
        newApp.setApplicantGPA(GPA);
        String college = askCollege();
        newApp.setApplicantCollege(college);
        String[] companies = askCompanies();
        newApp.setCompanyName(companies);
        String[] skills = askSkills();
        newApp.setApplicantSkills(skills);
        
        return newApp;
	}
	
	public static void displayApp(Applicant app) {
        
        String companyNames = "";
        String skills = "";

        
        for(int i = 0; i < app.getCompanyName().length; i++) {
        	if(app.getCompanyName()[i] != null) {
        		companyNames += app.getCompanyName()[i];
        		if(i < app.getCompanyName().length-1) {
        			companyNames += ", ";
        		}
        	}
        	else {
        		break;
        	}
        }
        
        for(int x = 0; x < app.getApplicantSkills().length; x++) {
        	if(app.getApplicantSkills()[x] != null) {
        		skills += app.getApplicantSkills()[x];
        		if(x < app.getApplicantSkills().length-1) {
        			skills += ", ";
        		}
        	}
        	else {
        		break;
        	}
        }
		
		System.out.print("Applicant Name: " + app.getApplicantName() + "\nApplicant Applying From: "+ companyNames + 
	            "\nApplicant GPA: " + app.getApplicantGPA() + "\nApplicant College: " + app.getApplicantCollege() + 
	            "\nApplicant Skills: " + skills + "\n");
		
	}
	
	public static void printHeading() {
		System.out.println("Company Name                     Applicant       GPA        College          Skills");
    	System.out.println("--------------------------------------------------------------------------------------------------");
	}
	
    public static void main(String[] args) throws FullTableException, ApplicantNotFoundException{
        
    	System.out.print("(A)   Add Applicant\r\n" + 
    			"(R)   Remove Applicant\r\n" + 
    			"(G)   Get Applicant\r\n" + 
    			"(P)   Print List\r\n" + 
    			"(RS)  Refine Search\r\n" +
    			"(S)   Size\r\n" +
    			"(B)   Backup\r\n" + 
    			"(CB)  Compare Backup\r\n" + 
    			"(RB)  Revert Backup\r\n" + 
    			"(Q)   Quit");
        System.out.print("\n\nPlease enter a command: ");
        String option = keyboard.nextLine();
        
        
        while(!(option.equals("Q"))){
        	switch(option){
	            case "A":
	            	Applicant app = new Applicant();
	            	app = addApp();
	            	HTab.addApplicant(app);
	            break;  
	            case "R":
	                String name = askName();
	                HTab.removeApplicant(name);
	            break;
	            case "G":
	                String name1 = askName();
	                displayApp(HTab.getApplicant(name1));
	            break;
	            case "P":
	            	HTab.printApplicantTable();
	            break;
	            case "RS":
	            	System.out.print("Enter a company to filter for: ");
	            	String comp = keyboard.nextLine();
	            	System.out.print("Enter a skill to filter for: ");
	            	String skil = keyboard.nextLine();
	            	System.out.print("Enter a college to filter for: ");
	            	String col = keyboard.nextLine();
	            	System.out.print("Enter the minimum GPA to filter for: ");
	            	double GPA = keyboard.nextDouble();
	            	printHeading();
	            	HTab.refineSearch(HTab, comp, skil, col, GPA);
	            break;
	            case "S":
	            	System.out.println("There are " + HTab.size() + " applicants in the hiring system.");
	            break;
	            case "B":
	            	newHT = HTab.clone();
	            	System.out.println("Successfully created backup.");
	            break;
	            case "CB":
	            	boolean eq = HTab.checkBackUp(newHT);
	            	if(eq == true) {
	            		System.out.println("Current list is the same as the backup copy.");
	            	}
	            	else {
	            		System.out.println("Current list is not the same as the backup copy.");
	            	}
	            break;
	            case "RB":
	            	HTab = newHT.clone();
	            	System.out.println("Successfully reverted to the backup copy.");
	            break;
	            default:
	            	System.out.println("Invalid command!");
	            break; 
	        }
        	
        	System.out.print("Please enter a command: ");
            option = keyboard.nextLine();
            
        }
        System.out.println("Quitting program...");
    }
}