package exceptionHandling;

public class AccountFacade {
    public static String createAccount1(String userID){
        String initialPw = "123"; // dummy implementation
        if(Authenticator.createAuth(userID,initialPw))
            return initialPw;
        return null;
    }

    public static void createAccount2(String userID) throws AuthenticationException{
        String initialPw = "123"; // dummy implementation
        if(!Authenticator.createAuth(userID,initialPw)) {
            throw new AuthenticationException();
        }
    }
}