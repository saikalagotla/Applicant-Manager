/*
 * Sai Kalagotla
 * 113033883
 * Professor Esmaili
 * 9/2/2019
 * 
 * Homework #1
 * CSE 214
 * Fall 2019
 * 
 * An abstract data type that stores at maximum 50 applicants.
 */

public class HiringTable{
    final static int MAX_SKILLS = 3;
    final static int MAX_COMPANIES = 3;
    final static int MAX_APPLICANTS = 50;
    private Applicant[] data = new Applicant[MAX_APPLICANTS];

	/**
	 * Default constructor
	 */
	HiringTable(){

    }

	/**
	 * A method that returns the max amount of skills an applicant can have
	 * @return
	 * 	The max amount of skills an applicant can have.
	 */
	public int getMaxSkills() {
    	return MAX_SKILLS;
    }

	/**
	 * A method that returns the max amount of companies an applicant can have
	 * @return
	 * 	The max amount of companies an applicant can have.
	 */
    public int getMaxCompanies() {
    	return MAX_COMPANIES;
    }

	/**
	 * A method that determines if an applicant meets the criteria a user is
	 * 	looking for and prints the applicants that satisfy the parameters
	 * @param table
	 * 	The table the method will be looking through for satisfactory applicants
	 * @param company
	 * 	The company the user is filtering for.
	 * @param skill
	 * 	The skill the user is filtering for.
	 * @param college
	 * 	The college the user is filtering for.
	 * @param GPA
	 * 	The GPA the user is filtering for.
	 */
    public static void refineSearch(HiringTable table, String company, String skill, String college, double GPA) {
		if (table.data[0] == null) {
			System.out.println("There are currently no applicants in the system.");
			return;
		}
		System.out.println("Company Name                     Applicant       GPA        College          Skills");
		System.out.println("--------------------------------------------------------------------------------------------------");
		for (int i = 0; i < table.data.length; i++) {

			boolean comp = false;
			boolean skil = false;
			boolean coll = false;
			boolean gpaa = false;

			for (int x = 0; x < table.data[i].getCompanyName().length; x++) {
				if (company.equals("") || table.data[i].getCompanyName()[x].equals(company)) {
					comp = true;
					break;
				}
				else{
					comp = false;
				}
			}

			for (int x = 0; x < table.data[i].getApplicantSkills().length; x++) {
				if (skill.equals("") || table.data[i].getApplicantSkills()[x].equals(skill)) {
					skil = true;
					break;
				}
				else{
					skil = false;
				}
			}

			if (college.equals("") || college.equals(table.data[i].getApplicantCollege())) {
				coll = true;
			}
			else {
				coll = false;
			}

			if(GPA == 0.0 || GPA <= table.data[i].getApplicantGPA()){
				gpaa = true;
			}
			else{
				gpaa = false;
			}

			if (comp == true && skil == true && coll == true && gpaa == true) {
				System.out.println(table.data[i].toString());
			}

			if (table.data[i + 1] == null) {
				break;
			}
		}
	}

	/**
	 * A method that returns the size of the table
	 * @return
	 * 	The size of the table.
	 */
    public int size(){
        int counter = 0;

        while(data[counter] != null){
            counter++;
        }

        return counter;
    }

	/**
	 * A method that adds an applicant to the table.
	 * @param newApplicant
	 * 	The applicant that needs to be added to the table.
	 * @throws FullTableException
	 * 	Indicates if the table is full and no new applicants can be added.
	 */
	public void addApplicant(Applicant newApplicant) throws FullTableException{
        int i = 0;
        if(data[data.length-1] != null) {
        	throw new FullTableException();
        }
        else {
	        while(i < 50) {
	        	if(data[i] == null) {
	        		data[i] = newApplicant;
	        		System.out.println("Applicant " + newApplicant.getApplicantName() + " has been successfully added to the hiring system.");
	        		return;
	        	}
	        	else{
	        		i++;
	        	}
	        }
        }
    }

	/**
	 * A method that removes an applicant from the table.
	 * @param name
	 * 	The name of the applicant that needs to be removed from the table.
	 * @throws ApplicantNotFoundException
	 * 	Indicates that the applicant the user is looking for does not exist.
	 */
	public void removeApplicant(String name) throws ApplicantNotFoundException{
        int count = 0;
    	while(!(data[count].getApplicantName().equals(name))) {
    		count++;
    	}
    	
    	if(data[count].getApplicantName().equals(name)) {
    		while(data[count+1] != null) {
    			data[count] = data[count+1];
    			count++;
    		}
    		data[count] = null;
    		System.out.println("Applicant " + name + " has been successfully removed from the hiring system.");
    		return;
    	}
    	throw new ApplicantNotFoundException();
    }

	/**
	 * A method that returns the applicant the user is looking for.
	 * @param name
	 * 	The name of the applicant the user is looking for.
	 * @return
	 * 	The applicant the user is looking for
	 * @throws ApplicantNotFoundException
	 * 	Indicates that the applicant the user is looking for could not be found.
	 */
    public Applicant getApplicant(String name) throws ApplicantNotFoundException{
        
    	for(int i = 0; i < data.length; i++) {
        	if(data[i] != null) {
        		if(data[i].getApplicantName().equals(name)) {
        			return data[i];
        		}
        	}
        }
        throw new ApplicantNotFoundException();
        
    }

	/**
	 * A method that makes a copy of the original hiring table.
	 * @return
	 * 	A copy of the original hiring table.
	 */
	public HiringTable clone(){
        HiringTable ht = new HiringTable();
        int i = 0;
        
        while(data[i] != null) {
        	ht.data[i] = new Applicant();
        	ht.data[i].setApplicantName(data[i].getApplicantName());
        	ht.data[i].setApplicantCollege(data[i].getApplicantCollege());
        	ht.data[i].setApplicantGPA(data[i].getApplicantGPA());
        	ht.data[i].setApplicantSkills(data[i].getApplicantSkills());
        	ht.data[i].setCompanyName(data[i].getCompanyName());
        	
        	i++;
        }

        return ht;
    }

	/**
	 * A method that prints all the applicants in the table.
	 */
	public void printApplicantTable(){
    	int count = 0;
        
    	if(data[0] == null) {
    		System.out.println("There are currently no applicants in the system.");
    	}
    	else {
    		System.out.println("Company Name                     Applicant       GPA        College          Skills");
        	System.out.println("--------------------------------------------------------------------------------------------------");
	    	while(data[count] != null) {
	    		System.out.println(data[count].toString());
	    		count++;
	    	}
    	}
    }

	/**
	 * A method that checks to see if the copy of the hiring table is the same as the
	 * original hiring table.
	 * @param newHT
	 * 	The back up hiring table that needs to be checked with the original..
	 * @return
	 * 	Indicates if the copy is the same or different from the original.
	 */
	public boolean checkBackUp(HiringTable newHT) {
    	boolean eq = false;
    	if(this.size() == newHT.size()) {
    		for(int x = 0; x < this.size(); x++) {
        		if(data[x].equals(newHT.data[x]) == true) {
        			eq = true;
        		}
        		else {
        			return false;
        		}
        	}
    		if(eq = true) {
    			return eq;
    		}
    		else {
    			return false;
    		}
		}
    	return eq;
    }

}