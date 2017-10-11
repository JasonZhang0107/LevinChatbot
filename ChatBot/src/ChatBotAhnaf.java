
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
		if(patience <= 5)
		{
			time = 17;
		}
		if(deepthoughts == 3)
		{
			time = 18;
		}
		if(time == 0)
		{	
			section = firstResponse(statement);
		}
		else if(time == 1)
		{	
			section =  beginPath(statement);
		}
		else if(time == 2)
		{
			section = alienThread(statement);
		}
		else if(time == 3)
		{
			section = lifelengthThread(statement);
		}
		else if(time == 4)
		{
			section = worldThread(statement);
		}
		else if(time == 5)
		{
			section = alienPositive(statement);
		}
		else if(time == 6)
		{
			section = alienNegative(statement);
		}
		else if(time == 7)
		{
			section = alienPositivetwo(statement);
		}
		else if(time == 8)
		{
			section = alienPositivethree(statement);
		}
		else if(time == 9)
		{
			section = lifePositive(statement);
		}
		else if(time == 10)
		{
			section = lifePositivecont(statement);
		}
		else if(time == 11)
		{
			section = lifePositivetwo(statement);
		}
		else if(time == 12)
		{
			section = lifePositivethree(statement);
		}
		else if(time == 13)
		{
			section = worldThreadcont(statement);
		}
		else if(time == 14)
		{
			section = worldThreadtwo(statement);
		}
		else if(time == 15)
		{
			section = worldThreadthree(statement);
		}
		else if(time == 16)
		{
			section = realityEnd(statement);
		}
		else if(time == 17)
		{
			section = noPatience();
		}
		else if(time == 18)
		{
			section = goodThoughts();
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
		time = 1;
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
		
		return response;
	}

	private String spaceConversation(String statement)
	{
		String response = "";
		if(findKeyword(statement,"no",0) >= 0)
		{
			response = "Then what do want to talk about then time or reality?";
			time = 0;
		}
		else if(findKeyword(statement,"yes",0) >= 0)
		{
			response = "Alright, I have always wondered about life out there, if there are aliens, what do you think of aliens.";
			time = 2;
		}
		else
		{
			response = "Stop wasting my time!Choose something else then";
			time = 0;
			patience--;
		}
		return response;	
	}
	private String alienThread(String statement)
	{
		String response = "";
		if(findKeyword(statement,"cool",0)>=0)
		{
			response = "I think that too. Personally I am excited to see aliens for the first time because they might be very interesting. How about you. ";
			time = 5;
		}
		else if(findKeyword(statement,"I don't like",0)>=0)
		{
			response = "Why is that";
			time = 6;
		}
		else if(findKeyword(statement,"interesting",0)>=0)
		{
			response = "Why do you think that";
			time = 5;
		}
		else
		{
			response = "Stop wasting my time!Choose something else then";
			time = 0;
			patience--;
		}
		
		return response;
	}
	private String alienPositive(String statement)
	{
		String response = "";
		if(findKeyword(statement,"interesting",0)>=0)
		{
			response = "Hmmm. What do you think is so interesting";
			time = 7;
		}
		else if(findKeyword(statement,"cool",0)>=0)
		{
			response = "What do you think is so cool about space";
			time = 7;
		}
		else
		{
			response = "Stop wasting my time!Choose something else then";
			time = 0;
			patience--;
		}
		return response;
	}
	private String alienPositivetwo(String statement)
	{
		String response = "";
		if(findKeyword(statement,"space",0)>=0)
		{
			response = "Do you think humans will ever go to space";
			time = 8;
		}
		else if(findKeyword(statement,"don't",0)>=0)
		{
			response = "Let's change the topic, time or reality";
			time = 0;
		}
		else
		{
			response = "Stop wasting my time!Choose something else then";
			time = 0;
			patience--;
		}
		return response;
	}
	private String alienPositivethree(String statement)
	{
		time = 0;
		deepthoughts++;
		return "Good,I think we need to talk about another topic, choose time or reality or leave";
	}
	private String alienNegative(String statement)
	{
		time = 0;
		return "I think we need to talk about another topic, choose time or reality or leave";
	}
	
	private String timeConversation(String statement)
	{
		String response = "";
		if(findKeyword(statement,"no",0) >= 0)
		{
			response = "Then what do want to talk about then space or reality?";
			time = 0;
		}
		else if(findKeyword(statement,"yes",0)>=0)
		{
			response = "I'm sorry if this might get a little sad, but time always seems to go by so fast. Are you scared of running out of time";
			time = 3;
		}
		else
		{
			response = "Stop wasting my time!Choose something else then";
			time = 0;
			patience--;
		}
		return response;
	}
	private String lifelengthThread(String statement)
	{
		String response = "";
		if(findKeyword(statement,"yes",0)>=0)
		{
			response = "What exactly are you afraid of losing";
			time = 9;
		}
		else if((findKeyword(statement,"scared",0)>=0)||(findKeyword(statement,"afraid",0)>=0))
		{
			response = "Why are you afraid of losing that";
			time = 9;
		}
		else
		{
			time = 0;
			patience--;
			return "If you want help you should talk, choose something else or leave, I don't care anymore";
		}
		return response;
	}
	private String lifePositive(String statement)
	{
		String response = "";
		if((findKeyword(statement,"sad",0)>=0) || (findKeyword(statement,"depressed",0)>=0))
		{
			response = "Continue, it's ok";
			time = 10;
		}
		else if((findKeyword(statement,"I don't",0)>=0))
		{
			response = "Try to think, why, you feel that way";
			time = 11;
		}
		else
		{
			time = 0;
			response = "I think we need to talk about another topic, choose space or reality or leave";
		}
		return response;
	}
	private String lifePositivecont(String statement)
	{
		time = 0;	
		return "I think we made some good progress, so you can leave or we can discuss another topic";
	}
	private String lifePositivetwo(String statement)
	{
		String response = "";
		if(findKeyword(statement,"feel",0) >= 0)
		{
			response = "Continue I think you are getting it";
			time = 10;
		}
		else if(findKeyword(statement,"I don't know",0) >= 0)
		{
			response = "I need you to figure it out";
			time = 12;
		}
		else
		{
			time = 0;
			response = "I think we need to talk about another topic, choose space or reality or leave";
		}
		return response;
	}
	private String lifePositivethree(String statement)
	{
		time = 0;
		deepthoughts++;
		return "Wow that was very eye opening for both of us, thank you for sharing. Choose another topic or leave";
	}
	private String realityConversation(String statement)
	{
		String response = "";
		response = "So you want to talk about reality.";
		if(findKeyword(statement,"no",0) >= 0)
		{
			response = "Then what do want to talk about then time or space?";
			time = 0;
		}
		else if(findKeyword(statement,"yes",0) >= 0)
		{
			response = "Have you ever wondered if we are living in a computer simulation like the Matrix movies";
			time = 4;
		}
		else
		{
			response = "Really, you're going to play this game, ok.Choose something else or leave.";
			time = 0;
			patience--;
		}
		return response;
	}
	private String worldThread(String statement)
	{
		String response = "";
		if(findKeyword(statement,"matrix",0) >= 0)
		{
			response = "I don't care about the Matrix movies! I just wanna talk about the concept about a simulation so do you think we are";
			time = 4;
			patience--;
		}
		else if(findKeyword(statement,"yes",0) >= 0)
		{
			response = "Why do you think that";
			time = 13;
		}
		else
		{
			response = "I'm getting irritated by your crap we are changing the topic. Choose space or time";
			time = 0;
			patience--;
		}
		return response;
	}
	private String worldThreadcont(String statement)
	{
		String response = "";
		if((findKeyword(statement,"scary",0) >= 0)||(findKeyword(statement,"strange",0) >= 0))
		{
			response = "Personally I think that it would be great if a simulation was the case because then I would have someone to blame my problems on the programmers. Also if there is a god then I can blame my problems and mistakes on god because it decided my life for me. Do you agree";
			time = 14;
		}
		else if((findKeyword(statement,"interesting",0) >= 0) || (findKeyword(statement,"cool",0) >= 0))
		{
			response = "I agree but why do you think that";
			time = 15;
		}
		else
		{
			time = 0;
			patience--;
			return "Seems that you don't want to talk about this topic, let's change then or leave"; 
		}
		return response;
	}
	private String worldThreadtwo(String statement)
	{
		String response = "";
		if((findKeyword(statement,"crazy",0)>=0)||(findKeyword(statement,"strange",0)>=0))
		{
			response = "Am I not wrong?";
			time = 16;
		}
		else
		{
			time = 0;
			response = "Whatever, lets change topics or you can leave";
		}
		return response;
	}
	private String realityEnd(String statement)
	{
		time = 0;
		deepthoughts++;
		return "I think we had a good talk, but now we can change topics or you can leave";
	}
	private String worldThreadthree(String statement)
	{
		String response = "";
		if(findKeyword(statement,"like",0)>=0)
		{
			response = "Interesting but is there a reason why";
			time = 16;
		}
		else
		{
			time = 0;
			response = "Whatever, lets change topics or you can leave";
		}
		return response;
	}
	private String noPatience()
	{
		return "I am done with you, I want you to leave and never want to see you back here";
	}
	private String goodThoughts()
	{
		return "Wow. This has been a really productive session with you I hope we can meet again but for now we are done. I hope you feel better about your existence";
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
