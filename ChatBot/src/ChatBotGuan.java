//October 4, 2017
//add first response method to determine the name and if user says no it would be to the do u want to help question which might not be a negative comment 

import java.util.Random;

public class ChatBotGuan {
	//emotion can alter the way our bot responds. Emotion 
	//can become more negative or positive over time.
		int emotion = 0;
		/**
		 * Get a default greeting 	
		 * @return a greeting
		 */	
		public String getGreeting()
		{
			return "I'm having a horrible day, are you sure you want to help me?";
		}
		
		/**
		 * Gives a response to a user statement
		 * 
		 * @param statement
		 *            the user statement
		 * @return a response based on the rules given
		 */
		public String getResponse(String statement)
		{
			String response = "";
			
			if (statement.length() == 0)
			{
				response = "If you're not going to say something, leave.";
			}

			else if (findKeyword(statement, "bye") >= 0)
			{
				if(emotion > 0)
					response = "Thanks, I kinda feel better.";
				else if(emotion <= 0)
					response = "Wow, you're as uselsess as I am.";
			}
			
			/*else if (findKeyword(statement, "no") >= 0)
			{
				if(statement.length() < 2)
				{
					response = "Fine, bye.";
	                emotion--;
				}
	            else if(statement.length() > 2)
	            {
	            	response = transformNoStatement(statement);
	            }
			}*/
			
			else if (findKeyword(statement, "yes") >= 0)
			{
				response = "Fine, what is your name? And answer in complete sentences, don't be annoying annoying.";
	                	emotion++;
			}
			
			else if (findKeyword(statement, "help you") >= 0)
			{
				response = "I failed my test today. What am I gonna do?";
	                	emotion++;
			}
			
			else if (findKeyword(statement, "I don't know") >= 0)
			{
				response = "Then go away.";
	                	emotion--;
			}
			
			else if (findKeyword(statement, "you fell better") >= 0)
			{
				response = "I will never feel better.";
	                	emotion++;
			}
			
			else if (findKeyword(statement, "My name is", 0) >= 0)
			{
				response = transformMyNameIsStatement(statement);
			}
			
			else if (findKeyword(statement, "Maybe you can", 0) >= 0)
			{
				response = "I don't want to.";
			}

			// Response transforming I want to statement
			
			else if (findKeyword(statement, "I want to", 0) >= 0)
			{
				response = transformIWantToStatement(statement);
			}
			
			else if (findKeyword(statement, "I want", 0) >= 0)
			{
				response = transformIWantStatement(statement);
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
			return "Nice to meet you, " + restOfStatement;
		}
		
		/**
		 * Take a statement with "I want to <something>." and transform it into 
		 * "Why do you want to <something>?"
		 * @param statement the user statement, assumed to contain "I want to"
		 * @return the transformed statement
		 */
		private String transformIWantToStatement(String statement)
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
			int psn = findKeyword (statement, "I want to", 0);
			String restOfStatement = statement.substring(psn + 9).trim();
			return "Why do you want to " + restOfStatement + "?";
		}

		
		/**
		 * Take a statement with "I want <something>." and transform it into 
		 * "Would you really be happy if you had <something>?"
		 * @param statement the user statement, assumed to contain "I want"
		 * @return the transformed statement
		 */
		private String transformIWantStatement(String statement)
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
			int psn = findKeyword (statement, "I want", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return "Would you really be happy if you had " + restOfStatement + "?";
		}
		
		
		/**
		 * Take a statement with "I <something> you" and transform it into 
		 * "Why do you <something> me?"
		 * @param statement the user statement, assumed to contain "I" followed by "you"
		 * @return the transformed statement
		 */
		private String transformIYouStatement(String statement)
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
			
			int psnOfI = findKeyword (statement, "I", 0);
			int psnOfYou = findKeyword (statement, "you", psnOfI);
			
			String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
			return "Why do you " + restOfStatement + " me?";
		}
		

		
		
		/**
		 * Search for one word in phrase. The search is not case
		 * sensitive. This method will check that the given goal
		 * is not a substring of a longer string (so, for
		 * example, "I know" does not contain "no").
		 *
		 * @param statement
		 *            the string to search
		 * @param goal
		 *            the string to search for
		 * @param startPos
		 *            the character of the string to begin the
		 *            search at
		 * @return the index of the first occurrence of goal in
		 *         statement or -1 if it's not found
		 */
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
				if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && 
					((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
					// before is not a letter
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
		 * @param statement the string to search
		 * @param goal the string to search for
		 * @return the index of the first occurrence of goal in statement or -1 if it's not found
		 */
		private int findKeyword(String statement, String goal)
		{
			return findKeyword (statement, goal, 0);
		}
		


		/**
		 * Pick a default response to use if nothing else fits.
		 * @return a non-committal string
		 */
		private String getRandomResponse ()
		{
			Random r = new Random ();
			if (emotion == 0)
			{	
				return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
			}
			if (emotion < 0)
			{	
				return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
			}	
			return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
		}
		
		private String [] randomNeutralResponses = {"Interesting, I think you can help me.",
				"I don't think that is helpful",
				"Do you really think so?",
				"Maybe.",
				"Could you say that again?"
		};
		private String [] randomAngryResponses = {"You're of no help.", "Do you want to fight?", "Don't talk to me."};
		private String [] randomHappyResponses = {"Wow, that is a good idea!", "Thank you, you make me feel better."};
		
}