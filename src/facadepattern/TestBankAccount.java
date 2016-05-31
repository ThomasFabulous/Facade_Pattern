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
//
public class TestBankAccount {
    public static void main(String[] args){
                
		//Aufruf der Klasse BankAccountFacade
		BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234);
		
		accessingBank.withdrawCash(50.00);
		
		accessingBank.withdrawCash(950.00);
		
                accessingBank.depositCash(200.00);
	}
}
