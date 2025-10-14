package records;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Records {
    public String name;
    public Long balance;

    public Records(String name, Long balance){
        this.name = name;
        this.balance = balance;
    }

    public void addUserToRecord() {
        try (BufferedReader reader = new BufferedReader(new FileReader("records.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(this.name)) {
                    System.out.println("User already exists in the records");
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("records.txt", true))) {
            writer.write(this.name + "," + this.balance);
            writer.newLine();
            System.out.println("Added new user to the records");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Long readBalance(){
        try(BufferedReader reader = new BufferedReader(new FileReader("records.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                String name = parts[0];
                Long balance = Long.parseLong(parts[1]);

                if(this.name.equals(name)){
                    // System.out.println(line);
                    return balance;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Not found in the records");
        return null;
    }

    public void transfer(Long amount, String recipient){
        // Long balance = readBalance();
        // if(balance == null) return;

        if(amount <= 0) {
            System.out.println("Invalid transfer funds"); 
            return;
        }

        Map<String, Long> records = new LinkedHashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("records.txt"))){
            String line;

            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                String name = parts[0];
                Long bal = Long.parseLong(parts[1]);
                records.put(name, bal);
            }
        }catch(IOException e){
            e.printStackTrace();
            return;
        }

        if(!records.containsKey(this.name)){
            System.out.println("Sender not found");
            return;
        }
        
        if(!records.containsKey(recipient)){
            System.out.println("Recipient not found");
            return;
        }

        Long balance = records.get(this.name);
        if(balance < amount){
            System.out.println("Insuficient funds");
            return;
        }

        records.put(this.name, balance - amount);
        records.put(recipient, records.get(recipient) + amount);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("records.txt", false))) {
            for(Map.Entry<String, Long> entry : records.entrySet()){
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Transfered successfully " + amount + " from " + this.name + " to " + recipient);
        System.out.println("New balance: " + records.get(this.name));
    
    }
}
