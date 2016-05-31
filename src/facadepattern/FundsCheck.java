/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadepattern;

/**
 *
 * @author hartmann
 */

public class FundsCheck {
    //Deklaration der Variablen
    private double cashInAccount = 1000.00;
	
	public double getCashInAccount() { return cashInAccount; }
	
	public void decreaseCashInAccount(double cashWithdrawn) { cashInAccount -= cashWithdrawn; }
	
	public void increaseCashInAccount(double cashDeposited) { cashInAccount += cashDeposited; }
	
	public boolean haveEnoughMoney(double cashToWithdrawal) {
		//Genug Geld in Account? 
		if(cashToWithdrawal > getCashInAccount()) {
			
			System.out.println("Fehler: Sie haben nicht genug Geld!");
			System.out.println("Kontostand: " + getCashInAccount());
			
			return false;
			
		} else {
			//Funktion zum abheben von Geld 
			decreaseCashInAccount(cashToWithdrawal);
			
			System.out.println("Abheben erfolgreich! Kontostand: " + getCashInAccount());
			
			return true;
			
		}
		
	}
	//Anzahlung durchführen
	public void makeDeposit(double cashToDeposit) {
		
		increaseCashInAccount(cashToDeposit);
		
		System.out.println("Deposit Complete: Kontostand:" + getCashInAccount());
		
	}
}
