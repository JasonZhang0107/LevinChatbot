
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
					response = "I need you to say something.";
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
			else if(question != "looper"&&(findKeyword(statement.toLowerCase(), "yes") >= 0|| findKeyword(statement, "yeah")>= 0||findKeyword(statement, "yep")>=0||findKeyword(statement, "kind of")>=0|| findKeyword(statement, "ye")>= 0|| findKeyword(statement, "sort of")>= 0))
			{
				name = statement;
				if(findKeyword (statement.toLowerCase(), "My name is")>=0) {
					
					if(question == "name")
					{
						name = statement.substring(11);
					}
					else
					{
						response = "I already know your name, ";
					}
				responded = true;
				}
				if(question == "name")
				{
					
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
					response = "I hope I can help! What do you want to talk about?";
					question = "looper";
				}
				else if(question == "interested"&&!inRelationShip) 
				{
					response = "Great! Hopefully I can help. \nWhat do you want to talk about?";
					question = "looper";
				}
				else if(question == "noRes") {
					response = "You can type 'Bye' to exit this chat bot.";
					
				}
				else if (question == "listening") {
					response = "That's good to hear";
				}
				responded = true;
			}
			else if(question != "looper"&&(findKeyword(statement.toLowerCase(), "no") >= 0|| findKeyword(statement, "never")>= 0||findKeyword(statement, "nah")>=0||findKeyword(statement, "negative")>=0)||findKeyword(statement,"nope")>=0)
			{
				name = statement;
				if(question == "name")
				{
					if(findKeyword (statement.toLowerCase(), "My name is")>=0&&question == "name") 
					{
							name = name.substring(11);
					}
					else
					{
						name = statement;
					}
					response = "Hi, "+name+", I presume you came to see me for relationship advice.\nAre you currently in a relationship with someone?";
					question = "relations";
					if(findKeyword(name, "levin")>= 0||findKeyword(name, "nathan")>= 0)
					{
						response = "Oh, Mr. Levin! Sorry I didn't recognize you! You probably don't need relationship advice, but I'll ask anyway:\nAre you currently in a relationship with someone?";
					}
					responded = true;
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
					response = "I'm not sure that I can help you in that case. Might I reccomend another bot, such as Ahnaf's Existence Bot?";
					question = "noRes";
				}
				else if(question == "noRes") {
					response = "You can type 'Bye' to exit this chat bot.";
					
				}
				else if (question == "listening") {
					response = "That's good to hear";
					responded = true;
				}
				responded = true;
			}
			else {
				if(question == "name")
				{
					if(findKeyword (statement.toLowerCase(), "My name is")>=0&&question == "name") 
					{
							name = statement.substring(11);
					}
					else if(findKeyword (statement.toLowerCase(), "i'm")>=0&&question == "name") 
					{
							name = statement.substring(4);
					}
					else
					{
						name = statement;
					}
					response = "Hi, "+name+", I presume you came to see me for relationship advice.\nAre you currently in a relationship with someone?";
					question = "relations";
					if(findKeyword(name, "levin")>= 0||findKeyword(name, "nathan")>= 0)
					{
						response = "Oh, Mr. Levin! Sorry, I didn't recognize you! You probably don't need relationship advice, but I'll ask anyway:\nAre you currently in a relationship with someone?";
					}
					responded = true;
				}
				
				else if (question == "listening") {
					response = "That's good to hear";
					question = "looper";
					responded = true;
				}
				
				else if(question == "looper") {
					if(findKeyword(statement.toLowerCase(), "nothing" )>=0||findKeyword(statement.toLowerCase(), "not much")>=0)
					{
						response = "I can't really help you if you don't talk to me.";
					}
					else if(findKeyword(statement.toLowerCase(), "nervous")>=0&&!inRelationShip) 
					{
						response = "Being nervous is natural, lots of people feel nervous.";
					}
					else if(findKeyword(statement.toLowerCase(), "uh" )>=0||findKeyword(statement.toLowerCase(), "..." )>=0) {
						response = "You can get whatever you want off your chest, talk to me.";
					}
					else if(findKeyword(statement.toLowerCase(), "angry" )>=0 && inRelationShip) 
					{
						response = "If you make each other angry, I would recommend talking to each other about it, or going to couple's counseling.";
					}
					else if(findKeyword(statement.toLowerCase(), "hurt" )>=0||findKeyword(statement.toLowerCase(), "hit" )>=0||findKeyword(statement.toLowerCase(), "beat" )>=0||findKeyword(statement.toLowerCase(), "abuse" )>=0)
					{
						response = "If your partner has hit you or hurt you, I think you should break up with them. Abuse is unacceptable.";
					}
					else if(findKeyword(statement.toLowerCase(), "kms" )>=0||findKeyword(statement.toLowerCase(), "kill" )>=0||findKeyword(statement.toLowerCase(), "die" )>=0||findKeyword(statement.toLowerCase(), "murder")>=0||findKeyword(statement.toLowerCase(), "death" )>=0)
					{
						response = "Let's talk about something more positive, okay? Don't let the bad times drag you down.";
					}
					else if (findKeyword(statement, "I want to") >= 0)
					{
						statement = statement.trim();
						String lastChar = statement.substring(statement
								.length() - 1);
						if (lastChar.equals("."))
						{
							statement = statement.substring(0, statement
									.length() - 1);
						}
						int temp = findKeyword (statement, "I want to", 0);
						String restOfStatement = statement.substring(temp + 9).trim();
						response = "Why do you want to " + restOfStatement + "?";
					}
					else if (findKeyword(statement.toLowerCase(), "not sure" )>=0||findKeyword(statement.toLowerCase(), "don't know")>=0||findKeyword(statement.toLowerCase(), "dont know")>=0)
					{
						response = "Being unsure is fine, don't worry too much about it, alright?";
					}
					else if (findKeyword(statement.toLowerCase(), "i like")>=0) 
					{
						statement = statement.trim();
						String lastChar = statement.substring(statement
								.length() - 1);
						if (lastChar.equals("."))
						{
							statement = statement.substring(0, statement
									.length() - 1);
						}
						int temp = findKeyword (statement, "i like", 0);
						String restOfStatement = statement.substring(temp + 6).trim();
						response = "It's good you like " + restOfStatement + ". What do you like most about " + restOfStatement+"?";
						question = "listening";
					}
					else if(findKeyword(statement.toLowerCase(), "i love")>=0)
					{
						statement = statement.trim();
						String lastChar = statement.substring(statement
								.length() - 1);
						if (lastChar.equals("."))
						{
							statement = statement.substring(0, statement
									.length() - 1);
						}
						int temp = findKeyword (statement, "i love", 0);
						String restOfStatement = statement.substring(temp + 6).trim();
						response = "It's good you love " + restOfStatement + ". What do you love most about " + restOfStatement+"?";
						question = "listening";
					}
					else
					{
						response = "I'm not exactly sure what that is. Do you want to change the topic?";
					}
					
					responded = true;
				}
				else if(question == "noRes") {
					response = "You can type 'Bye' to exit this chat bot.";
					responded = true;
				}
				else {
					response = "You didn't answer my question.\n";
					responded = true;
				}
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
