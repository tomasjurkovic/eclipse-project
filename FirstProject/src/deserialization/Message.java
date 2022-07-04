package deserialization;

public class Message {
	
	private String message;
	private String greet;

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getGreet() {
		return greet;
	}


	public void setGreet(String greet) {
		this.greet = greet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message m = new Message();
		m.setMessage("Hi");
		m.setGreet("Hello");
		System.out.println(m);
		System.out.println(m.toString());

	}

}
