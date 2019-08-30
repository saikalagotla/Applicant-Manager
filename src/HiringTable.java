public class HiringTable{
    int MAX_SKILLS = 3;
    int MAX_COMPANIES = 3;
    int MAX_APPLICANTS = 50;
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
        for(int i = 0; i < 50; i++) {
        	if(data[i] == null) {
        		data[i] = newApplicant;
        		break;
        	}
        }
        System.out.println(data[0].toString());
    }

    public void removeApplicant(String name){
        int counter = 0;
        
        for(int i = 0; i < 50; i++){
            if(data[i] == null){
                //applicant not found error
            }
            else if(data[i].getApplicantName() == name){
                counter = i;
            }
        }

        while(data[counter +1] != null && counter < 50){
            data[counter] = data[counter+1];
            counter++;
        }

        data[counter+1] = null;
    }

    public Applicant getApplicant(String name) throws ApplicantNotFoundException{
        int count = 0;
        
        while(data[count].getApplicantName() != name) {
        	count++;
        	if(count > 49) {
        		throw new ApplicantNotFoundException();
        	}
        }
        if(data[count].getApplicantName() == name ) {
        	return data[count];
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