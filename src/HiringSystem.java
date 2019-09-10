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
 * The main class
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class HiringSystem{
	

	static HiringTable newHT = new HiringTable();
	static Scanner keyboard = new Scanner(System.in);

	/**
	 * A method that asks the user for the name of the applicant.
	 * @return The name that the user enters.
	 */
	public static String askName() {
		System.out.print("Enter Applicant Name: ");
        String appName = keyboard.nextLine();
        return appName;
	}

	/**
	 * A method that asks the user for the college of the applicant.
	 * @return The college name that the user enters.
	 */
	public static String askCollege() {
		System.out.print("Enter Applicant College: ");
        String college = keyboard.nextLine();
        return college;
	}

	/**
	 * A method that asks the user for the companies(max of 3) that the applicant has worked at.
	 * @return The company name that the user enters.
	 */
	public static String[] askCompanies() {
		HiringTable HT = new HiringTable();
		String[] companies = new String[HT.getMaxCompanies()];
		for(int i = 0; i < HT.getMaxCompanies(); i++){
            System.out.print("Enter up to " + (HT.getMaxCompanies()-i) + " Companies: ");
            companies[i] = keyboard.nextLine();
            if(companies[i].equals("")){
                return companies;
            }
        }
		return companies;
	}

	/**
	 * A method that asks the user for the skills(max of 3) that the applicant has.
	 * @return The skills that the user enters.
	 */
	public static String[] askSkills() {
		HiringTable HT = new HiringTable();
		String[] skills = new String[HT.getMaxSkills()];
		for(int i = 0; i < HT.getMaxSkills(); i++){
            System.out.print("Enter up to " + (HT.getMaxSkills()-i) + " Skills: ");
            skills[i] = keyboard.nextLine();
            if(skills[i].equals("")){
                return skills;
            }
        }
		return skills;
	}

	/**
	 * A method that creates a new applicant by asking the user to enter all the attributes of the applicant.
	 * @return An applicant with the attributes the user specifies.
	 */
	public static Applicant addApp(){
		Applicant newApp = new Applicant();

		double GPA = 0;

        String appName = askName();
        newApp.setApplicantName(appName);
        System.out.print("Enter Applicant GPA: ");
		GPA = keyboard.nextDouble();
        keyboard.nextLine();
        do {
			try {
				newApp.setApplicantGPA(GPA);
			} catch (InputMismatchException e) {
				System.out.println("Input has to be an integer that is greater than or equal to 0 and less than or equal to 4");
				System.out.print("Please try again: ");
				GPA = keyboard.nextDouble();
				keyboard.nextLine();
			}
		}while(GPA < 0 || GPA > 4);
        String college = askCollege();
        newApp.setApplicantCollege(college);
        String[] companies = askCompanies();
        newApp.setCompanyName(companies);
        String[] skills = askSkills();
        newApp.setApplicantSkills(skills);
        
        return newApp;
	}

	/**
	 * A method that takes in an applicant and displays that applicant.
	 * @param app The applicant that needs to be displayed
	 */
	public static void displayApp(Applicant app) {
        
        String companyNames = "";
        String skills = "";

		int i = 0;

		while(i < 3 && !app.getCompanyName()[i].isEmpty()){
			companyNames += app.getCompanyName()[i];
			if(i < app.getCompanyName().length-1) {
				if(!(app.getCompanyName()[i+1].isEmpty())) {
					companyNames += ", ";
				}
			}
			i++;
		}

		i = 0;

		while(i < 3 && !app.getApplicantSkills()[i].isEmpty()){
			skills += app.getApplicantSkills()[i];
			if(i < app.getApplicantSkills().length-1) {
				if(!(app.getApplicantSkills()[i+1].isEmpty())) {
					skills += ", ";
				}
			}
			i++;

		}
		
		System.out.print("Applicant Name: " + app.getApplicantName() + "\nApplicant Applying From: "+ companyNames + 
	            "\nApplicant GPA: " + app.getApplicantGPA() + "\nApplicant College: " + app.getApplicantCollege() + 
	            "\nApplicant Skills: " + skills + "\n");
		
	}

	/**
	 * A method that prints the heading when ever applicants need to be displayed in a list.
	 */
	public static void printHeading() {
		System.out.println("Company Name                     Applicant       GPA        College          Skills");
    	System.out.println("--------------------------------------------------------------------------------------------------");
	}

	/**
	 * The main method of the program.
	 * @param args
	 * @throws FullTableException Indicates that no more applicants can be added to the table when it is full.
	 * @throws ApplicantNotFoundException Indicates that the applicant the user is looking for can not be found.
	 */
    public static void main(String[] args) throws FullTableException, ApplicantNotFoundException{
		HiringTable HTab = new HiringTable();

		System.out.print("(A)   Add Applicant\n" +
				"(R)   Remove Applicant\n" +
				"(G)   Get Applicant\n" +
				"(P)   Print List\n" +
				"(RS)  Refine Search\n" +
				"(S)   Size\n" +
				"(B)   Backup\n" +
				"(CB)  Compare Backup\n" +
				"(RB)  Revert Backup\n" +
				"(Q)   Quit");

        System.out.print("\n\nPlease enter a command: ");
        String option = keyboard.nextLine();
        
        
        while(!(option.equals("Q") || (option.equals("q")))){
        	switch(option.toLowerCase()){
	            case "a":
	            	Applicant app = new Applicant();
	            	app = addApp();
	            	if(app.getCompanyName()[0].equals("") || app.getApplicantSkills()[0].equals("")) {
						System.out.println("You can't apply without any previous experience/skills");
						break;
					}
	            	else if(app.getApplicantName().equals("")){
	            		System.out.println("You can not apply without entering a name.");
	            		break;
					}
					try{
						HTab.addApplicant(app);
					}
					catch(FullTableException e){
						System.out.println(e.getMessage());
					}
	            break;  
	            case "r":
	                String name = askName();
	                try{
	                	HTab.removeApplicant(name);
					}
	                catch(ApplicantNotFoundException e){
	                	System.out.println(e.getMessage());
					}
	            break;
	            case "g":
	                String name1 = askName();
	                try{
	                	displayApp(HTab.getApplicant(name1));
					}
					catch(ApplicantNotFoundException e){
						System.out.println(e.getMessage());
					}
	            break;
	            case "p":
	            	HTab.printApplicantTable();
	            break;
	            case "rs":
	                printHeading();
	            	System.out.print("Enter a company to filter for: ");
	            	String comp = keyboard.nextLine();
	            	System.out.print("Enter a skill to filter for: ");
	            	String skil = keyboard.nextLine();
	            	System.out.print("Enter a college to filter for: ");
	            	String col = keyboard.nextLine();
					System.out.print("Enter the minimum GPA to filter for: ");
					String gpa = keyboard.nextLine();
					if(gpa.equals(""))
					{
						gpa = "0.0";
					}
					double GPA = Double.parseDouble(gpa);
	            	HTab.refineSearch(HTab, comp, skil, col, GPA);

	            break;
	            case "s":
	            	System.out.println("There are " + HTab.size() + " applicants in the hiring system.");
	            break;
	            case "b":
	            	newHT = HTab.clone();
	            	System.out.println("Successfully created backup.");
	            break;
	            case "cb":
	            	boolean eq = HTab.checkBackUp(newHT);
	            	if(eq == true) {
	            		System.out.println("Current list is the same as the backup copy.");
	            	}
	            	else {
	            		System.out.println("Current list is not the same as the backup copy.");
	            	}
	            break;
	            case "rb":
	            	HTab = newHT.clone();
	            	System.out.println("Successfully reverted to the backup copy.");
	            break;
	            default:
	            	System.out.println("Invalid command!");
	            break; 
	        }

			System.out.print("\n(A)   Add Applicant\n" +
					"(R)   Remove Applicant\n" +
					"(G)   Get Applicant\n" +
					"(P)   Print List\n" +
					"(RS)  Refine Search\n" +
					"(S)   Size\n" +
					"(B)   Backup\n" +
					"(CB)  Compare Backup\n" +
					"(RB)  Revert Backup\n" +
					"(Q)   Quit");

        	System.out.print("\n\nPlease enter a command: ");
            option = keyboard.nextLine();
            
        }
        System.out.println("Quitting program...");
    }
}