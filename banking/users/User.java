package users;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class User{
    private String password;
    public String name;
    public String username;
    private boolean auth;

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.saveUser();
    }

    public String getPassword() {
        return password;
    }   
    
    public void saveUser(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))){
            String[] data = {this.name, this.username, this.password};
            String line = String.join(",", data);
            writer.write(line);
            writer.newLine();
            System.out.println("User saved successfully");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(){
        try(BufferedReader reader = new BufferedReader(new FileReader("users.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length < 3) continue;

                String storedName = parts[0];
                String storedUserName = parts[1];
                String storedPassword = parts[2];

                if(storedPassword.equals(this.password) && storedUserName.equals(this.username)){
                    System.out.println("Welcome " + username);
                    this.auth = true;
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Invalid name, username or password");
        return false;
    }
}
