
public class ChatBotAhnaf {
	int deepthoughts = 0;
	int patience = 10;
	int choice = 0;
	int time = 0;
	public String getGreeting()
	{
		return "What do you want to talk about today? We can talk about space,time or reality.";
	}
	public String getResponse(String statement)
	{
		String section = "";
		if(time == 0)
		{	
			section = firstResponse(statement);
		}
		else if(time == 1)
		{	
			section =  beginPath(statement);
		}
		else
		{
			section = "cool";
			
		}
		return section;
	}
	public String firstResponse(String statement)
	{
		String response = "";
		if(statement.length() == 0)
		{
			response = "You alright?";
			patience--;
		}
		else if(findKeyword(statement,"space",0) >= 0)
		{
			response = "So you like space huh?";
			choice = 1;
		}
		else if(findKeyword(statement,"time",0) >= 0)
		{
			response = "So you want to talk about time";
			choice = 2;
		}
		else if(findKeyword(statement,"reality",0) >= 0)
		{
			response = "So you want to talk about reality";
			choice = 3;
		}
		else
		{
			response = "Choose one of the other three please or you're going to have to leave.";
			patience--;
		}
		time++;
		return response;
		
	}
	public String beginPath(String statement)
	{
		String response = "";
		if(choice == 1)
		{
			response = spaceConversation(statement);
		}
		else if(choice == 2)
		{
			response = timeConversation(statement);
		}
		else 
		{
			response = realityConversation(statement);
		}	
		time++;
		return response;
	}
	private String spaceConversation(String statement)
	{
		String response = "";
		if(findKeyword(statement,"no",0) >= 0)
		{
			response = "Then what do want to talk about then time or reality?";
		}
		else if(findKeyword(statement,"yes",0) >= 0)
		{
			response = "Alright, I have always wondered about life out there, if there are aliens, what do you think of aliens.";
		}
		else
		{
			response = "Stop wasting my time!";
			patience--;
		}
		return response;	
	}
	private String timeConversation(String statement)
	{
		String response = "";
		response = "So you want to talk about time.";
		if(findKeyword(statement,"no",0) >= 0)
		{
			response = "Then what do want to talk about then space or reality?";
		}
		return response;
	}
	private String realityConversation(String statement)
	{
		String response = "";
		response = "So you want to talk about reality.";
		if(findKeyword(statement,"no",0) >= 0)
		{
			response = "Then what do want to talk about then time or space?";
		}
		return response;
	}
	
	private int findKeyword(String statement, String goal,int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	

}
