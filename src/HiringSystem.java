import java.util.Scanner;

public class HiringSystem{
	
	static HiringTable HTab = new HiringTable();
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
		String[] companies = new String[3];
		for(int i = 0; i < 3; i++){
            System.out.print("Enter up to " + (3-i) + " Companies: ");
            companies[i] = keyboard.nextLine();
            if(companies[i] == null){
                break;
            }
        }
		return companies;
	}
	
	public static String[] askSkills() {
		String[] skills = new String[3];
		for(int i = 0; i < 3; i++){
            System.out.print("Enter up to " + (3-i) + " Skills: ");
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
		String[] compNames = app.getCompanyName();
        String[] appSkills = app.getApplicantSkills();
        
        String companyNames = "";
        String skills = "";

        int count = 0;
        
        while(compNames[count] != null) {
        	companyNames += compNames[count] + ", ";
        	count++;
        }
        count = 0;
        
        while(appSkills[count] != null) {
        	skills += appSkills[count] + ", ";
        	count++;
        }
		
		System.out.print("\nApplicant Name: " + app.getApplicantName() + "\nApplicant Applying From: "+ companyNames + 
	            "\nApplicant GPA: " + app.getApplicantGPA() + "\nApplicant College: " + app.getApplicantCollege() + 
	            "\nApplicant Skills: " + skills + "\n");
		
	}
	
    public static void main(String[] args) throws FullTableException, ApplicantNotFoundException{
        
    	
        System.out.print("Please enter a command: ");
        String option = keyboard.nextLine();
        
        
        do {
        	switch(option){
	            case "A":
	            	Applicant app = new Applicant();
	            	app = addApp();
	            	HTab.addApplicant(app);
	                System.out.println("Applicant " + app.getApplicantName() + " has been successfully added to the hiring system.");
	            break;  
	            case "R":
	                String name = askName();
	                HTab.removeApplicant(name);
	            break;
	            case "G":
	                String name1 = askName();
	                System.out.println(HTab.getApplicant(name1).toString());
	            break;
	            case "P":
	            	
	            break;
	            case "RS":
	            	System.out.print("Enter a company to filter for: ");
	            	String comp = keyboard.nextLine();
	            	System.out.print("Enter a skill to filter for: ");
	            	String skil = keyboard.nextLine();
	            	System.out.print("Enter a college to filter for: ");
	            	String col = keyboard.nextLine();
	            	System.out.print("Enter the minimum GPA to filter for: ");
	            	double GPA1 = keyboard.nextDouble();
	            	HTab.refineSearch(HTab, comp, skil, col, GPA1);
	            break;
	            case "S":
	            	System.out.println("There are " + HTab.size() + " applicants in the hiring system.");
	            break;
	            case "B":
	            break;
	            case "CB":
	            break;
	            case "RB":
	            break;
	            default:
	            	//throw an error
	            break; 
	        }
        	System.out.print("Please enter a command: ");
            option = keyboard.nextLine();
        }while(option != "Q");

    }
}