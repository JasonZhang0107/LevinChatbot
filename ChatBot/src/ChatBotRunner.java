import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Mr. Levin
 * @version September 2017
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		boolean chosen = false;
		System.out.print("Hello Sonny, which bot would you like to use?\n-Pick a number below.\n\n1-Existence Bot\n2-Fitness Bot\n3-Romance Bot\n4-TherapistThatNeedsTherapy Bot");
		Scanner bot = new Scanner (System.bot);
		String response = bot.nextLine();
		while(!chosen) {
			chosen = true;
			if() {
			}
			if() {
			}
			if() {
			}
			if() {
			}
			else {
				System.out.println("Please choose a number");
				chosen = false;
			}
		}
		ChatBotPhillips chatbot2 = new ChatBotPhillips();
		ChatBotAhnaf chatbot1 = new ChatBotAhnaf();
		//ChatBotPhillips chatbot2 = new ChatBotPhillips();
		
		System.out.println (chatbot1.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		


		while (!statement.toLowerCase().equals("bye"))
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
	}
	

}
