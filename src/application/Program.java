package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			//remeber: Set dont acept repetions 
			Set<LogEntry> set = new HashSet<>(); //HashSet because to contabilize users that acess, dont care a order and HashSet is a more faster
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(" "); //to cut informations in archive, create Array fields in type String to separate using a white space with split
				String username = fields[0]; //alocate username to position 0 in vect fields
				
				//alocate Date in archive nexted cut, creating moment in type Date and usying method .from(Instant.parse(fields[1])) to alocate Date in this position vect
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment)); //call a set to instance a new LogEntry
				
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}		
		sc.close();
	}
}