# Secret Santa Generator
Simple Application for Secret Santa Members 

A Commandline based Spring Boot application for generate secret santa's for receipients.

# Requirements:
Maven 3.3 & Java 1.8 

# Usage:
java -jar target/secretsantagenerator-0.0.1-SNAPSHOT.jar participants.csv

# Note: 
Before compiling the application edit the MailUtils.java inside the package com.secretsanta.utils.
Add the appropriate email and password for gmail account. If any other smtp account account, then change the 
mail configuration accordingly.
