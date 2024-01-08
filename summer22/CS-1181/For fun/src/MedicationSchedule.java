import java.util.ArrayList;

public class MedicationSchedule {
    
    public static void main(String[] args) {

        String[][] medsSchedule = new String[7][5];
        ArrayList<String> medications = new ArrayList<>();
        ArrayList<String> days = new ArrayList<>();

        daysOfWeek(days);
        listOfMeds(medications);

        for (int i = 0; i < medsSchedule.length; i++) {
            for (int j = 0; j < medsSchedule[i].length; j++) {
                
            }
        }

    }

    public static ArrayList<String> daysOfWeek(ArrayList<String> week) {

        String sunday = "Sunday";
        String monday = "Monday";
        String tuesday = "Tuesday";
        String wednesday = "Wednesday";
        String thursday = "Thursday";
        String friday = "Friday";
        String saturday = "Saturday";

        week.add(sunday);
        week.add(monday);
        week.add(tuesday);
        week.add(wednesday);
        week.add(thursday);
        week.add(friday);
        week.add(saturday);

        return week;
    }

    public static ArrayList<String> listOfMeds(ArrayList<String> meds) {
        
        String lamotrigine = "Lamictal";
        String bupropion = "Wellbutrin";
        String cariprazine = "Vraylar";
        String birthControl = "Junel Fe 1/20";

        meds.add(lamotrigine);
        meds.add(bupropion);
        meds.add(bupropion);
        meds.add(cariprazine);
        meds.add(birthControl);

        return meds;
    }
}
