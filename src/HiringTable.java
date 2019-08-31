public class HiringTable{
    final static int MAX_SKILLS = 3;
    final static int MAX_COMPANIES = 3;
    final static int MAX_APPLICANTS = 50;
    Applicant[] data = new Applicant[MAX_APPLICANTS];

    HiringTable(){

    }

    public static void refineSearch(HiringTable table, String company, String skill, String college, double GPA){
    	int count = 0;
    	while(table.data[count] != null) {
    		String[] compName = table.data[count].getCompanyName();
    		String[] skil = table.data[count].getApplicantSkills();
    		
    		for(int i = 0; i < 3; i++) {
    			if(compName[i] == company) {
    				for(int x = 0; x < 3; x++) {
    					if(skil[x] == skill) {
    						if(table.data[count].getApplicantCollege() == college) {
    							if(table.data[count].getApplicantGPA() == GPA) {
    								table.data[count].toString();
    							}
    						}
    					}
    				}
    			}
    		}
    		
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
        if(data[49] != null) {
        	throw new FullTableException();
        }
        else {
	        while(i < 50) {
	        	if(data[i] == null) {
	        		data[i] = newApplicant;
	        		break;
	        	}
	        	else{
	        		i++;
	        	}
	        }
        }
        
    }

    public void removeApplicant(String name) throws ApplicantNotFoundException{
        for(int i = 0; i < 50; i++) {
        	if(data[i].getApplicantName() == name) {
        		while(data[i+1] != null) {
        			data[i] = data[i+1];
        		}
        		break;
        	}
        	else if(data[i] == null) {
        		throw new ApplicantNotFoundException();
        	} 
        }
    }

    public Applicant getApplicant(String name) throws ApplicantNotFoundException{
        
        Applicant newApp = new Applicant();
        
        for(int i = 0; i < 50; i++) {
        	if(data[i].getApplicantName() == "Bob") {
        		throw new ApplicantNotFoundException();
        	}
        	else if(data[i].getApplicantName() == name) {
        		newApp = data[i];
        		break;
        	}
        }
        
        if(newApp.getApplicantName() == name) {
        	return newApp;
        }
        else {
        	throw new ApplicantNotFoundException();
        }
    }

    public HiringTable clone(){
        HiringTable ht = new HiringTable();
        ht.data = data;

        return ht;
    }

    public void printApplicantTable(){
        
    }
}