//October 4, 2017
//add first response method to determine the name and if user says no it would be to the do u want to help question which might not be a negative comment 

import java.util.Random;

public class ChatBotGuan {
		int patience = -1;

		public String getGreeting()
		{
			return "I'm having a horrible day, are you sure you want to help me?(Please answer in complete sentences, I'm already in a bad mood!)";
		}
		
		public String getResponse(String statement)
		{
			String response = "";
			
			if (statement.length() == 0)
			{
				response = "If you're not going to say something, leave.";
				patience--;
			}
			
			else if (findKeyword(statement, "yes") >= 0 || findKeyword(statement, "ye") >= 0 || findKeyword(statement, "yeah") >= 0)
			{
				response = "Fine, what is your name?";
			}
			
			else if(findKeyword(statement, "My name is", 0) >= 0)
			{
				response = transformMyNameIsStatement(statement);
			}
			
			else if (findKeyword(statement, "no i",0) >= 0)
			{
				response = transformNoStatement(statement);
	                	patience--;
			}
			
			else if (findKeyword(statement, "no") >= 0)
			{
				response = "Then go away, bye.";
	                	patience--;
			}
			
			else if (findKeyword(statement, "help you") >= 0 || findKeyword(statement, "help u") >= 0 )
			{
				response = "Give me some advice.";
			}
			
			else if (findKeyword(statement, "I don't know") >= 0 || findKeyword(statement, "idk") >= 0 )
			{
				response = "Then how are you going to help me?";
	                	patience--;
			}
			
			else if (findKeyword(statement, "you feel better") >= 0)
			{
				response = "I will never feel better.";
	                	patience++;
			}
			
			else if (findKeyword(statement, "what subject") >= 0 || findKeyword(statement, "what test") >= 0 )
			{
				response = "I failed my AB Calculus test. It's so hard!!!";
	                	patience++;
			}
			
			else if (findKeyword(statement, "study") >= 0)
			{
				response = "I don't like studying.";
	                	patience--;
			}
			
			else if (findKeyword(statement, "go to tutoring") >= 0 || findKeyword(statement, "go tutor") >= 0)
			{
				response = "I don't have time.";
	                	patience--;
			}
			
			else if (findKeyword(statement, "tutor you") >= 0)
			{
				response = "Really, no thank you. I'll just pray for my next test.";
	                	patience--;
			}
			
			else if (findKeyword(statement, "listen in class") >= 0)
			{
				response = "I do, but my teacher teaches too fast.";
	                	patience--;
			}
			
			else if (findKeyword(statement, "ask questions") >= 0 || findKeyword(statement, "ask friends") >= 0)
			{
				response = "Everyone is clueless though.";
	                	patience--;
			}
			
			else if (findKeyword(statement, "who is your teacher") >= 0)
			{
				response = "That is a secret.";
	                	patience--;
			}
			
			else if (findKeyword(statement, "advice") >= 0 || findKeyword(statement, "ok") >= 0)
			{
				response = "Like what?";
	                	patience++;
			}
			
			else if (findKeyword(statement, "comfort you") >= 0)
			{
				response = "Give me some encouraging words.";
	                	patience++;
			}
			
			else if (findKeyword(statement, "Maybe you can", 0) >= 0)
			{
				response = transformMaybeYouCanStatement(statement);
						patience++;
			}
			
			else if (findKeyword(statement, "maybe") >= 0)
			{
				response = "So is it a yes or a no?";
	            patience--;
			}
			
			else
			{
				response = getRandomResponse();
			}
			
			return response;
		}
		
		private String transformNoStatement(String statement)
		{
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "No I", 0);
			String restOfStatement = statement.substring(psn + 4).trim();
			return "No you, " + restOfStatement + "?";
		}
		
		private String transformMyNameIsStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "My name is", 0);
			String restOfStatement = statement.substring(psn + 10).trim();
			return "I failed my test today, " + restOfStatement + ", what am I going to do?";
		}
		
		private String transformMaybeYouCanStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "Maybe you can", 0);
			String restOfStatement = statement.substring(psn + 13).trim();
			return "I don't want to " + restOfStatement + ".";
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
					after = phrase.substring(psn + goal.length(),psn + goal.length() + 1);
				}

				// If before and after aren't letters, we've
				// found the word
				if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a letter
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
				{
					return psn;
				}

				// The last position didn't work, so let's find
				// the next, if there is one.
				psn = phrase.indexOf(goal, psn + 1);

			}

			return -1;
		}
		
		/**
		 * Search for one word in phrase.  The search is not case sensitive.
		 * This method will check that the given goal is not a substring of a longer string
		 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
		 * */
		private int findKeyword(String statement, String goal)
		{
			return findKeyword (statement, goal, 0);
		}
		
		private String getRandomResponse ()
		{
			Random r = new Random ();
			if (patience == 0)
			{	
				return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
			}
			if (patience < 0)
			{	
				return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
			}	
			return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
		}
		
		private String [] randomNeutralResponses = {"I don't think that is helpful",
				"Do you really think so?",
				"Maybe.",
				"Could you say that again?"
		};
		private String [] randomAngryResponses = {"You're of no help.", "Do you want to fight? I said complete sentences.", "Don't talk to me."};
		private String [] randomHappyResponses = {"Wow, that is a good idea!", "Thank you, you make me feel better."};
		
}