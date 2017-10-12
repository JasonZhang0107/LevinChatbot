import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Mr. Levin and Jason Zhang
 * @version Created by Mr. Levin, modified and expanded by Jason
 */
public class ChatBotZhang
{	
	//global string that changes depending on the conversation
	String response = "";
	
	//emotion can alter the bot's responses and can be changed as the conversation progresses
	//the bot can have positive emotion which is hapy, or negative emotion which is sad/angry
	int emotion = 0;
	
	//user name
	String name = "";
	
	//user goal
	String goal = "";
	
	//variable needed for later use to keep track of the string
	String goalResponse = "";
	
	//question type so the bot knows how to respond
	String questionType = "";
	
	//List of strings that would prompt the user to switch to another chatbot
	public String [] romance = 
		{
				"crush",
				"romance",
				"love",
				"cute",
				"affection",
		};
	public String [] existence = 
		{
				"space",
				"time",
				"reality",
				"existence",
				"life",
		};
	public String [] therapy = 
		{
				"therapy",
				"therapist",
				"cure",
				"healing",
				"remedy",
		};
	
	/*
	 * Description: Greets the user at the beginning of the conversation
	 * Returns: A greeting
	 */
	public String getGreeting()
	{
		questionType = "name";
		return "Hello, I am the fitness bot.\nMy name is Connor, what is your name?";
	}
	/*
	 * Description: Responds to a user statement
	 * Parameter: Statement that the user enters
	 * Returns: A response based on what the user may/may not say
	 */
	public String getResponse(String statement)
	{
		if(questionType == "name")
		{
			response = nameResponse(statement);
		}
		else if(questionType == "goal")
		{
			response = goalResponse(statement);
		}
		else if(questionType == "workoutType")
		{
			response = workoutTypeResponse(statement);
		}
		else if(questionType == "end")
		{
			response = endResponse(statement);
		}
		else if(questionType == "whichBot")
		{
			whichBotResponse(statement);
		}
		return emotionalResponses(response);
	}
	public String emotionalResponses(String statement)
	{
		if(emotion < 0)
		{
			response = statement.toUpperCase() + "I AM SO MAD AT YOU RIGHT NOW!";
		}
		if(emotion > 0)
		{
			response = statement + "Go get them gains!!";
		}
		if(emotion == 0)
		{
			response = statement;
		}
		return response;
	}
	public int findKeyword(String statement, String keyword)
	{
		return findKeyword(statement, keyword, 0);
	}
	public int findKeyword(String statement, String keyword, int startPosition)
	{
		//makes sentence lowercase to compare
		String sentence = statement.trim().toLowerCase();
		
		//makes keyword lowercase to compare
		keyword = keyword.toLowerCase();
		
		//position of the keyword in the sentence if found
		int positionOfWord = sentence.indexOf(keyword, startPosition);
		
		//make sure the goal isn't part of a response
		while(positionOfWord > 0)
		{
			String before = " ";
			String after = " ";
			if(positionOfWord > 0)
			{
				before = sentence.substring(positionOfWord-1, positionOfWord);
			}
			if(positionOfWord + keyword.length() < sentence.length())
			{
				after = sentence.substring(positionOfWord + keyword.length(), positionOfWord + keyword.length() + 1);
			}
			// compare to returns 0 if unicode value is same and a positive/negative number if not
			if((before.compareTo("a") < 0) || (before.compareTo("z") > 0) && (after.compareTo("a") < 0 || (after.compareTo("z") > 0)))
			{
				return positionOfWord;
			}
			//letter is found before or after the keyword so look for next keyword
			positionOfWord = sentence.indexOf(keyword, startPosition+1);
		}
		return -1;
	}
	/*
	 * Description: Determines whether or not a keyword is found
	 * Parameter: Statement that the user enters and keyword that is being searched
	 * Returns: True if keyword found, false is not found
	 */
	public boolean isKeywordFound(String statement, String keyword)
	{
		if(findKeyword(statement, keyword) == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/*
	 * Description: Ask the user for their name
	 * Parameter: The user response represented by statement
	 * Return: A response that uses the user's name. Prompts them for more information
	 */
	public String nameResponse(String statement)
	{
		name = statement;
		response = "Hello " +name+ " what are your fitness goals?\nIt can be anything from losing weight to gaining muscle.";
		questionType = "goal";
		
		return response;
	}
	/*
	 * Description: Ask the user for their fitness goals
	 * Parameter: The user response represented by statement
	 * Return: A response to the user based on what they answered as well as prompting them with a new question
	 */
	public String goalResponse(String statement)
	{
		//if neither gain or lose is found, it will prompt the user to give another statement
		if(isKeywordFound(statement, "gain") == false && isKeywordFound(statement,"lose")==false && isKeywordFound(statement,"losing")==false && isKeywordFound(statement,"gaining")==false)
		{
			response = "I said what are your fitness goals. Answer me properly!";
			emotion--;
		}
		else
		{
			if(isKeywordFound(statement, "gain"))
			{
				int positionOfWord = findKeyword(statement, "gain");
				goal = statement.substring(positionOfWord + 5);
				
				response = "Alright then, so you want to gain " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan.";
				goalResponse = response;
				
				questionType = "workoutType";
				
				emotion++;
			}
			if(isKeywordFound(statement, "gaining"))
			{
				int positionOfWord = findKeyword(statement, "gaining");
				goal = statement.substring(positionOfWord + 8);
				
				response = "Alright then, so you want to gain " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan.";
				goalResponse = response;
				
				questionType = "workoutType";
				
				emotion++;
			}
			if(isKeywordFound(statement, "lose"))
			{
				int positionOfWord = findKeyword(statement, "lose");
				goal = statement.substring(positionOfWord + 5);
				
				response = "Alright then, so you want to lose " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan.";
				goalResponse = response;
				
				questionType = "workoutType";
				
				emotion++;
			}
			if(isKeywordFound(statement, "losing"))
			{
				int positionOfWord = findKeyword(statement, "losing");
				goal = statement.substring(positionOfWord + 7);
				
				response = "Alright then, so you want to lose " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan.";
				goalResponse = response;
				
				questionType = "workoutType";
				
				emotion++;
			}
			//if both gain and lose is found, it will return a response incorporating both of what the user wants
			//this if statement needs to be placed at the end to overwrite the other two is conditions are met
			if(isKeywordFound(statement, "gain") && isKeywordFound(statement,"lose"))
			{
				int positionOfWordGain = findKeyword(statement, "gain");
				String goalGain = statement.substring(positionOfWordGain + 5);
				
				int positionOfWordLose = findKeyword(statement, "lose");
				String goalLose = statement.substring(positionOfWordLose + 5);
				
				if(positionOfWordGain > positionOfWordLose)
				{
					response = "Alright then so you want to lose " +goalLose+ ".\nDo you want to learn more about nutrition or perhaps a workout plan.";
					goalResponse = response;
					
					questionType = "workoutType";
					
					emotion++;
				}
				else
				{
					response = "Alright then so you want to gain " +goalGain+ ".\nDo you want to learn more about nutrition or perhaps a workout plan.";
					goalResponse = response;
					
					questionType = "workoutType";
					
					emotion++;
				}
			}
		}
		return response;
	}
	/*
	 * Description: Returns the user some useful information and asks if they would like to speak with another bot
	 * Parameter: The user response represented by statement
	 * Return: A response based on the user's answer to this question and a previous question
	 */
	public String workoutTypeResponse(String statement)
	{
		if(isKeywordFound(statement, "nutrition") == false && isKeywordFound(statement, "workout") == false)
		{
			response = "I asked if you wanted to learn about nutrition or workout plan.\nI can tell your not serious about this, are you.";
			emotion--;
		}
		else
		{
			if(isKeywordFound(statement, "nutrition"))
			{
				if(isKeywordFound(goalResponse, "gain") || isKeywordFound(goalResponse, "gaining"))
				{
					response = "The key to gaining " +goal+ " is to eat in a caloric surplus.\nYour muscles need more calories than your maintence for growth.\nI think we've done enough talking, now its time for you to get to work or would you prefer to speak with another bot?";
					questionType = "end";
					
					emotion++;
				}
	 			else
	 			{
	 				if(isKeywordFound(goalResponse, "lose") || isKeywordFound(goalResponse, "losing"))
	 				{
	 					response = "The key to losing " +goal+ " is to eat in a caloric deficit, when you consume less calories than you need expend, you will lose weight.\nI think we've done enough talking, now its time for you to get to work or would you prefer to speak with another bot?";
	 					questionType = "end";
	 					
	 					emotion++;
	 				}
	 			}
	 		}
	 		if(isKeywordFound(statement, "workout"))
 			{
 				if(isKeywordFound(goalResponse, "gain") || isKeywordFound(goalResponse, "gaining"))
 				{
 					response = "The key to gaining " +goal+ " in a workout is strength training.\nI would suggest a full body workout for 4-5 days a week.\nI think we've done enough talking, now its time for you to get to work or would you prefer to speak with another bot?";
 					questionType = "end";
 					
 					emotion++;
 				}
 				else
 				{
					if(isKeywordFound(goalResponse, "lose") || isKeywordFound(goalResponse, "losing"))
 					{
 						response = "The key to losing" +goal+ " for a workout plan is doing cardio.\nHIIT cardio for 20 minutes each time is highly effective.\nI think we've done enough talking, now its time for you to get to work or would you prefer to speak with another bot?";
 						questionType = "end";
 						
 						emotion++;
					}
 				}
	 		}
		}
		return response;
	}
	/*
	 * Description: If user wants to talk with another bot, they are offered different options. If not, the conversation ends.
	 * Parameter: The user response represented by statement
	 * Return: Ask the user which bot they'd like to speak with or end the conversation with a different response
	 */
	public String endResponse(String statement)
	{
		if(isKeywordFound(statement, "talk with another bot") || isKeywordFound(statement, "talk more") || isKeywordFound(statement, "another bot") || isKeywordFound(statement, "speak"))
		{
			response = "Which bot would you like to speak with?\nSidney's romance bot, Ahnaf's existence bot, or Ivy's therapy bot?";
			questionType = "whichBot";
		}
		else
		{
			response = "Alright then, I guess this is bye.";
			emotion++;
		}
		return response;
	}
	/*
	 * Description: Creates a new bot for the user to talk to
	 * Parameter: The user response represented by sentence
	 * Return: Creates a new chatbot depending on what the answer inputted
	 */
	public void whichBotResponse(String sentence)
	{
		if(isKeywordFound(sentence, "Sidney's") || isKeywordFound(sentence, "Sidney") || isKeywordFound(sentence, "romance"))
		{
			ChatBotPhillips chatbot1 = new ChatBotPhillips();
			System.out.println(chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.toLowerCase().equals("bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}
		if(isKeywordFound(sentence, "Ahnaf's") || isKeywordFound(sentence, "Ahnaf") || isKeywordFound(sentence, "existence"))
		{
			ChatBotAhnaf chatbot1 = new ChatBotAhnaf();
			System.out.println(chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.toLowerCase().equals("bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}
		if(isKeywordFound(sentence, "Ivy's") || isKeywordFound(sentence, "Ivy") || isKeywordFound(sentence, "therapy"))
		{
			ChatBotGuan chatbot1 = new ChatBotGuan();
			System.out.println(chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.toLowerCase().equals("bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}
	}
	/*public boolean checkForBotKeywords(String statement, String [] switchBotWords)
	{
		for(int x=0; x<(switchBotWords.length); x++)
		{
			if(isKeywordFound(statement, switchBotWords[x]))
			{
				return true;
			}
		}
		return false;
	}
	public String checkForWhichBot(String sentence)
	{
		if (checkForBotKeywords(sentence, romance))
		{
			String type = "";
			type = "romance";
			return type;
		}
		if (checkForBotKeywords(sentence, existence))
		{
			String type = "";
			type = "existence";
			return type;
		}
		if (checkForBotKeywords(sentence, therapy))
		{
			String type = "";
			type = "therapy";
			return type;
		}
		return "none";
	}
	public String checkForUserConsent(String type)
	{
		String response = "";
		if(type == "romance")
		{
			response = "I see you mentioned something related to romance, would you like to talk to Sidney's bot about romance, relationships, and more?";
			questionType = "changeBot";
		}
		if(type == "existence")
		{
			response = "I see you mentioned something related to existence, would you like to talk to Ahnaf's bot about space, time, and more?";
			questionType = "changeBot";
		}
		if(type == "therapy")
		{
			response = "I see you mentioned something related to therapy, would you like to talk to Ivy's bot about therapy, help, and more?";
			questionType = "changeBot";
		}
		if (type == "none")
		{
			
		}
		return response;
	}
	public void createNewChatBot(String userResponse, String contentType)
	{
		if(isKeywordFound(userResponse, "yes") || isKeywordFound(userResponse, "sure") || isKeywordFound(userResponse, "yea") || isKeywordFound(userResponse, "ye") || isKeywordFound(userResponse, "ok"))
		{
			if(isKeywordFound(contentType, "romance"))
			{
				ChatBotPhillips chatbot1 = new ChatBotPhillips();
				System.out.println(chatbot1.getGreeting());
				Scanner in = new Scanner (System.in);
				String statement = in.nextLine();
			}
			if(isKeywordFound(contentType, "existence"))
			{
				ChatBotAhnaf chatbot1 = new ChatBotAhnaf();
				System.out.println(chatbot1.getGreeting());
				Scanner in = new Scanner (System.in);
				String statement = in.nextLine();
			}
			if(isKeywordFound(contentType, "therapy"))
			{
				ChatBotGuan chatbot1 = new ChatBotGuan();
				System.out.println(chatbot1.getGreeting());
				Scanner in = new Scanner (System.in);
				String statement = in.nextLine();
			}
		}
		else
		{
			ChatBotZhang chatbot1 = new ChatBotZhang();
			System.out.println(chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
		}
	}
	if(questionType == "changeBot")
	{
		if response is "" then function will not be able to find keyword then it will not create a new chatbot.
		//if response has a keyword, it will create a new chatbot depending on the keyword found.
		//if user replies with anything other than yes, yea, sure, ye, ok when asked if they wanted to switch, it will reset my bot and start the conversation over again
		createNewChatBot(statement, runChatBotSwitch(statement));
	}
	*/
}