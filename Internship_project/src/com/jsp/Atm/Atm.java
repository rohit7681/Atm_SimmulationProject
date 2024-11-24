package com.jsp.Atm;//

import java.util.Scanner;

public class Atm {
	private double balance;
	private int pin;

	public Atm(double balance, int pin) {
		this.balance = balance;
		this.pin = pin;
	}

	public void displayMenu() { // it is for display Option which option Atm provide
		System.out.println("1:Check Balance:-");
		System.out.println("2:Deposit:-");
		System.out.println("3:Withdraw:-");
		System.out.println("4:Change Pin:-");
		System.out.println("5:Exit:-");
	}

	public void deposit(double amount) { // this method is used for deposit the balance
		balance += amount;
	}

	public void withdrawl(double amount) { // it is used for withdrawal
		if (balance <= amount) {
			System.out.println("Insufficient Balance !"+"⚠️"+"\n");
			System.out.println("================================");
			return;
		} else {
			System.out.println("Withdrawal sucessfull !!"+"✅");
			System.out.println("==================================="+"\n");
			balance -= amount;
		}
	}

	public double getBalance() { // it is used for check balance
		return balance;
	}

	public boolean validatePin(int pin) { // it is used for validate the input pin is it right or wrong
		return this.pin == pin;
	}

	public void changePin(int newPin) { // it is used for change the pin
		Scanner b = new Scanner(System.in);
		String s = "";
		for (int i = 1; i <= 4; i++) {
			s+= (int) (Math.random() * 10);//This is for OTP
		}
		System.out.println("Your OTP =" + s);
		System.out.print("Enter Your OTP:-");
		String s1 = b.nextLine();// Integer.parseInt(System.console().readLine());
		if (s.equals(s1)) {//It is OTP Validation
			pin = newPin;
			System.out.println("OTP VALIDATION SUCESSFULL"+"✅");
			System.out.println("=========================================");
			try {
				Thread.sleep(1900);
				System.out.println("Pin Changed:"+"✅");
			} catch (InterruptedException e) {

			}
			System.out.println("========================================="+"\n");
		} else {
			System.out.println("Invalid OTP"+"❌");
			System.out.println("======================================"+"\n");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Atm atm = new Atm(1000, 1234);// Creating a Atm class object by giving actual argument
		System.out.print("Enter the pin:");
		int pin = Integer.parseInt(System.console().readLine());// it takes the pin input
		//System.out.println("Enter the pin:-" + pin);
		if (atm.validatePin(pin)) { // this if block will execute if the entered pin is correct
			int option = 0;
			while (option <= 5) {
				atm.displayMenu();
				System.out.println("==============================================="+"\n");
				System.out.print("Enter the Option:-");// it takes option input
				option = sc.nextInt();// Integer.parseInt(System.console().readLine());
				if (option > 0 && option <= 5) {
					switch (option) {
					case 1:
						System.out.println("Balance :" + atm.getBalance());
						System.out.println("====================================="+"\n");
						break;

					case 2:
						System.out.print("Enter Amount:-");
						double amount = sc.nextDouble();// Integer.parseInt(System.console().readLine());
						atm.deposit(amount);
						break;

					case 3:
						System.out.print("Enter Amount:-");
						double amount1 = sc.nextDouble();// .parseInt(System.console().readLine());
						atm.withdrawl(amount1);
						break;
					case 4:
						System.out.print("Enter your new pin:-");
						int newPin = sc.nextInt();
						atm.changePin(newPin);
						break;
					case 5:
						System.out.println("Thank You for Using ATM");
						break;
					default:
						break;
					}
				} else
					System.out.println("Invalid option input"+"⚠️");
			}
		} else
			System.out.println("Invalid Pin"+"⚠️");// if the pin is incorrect then it will run
	}

}
