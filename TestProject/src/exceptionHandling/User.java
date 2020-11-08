package exceptionHandling;
// Dummy User
public class User{
    
    public void createAccount(String userID){
        String returnValue = AccountFacade.createAccount1(userID);
        if (returnValue == null){
            System.out.println("Could not create account!");
        }

        try {
            AccountFacade.createAccount2(userID);
        }catch (AuthenticationException auth){
            // Deal with exception
            System.out.println("Could not create account!");
        }
    }
}