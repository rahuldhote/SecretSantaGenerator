package com.secretsanta;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReader;
import com.secretsanta.pojo.SecretSantaMember;
import com.secretsanta.service.SecretSantaService;

@SpringBootApplication
public class SecretSantaGeneratorApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SecretSantaGeneratorApplication.class, args);
	}

	/**
	 * Read CSV File from Command Line
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private ArrayList<SecretSantaMember> readCSV(String fileName)
			throws IOException {

		CSVReader reader = new CSVReader(new FileReader(fileName), ',', '\'', 1);
		ArrayList<SecretSantaMember> santaMembers = new ArrayList<SecretSantaMember>();

		// read line by line
		String[] record = null;

		while ((record = reader.readNext()) != null) {
			SecretSantaMember secretSantaMember = new SecretSantaMember();
			secretSantaMember.setName(record[0]);
			secretSantaMember.setEmail(record[1]);
			secretSantaMember.setLocation(record[2]);
			santaMembers.add(secretSantaMember);
		}

		reader.close();
		return santaMembers;
	}

	/**
	 * 
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO
		String userDir = System.getProperty("user.dir");
		String csvfileName = userDir + '/' + args[0];
		ArrayList<SecretSantaMember> santaMembers = readCSV(csvfileName);
		SecretSantaService secretSanta = new SecretSantaService(santaMembers);
		secretSanta.setPairs();

	}

}
