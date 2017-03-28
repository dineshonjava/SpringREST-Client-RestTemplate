/**
 * 
 */
package com.doj.restclient.account;

import java.util.List;

import org.springframework.web.client.RestTemplate;

/**
 * @author Dinesh.Rajput
 *
 */
public class SpringRestClient {
	
	private static RestTemplate restTemplate = new RestTemplate();
	private static final String baseURL = "http://localhost:8080/restapi/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create Account using POST method of RestTemplate
		/*Account account = new Account("Arnav Rajput", "Noida", 522.33);
		account = restTemplate.postForObject(baseURL+"account", account, Account.class);
		System.out.println("Added account: " +account);*/
		
		//Read Account details for a given accountId = 1 using GET method of RestTemplate
		/*Account accountDetail = restTemplate.getForObject(baseURL+"account/1", Account.class);
		System.out.println("Account Detail for given AccountId : " +accountDetail);*/ 
		
		List<Account> accounts = restTemplate.getForObject(baseURL+"accounts", List.class);
		System.out.println("Total Accounts before DELETE call: ");
		for(Object acct : accounts){
			System.out.println(acct);
		}
		//Update Account detail for given accountId = 1 using PUT method of RestTemplate
		/*Account updateAccount = new Account("Anamika Rajput", "Noida", 123.33);
		updateAccount.setAccountId(1l);
		restTemplate.put(baseURL+"account", updateAccount);
		Account updatedAccount = restTemplate.getForObject(baseURL+"account/1", Account.class);
		System.out.println("Updated Account: " +updatedAccount);*/
		
		//Delete Account for given accountId = 2 using Delete method of RestTemplate
		restTemplate.delete(baseURL+"account/3");
		accounts = restTemplate.getForObject(baseURL+"accounts", List.class);
		System.out.println("Total Accounts after DELETE call: ");
		for(Object acct : accounts){
			System.out.println(acct);
		}
	}

}
