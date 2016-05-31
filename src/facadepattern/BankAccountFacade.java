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
//Aufbau der Facade
//Übergabe der Parameter und deklaration der Variablen
public class BankAccountFacade {
    private int accountNumber;
	private int securityCode;
	
	AccountNumberCheck acctChecker;
	SecurityCodeCheck codeChecker;
	FundsCheck fundChecker;
	
	WelcomeToBank bankWelcome;
        
        //Zugriff auf die Klassen 1-4 
        //erzeugung
	
	public BankAccountFacade(int newAcctNum, int newSecCode){
		
		accountNumber = newAcctNum;
		securityCode = newSecCode;
		
		bankWelcome = new WelcomeToBank();
		
		acctChecker = new AccountNumberCheck();
		codeChecker = new SecurityCodeCheck();
		fundChecker = new FundsCheck();
		
	}
	//getter Methoden zum abrufen von Werten
	public int getAccountNumber() { return accountNumber; }
	
	public int getSecurityCode() { return securityCode; }
	
	//Überprüfung Account Nummer / Sicherheitsnummer / genug Geld? 
	public void withdrawCash(double cashToGet){
		
		if(acctChecker.accountActive(getAccountNumber()) &&
				codeChecker.isCodeCorrect(getSecurityCode()) &&
				fundChecker.haveEnoughMoney(cashToGet)) {
					
					System.out.println("Transaction Erfolgreich\n");
					
				} else {
					
					System.out.println("Transaction Fehlgeschlagen\n");
					
				}
		
	}
	
	//Anzahlung
	public void depositCash(double cashToDeposit){
		
		if(acctChecker.accountActive(getAccountNumber()) &&
				codeChecker.isCodeCorrect(getSecurityCode())) {
			
					fundChecker.makeDeposit(cashToDeposit);
					
					System.out.println("Transaction Erfolgreich\n");
					
				} else {
					
					System.out.println("Transaction Fehlgeschlagen\n");
					
				}
		
	}
}
