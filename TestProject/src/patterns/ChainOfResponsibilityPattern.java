package patterns;

public class ChainOfResponsibilityPattern {

	public static void main(String[] args) {
		LogInHandler logIn = new LogInHandler();
		AuthHandler auth = new AuthHandler();
		auth.setNextHandler(logIn);
		LogInEvent logInEvent = new LogInEvent();
		MouseClickEvent mouseEvent = new MouseClickEvent();
		auth.handle(logInEvent);
		auth.handle(mouseEvent);
	}
}

interface Event{}
class LogInEvent implements Event{}
class AuthEvent implements Event{}
class MouseClickEvent implements Event{}
interface Handler {
	boolean canHandle(Event e);
	void handle(Event e);
	void setNextHandler(Handler h);
}

abstract class GenericHandler implements Handler{
	Handler next;
	
	@Override
	public boolean canHandle(Event e) {
		return false;
	}
	
	@Override
	public void handle(Event e) {
		if (canHandle(e)) {
			System.out.println(e.getClass().getSimpleName()+" handled by "+this.getClass().getSimpleName());
		}else {
			System.out.println(this.getClass().getSimpleName()+" cannot handle "+e.getClass().getSimpleName());
			if (next!=null) {
				next.handle(e);
			}else {
				throw new RuntimeException("No one was able to handle the "+e.getClass().getSimpleName()+"!!");
			}
		}
	}
	
	@Override
	public void setNextHandler(Handler h) {
		next = h;
	}
}

class LogInHandler extends GenericHandler{
	@Override
	public boolean canHandle(Event e) {
		if (e instanceof LogInEvent) {
			return true;
		}
		return false;
	}
}

class AuthHandler extends GenericHandler{
	@Override
	public boolean canHandle(Event e) {
		if (e instanceof AuthEvent) {
			return true;
		}
		return false;
	}
}

