package ies_108969;

import java.util.ArrayList;

public class Quotes {

        public ArrayList<String> movieQuotes = new ArrayList<String>();

        public ArrayList<Quote> quotes = new ArrayList<Quote>();

        public Quotes() {
        }

        public Quote getRandomQuote() {

                int random = (int) (Math.random() * quotes.size());
                return quotes.get(random);
        }

        public void loadQuotes() {

                movieQuotes.add("There's no place like home. - The Wizard of Oz (1939)");
                movieQuotes.add(
                                "You don't understand! I coulda had class. I coulda been a contender. I could've been somebody, instead of a bum, which is what I am. - On The Waterfront (1954)");
                movieQuotes.add("A martini. Shaken, not stirred. - Goldfinger (1964)");
                movieQuotes.add("Yo, Adrian!! - Rocky (1976)");
                movieQuotes.add(
                                "Oh! It's blessed are the meek! I'm glad they're getting something, they had a hell of a time... - Monty Python's Life of Brian (1979)");
                movieQuotes.add("Do, or do not. There is no 'try'. - Star Wars: Episode V - The Empire Strikes Back (1980)");
                movieQuotes.add(
                                "I changed the conditions of the test. I don't like to lose. - Star Trek II: The Wrath of Khan (1982)");
                movieQuotes.add("Death cannot stop true love - The Princess Bride (1987)");
                movieQuotes.add("You're killing me, smalls! - The Sandlot (1993)");
                movieQuotes.add(
                                "Oh yes, the past can hurt. But you can either run from it, or learn from it. - The Lion King (1994)");
                movieQuotes.add("Mama says stupid is as stupid does. - Forrest Gump (1994)");
                movieQuotes.add("You're taking all the caviar? That caviar is a garnish! - You've Got Mail (1998)");
                movieQuotes.add(
                                "Fear. Fear attracts the fearful… the strong… the weak… the innocent… the corrupt. Fear. Fear is my ally. - Star Wars: Episode I - The Phantom Menace (1999)");
                movieQuotes.add("You met me at a very strange time in my life - Fight Club (1999)");
                movieQuotes.add("Just keep swimming. - Finding Nemo (2003)");
                movieQuotes.add("Your identity is your most valuable possession. Protect it. - The Incredibles (2004)");
                movieQuotes.add("I wish I knew how to quit you. - Brokeback Mountain (2005)");
                movieQuotes
                                .add("I'm sorry father, for you there is only death. But our destiny is life! - The Fountain (2006)");
                movieQuotes.add("Death is the road to awe. - The Fountain (2006)");
                movieQuotes.add("If you're good at something, never do it for free. - The Dark Knight (2008)");
                movieQuotes.add("Sometimes you gotta run before you can walk - Iron Man 3 (2013)");
                movieQuotes.add(
                                "Look closer because the closer you think you are the less you actually see - Now You See Me (2013)");
                movieQuotes.add(
                                "Let us learn to show our friendship for a man when he is alive and not after he is dead. - The Great Gatsby (2013)");
                movieQuotes.add(
                                "If more people valued home above gold, this world would be a merrier place. - The Hobbit: The Battle of Five Armies (2014)");
                movieQuotes.add("I am the scales of justice, conductor of the choir of death! - Mad Max (2015)");
                movieQuotes.add("My tastes are very singular. - Fifty Shades of Grey (2015)");
                movieQuotes.add(
                                "Every time we get a chance to get ahead they move the finish line, every time. - Hidden Figures (2017)");
                movieQuotes.add(
                                "I have burrowed underneath your brain. I am nested there. I am the scream in your mind. You will cooperate. - Mr. Robot (2017)");
                movieQuotes.add("Today the impossible becomes the possible. - The Current War (2019)");

                for (String movieQuote : movieQuotes) {
                        String[] parts = movieQuote.split(" - ");
                        quotes.add(new Quote(parts[0], parts[1], quotes.size() + 1));
                }

        }

}
