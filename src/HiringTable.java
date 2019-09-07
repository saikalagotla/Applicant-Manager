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

    HiringTable(){

    }
    
    public int getMaxSkills() {
    	return MAX_SKILLS;
    }
    
    public int getMaxCompanies() {
    	return MAX_COMPANIES;
    }

    public static void refineSearch(HiringTable table, String company, String skill, String college, double GPA){
    	int count = 0;
    	boolean comp = false;
    	boolean skil = false;
    	boolean col = false;
    	boolean gpa = false;
    	
    	while(table.data[count] != null) {
    		
    		if(company.equals("")) {
    			comp = true;
    		}
    		else {
	    		for(int i = 0; i < table.data[count].getCompanyName().length; i++) {
	    			if(table.data[count].getCompanyName()[i].equals(company)) {
	    				comp = true;
	    				break;
	    			}
	    		}
    		}
    		
    		if(skill.equals("")) {
    			skil = true;
    		}
    		else {
	    		for(int x = 0; x < table.data[count].getApplicantSkills().length; x++) {
	    			if(table.data[count].getApplicantSkills()[x].equals(skill)) {
	    				skil = true;
	    				break;
	    			}
	    		}
    		}
    		
    		if(college.equals("")) {
    			col = true;
    		}
    		else if(table.data[count].getApplicantCollege().equals(college)) {
    			col = true;
    		}
    		
    		if(table.data[count].getApplicantGPA() >= GPA) {
    			gpa = true;
    		}
    		else if(GPA == 0) {
    			col = true;
    		}
    		
    		
    		if(comp == true && skil == true && col == true && gpa == true) {
    			System.out.println(table.data[count].toString());
    		}
    		count++;
    	}
    	
    }

    public int size(){
        int counter = 0;

        while(data[counter] != null){
            counter++;
        }

        return counter;
    }

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