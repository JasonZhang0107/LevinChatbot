
public class ChatBotPhillips {
	public String getGreeting() {
		
		return "Let me get to know a little about you. Can you tell me your name?";
	}
	int patience = 10;
	String name = "";
	boolean inRelationShip = false;
	String question = "name";
	public String getResponse(String statement) 
	{
		boolean responded = false;
		String response = "";
		while (!responded) 
		{
		if (statement.length() == 0)
			{
				if(patience == 0) 
				{
					response = "Please.";
				}
				else if(patience < 4)
				{
					response = "I need you to say something,"+name;
				}
				else if (patience < 7)
				{
					response = "We can talk this out.";
					patience--;
				}
				else {
					patience--;
					response = "Say something, please.";
				}
				responded = true;
			}
		else if(findKeyword (statement, "My name is")>=0) {
			
				int psn = findKeyword (statement.toLowerCase(), "my name is");
				System.out.println(statement.substring(psn));
				name = statement.substring(psn+10).trim();
				if(question == "name")
				{
					name = statement;
					response = "Hi, "+name+", I presume you came to see me for relationship advice.\nAre you currently in a relationship with someone?";
					question = "relations";
				}
				else
				{
					response = "I already know your name, "+name;
				}
				responded = true;
		}
			else if(findKeyword(statement, "yes") >= 0|| findKeyword(statement, "yeah")>= 0||findKeyword(statement, "yep")>=0||findKeyword(statement, "kind of")>=0|| findKeyword(statement, "ye")>= 0|| findKeyword(statement, "sort of")>= 0)
			{
				if(question == "name")
				{
					name = statement;
					response = "Hi, "+name+", I presume you came to see me for relationship advice.\nAre you currently in a relationship with someone?";
					question = "relations";
				}
				else if(question == "relations")
					{
						inRelationShip = true;
						response = "Are you seeking advice on your relationship with this person?";
						question = "interested";
					}
				else if(question == "interested"&&inRelationShip) 
				{
					response = "I hope I can help! Are you having problems with your current relationship?";
					question = "problems";
				}
				else if(question == "interested"&&!inRelationShip) 
				{
					response = "Great! Hopefully I can help. \nIs this person a close friend?";
					
				}
				else if(question == "noRes") {
					response = "You can type 'Bye' to exit the chat bot.";
				}
				responded = true;
			}
			else
			{
				if(question == "name")
				{
					name = statement;
					response = "Hi, "+name+", I presume you came to see me for relationship advice.\nAre you currently in a relationship with someone?";
					question = "relations";
					if(findKeyword(name, "levin")>= 0||findKeyword(name, "nathan")>= 0)
					{
						response = "Oh, Mr. Levin! Sorry I didn't recognize you! You probably don't need relationship advice, but I'll ask anyway:\nAre you currently in a relationship with someone?";
					}
				}

				else if(question == "relations") 
				{
					inRelationShip = false;
					response = "Okay, that's fine. Are you interested in someone currently?";
					question = "interested";
					//
				}
				else if(question == "interested") 
				{
					response = name+", I'm not sure that I can help you in that case. Might I reccomend another bot, such as Ahnaf's Existence Bot?";
					question = "noRes";
				}
				else if(question == "noRes") {
					response = "You can type 'Bye' to exit the chat bot.";
				}

				responded = true;
			}	
		}
		return response;
	}
	private static int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	private static int findKeyword(String statement, String goal,
			int startPos)
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
