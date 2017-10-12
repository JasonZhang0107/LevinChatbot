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
	static boolean chosen = false;
	public static void main(String[] args)
	{
		while(!chosen) {
			System.out.print("PLEASE NOTE: NONE OF THESE BOTS ARE SUBSTITUTES FOR AN ACTUAL THERAPIST, PLEASE SEEK OUT HELP IF YOU NEED IT\nHello User, which bot would you like to use?\nChoose a bot below.\n	1-Existence Bot\n	2-Romance Bot\n	3-Fitness Bot\n	4-TherapistThatNeedsTherapy Bot\n");
			
			Scanner sc = new Scanner(System.in);
			String response = sc.nextLine();
			
			if(response.equals("1") || response.toLowerCase().equals("existence")) {
				ChatBotAhnaf chatbot1 = new ChatBotAhnaf();
				//ChatBotPhillips chatbot2 = new ChatBotPhillips();
				
				System.out.println (chatbot1.getGreeting());
				String statement = sc.nextLine();
				while (!statement.toLowerCase().equals("bye"))
				{
					System.out.println (chatbot1.getResponse(statement));
					statement = sc.nextLine();
				}
			}
			else if(response.equals("2")|| response.toLowerCase().equals("romance")) {
				
				ChatBotPhillips chatbot2 = new ChatBotPhillips();
				
				System.out.println (chatbot2.getGreeting());
				String statement = sc.nextLine();
				while (!statement.toLowerCase().equals("bye"))
				{
					System.out.println (chatbot2.getResponse(statement));
					statement = sc.nextLine();
				}
			}
			else if(response.equals("3")|| response.toLowerCase().equals("fitness")) {
				
				ChatBotZhang chatbot3 = new ChatBotZhang();
				
				System.out.println (chatbot3.getGreeting());
				String statement = sc.nextLine();
				while (!statement.toLowerCase().equals("bye"))
				{
					System.out.println (chatbot3.getResponse(statement));
					statement = sc.nextLine();
				}
			}
			else if(response.equals("4")|| response.toLowerCase().equals("therapy")|| response.toLowerCase().equals("therapistthatneedstherapy")) {
				
				ChatBotGuan chatbot4 = new ChatBotGuan();
				
				System.out.println (chatbot4.getGreeting());
				String statement = sc.nextLine();
				while (!statement.toLowerCase().equals("bye"))
				{
					System.out.println (chatbot4.getResponse(statement));
					statement = sc.nextLine();
				}
			}
			else {
				chosen = false;
				System.out.println("Please choose an option.");
				
			}
		/*
		 * ChatBotAhnaf chatbot1 = new ChatBotAhnaf();
		System.out.println(chatbot1.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.toLowerCase().equals("bye"))
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
		*/

		}
	}
}
