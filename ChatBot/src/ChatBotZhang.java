import java.util.Random;

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
	// emotion starts at 5, can go to as low as 0 or as high as 10
	int emotion = 0;
	
	//user name
	String name = "";
	
	//user goal
	String goal = "";
	
	//question type so the bot knows how to respond
	String questionType = "";
	
	//chatbot's memory
	public String [] chatbotMemory = {};
	
	//List of strings that would prompt the user to switch to another chatbot
	public String [] suggestSidneyBot = 
		{
				"crush",
				"romance",
				"love",
				"cute",
				"affection",
		};
	/*
	 * Description: Greets the user at the beginning of the conversation
	 * Returns: A greeting
	 */
	public String getGreeting()
	{
		questionType = "name";
		return "Hello my name is Connor, what is your name?";
	}
	/*
	 * Description: Responds to a user statement
	 * Parameter: Statement that the user enters
	 * Returns: A response based on what the user may/may not say
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		if(questionType == "name")
		{
			response = nameResponse(statement);
		}
		else if(questionType == "goal")
		{
			response = goalResponse(statement);
		}
		return response;
	}
	public String getResponseBasedOnEmotion(String response)
	{
		if(emotion < 1)
		{
			String angryResponse = response.toUpperCase() + "!!!!";
		}
		if(emotion == 0)
		{
		}
		if(emotion > 1)
		{
			String niceResponse = response + " It'd really help me out to understad you.";		
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
	//takes their name in and gives a response
	public String nameResponse(String statement)
	{
		name = statement;
		response = "Hello " +name+ " what are your fitness goals?\nIt can be anything from losing weight to gaining muscle";
		questionType = "goal";
		
		return response;
	}
	//takes in their statement looking for the words gain, gaining, lose, and losing to prompt a response associated with each specific one
	public String goalResponse(String statement)
	{
		//if neither gain or lose is found, it will prompt the user to give another statement
		if(isKeywordFound(statement, "gain") == false && isKeywordFound(statement,"lose")==false && isKeywordFound(statement,"losing")==false && isKeywordFound(statement,"gaining")==false)
		{
			String returnStatement = "Sorry man, I couldn't understand what you said. Can you tell me in simpler terms what your goal is.";
			response = getResponseBasedOnEmotion(returnStatement);
			emotion = emotion -1;
		}
		else
		{
			if(isKeywordFound(statement, "gain"))
			{
				int positionOfWord = findKeyword(statement, "gain");
				goal = statement.substring(positionOfWord + 5);
				
				response = "Alright then, so you want to gain " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan";
			}
			if(isKeywordFound(statement, "gaining"))
			{
				int positionOfWord = findKeyword(statement, "gaining");
				goal = statement.substring(positionOfWord + 8);
				
				response = "Alright then, so you want to gain " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan";
			}
			if(isKeywordFound(statement, "lose"))
			{
				int positionOfWord = findKeyword(statement, "lose");
				goal = statement.substring(positionOfWord + 5);
				
				response = "Alright then, so you want to lose " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan";
			}
			if(isKeywordFound(statement, "losing"))
			{
				int positionOfWord = findKeyword(statement, "losing");
				goal = statement.substring(positionOfWord + 7);
				
				response = "Alright then, so you want to lose " +goal+ ".\nDo you want to learn more about nutrition or perhaps a workout plan";
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
					response = "Alright then so you want to lose " +goalLose+ ".\nDo you want to learn more about nutrition or perhaps a workout plan";
				}
				else
				{
					response = "Alright then so you want to gain " +goalGain+ ".\nDo you want to learn more about nutrition or perhaps a workout plan";
				}
			}
		}
		questionType = "workoutType";
		return response;
	}
	public String workoutTypeResponse(String statement)
	{
		if(isKeywordFound(statement, "nutrition") == false || isKeywordFound(statement, "workout") == false)
		{
			String returnStatement = "I asked if you wanted to learn about nutrition or workout plan.\nIf your not interested just say bye.";
			emotion = emotion -1;
			response = getResponseBasedOnEmotion(returnStatement);
		}
		else
		{
			if(isKeywordFound(statement, "nutrition"))
			{
				if(isKeywordFound(goal, "gain") || isKeywordFound(goal, "gaining"))
				{
					response = "The key to gaining muscle is to eat in a caloric surplus.\n Your muscles need more calories than your maintence for growth";
				}
				else
				{
					if(isKeywordFound(goal, "lose") || isKeywordFound(goal, "losing"))
					{
						response = "The key to losing fat is to eat in a caloric deficit, when you consume less than you need, you will lose weight";
					}
				}
			}
			if(isKeywordFound(statement, "workout"))
			{
				if(isKeywordFound(goal, "gain") || isKeywordFound(goal, "gaining"))
				{
					response = "The key to gaining muscle in a workout is strength training, I would suggest 5 days a week";
				}
				else
				{
					if(isKeywordFound(goal, "lose") || isKeywordFound(goal, "losing"))
					{
						response = "The key to losing fat for a workout plan is doing cardio. HIIT cardio for 20 minutes each session is highly effective";
					}
				}
			}
		}
		return response;
	}
}
