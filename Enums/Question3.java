public class Question3 {
    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    
    public static void main(String[] args) {
        Days today = Days.FRIDAY;
        
        if(today == Days.SATURDAY || today == Days.SUNDAY){
            System.out.println("Today is a weekend");
        }else{
            System.out.println("Today is a business day");
        }
    }
}
