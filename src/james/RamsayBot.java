package james;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.jibble.pircbot.*;
import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RamsayBot extends PircBot {

    public RamsayBot() {
        this.setName("RamsayBot");
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        /**
         *
         *
         *
         * RAMSAYBOT QUOTES
         *
         *
         *
         */
        if (message.equalsIgnoreCase("!ramsay")) {
            ArrayList<String> quotes = new ArrayList<String>();
            // list of gordan ramsay quotes
            quotes.add("I mean, families are weird.");
            quotes.add("I don't run restaurants that are out of control. We are about establishing phenomenal footholdings with talent.");
            quotes.add("Chimichangas? Chimi-chuck it in the bin");
            quotes.add("I'd like to think I'm a great teacher.");
            quotes.add("It's Raw!");
            quotes.add("The public should have the right at any time to walk into the kitchen and see how the food is being prepared. You go into a dentist's office and you look around and you're so comfortable with the pristineness. Kitchens should be the same way.");
            quotes.add("eh! All of you! come here!! taste it! taste it, taste it, taste it!!!");
            quotes.add("I am still learning… I'm still getting better.");
            quotes.add("My life has been an incredible rollercoaster ride.");
            quotes.add("I don't want to see a wimp - I can't stand wimps.");
            quotes.add("It looked like chappy took a crappy in my gumbo");
            quotes.add("My biggest nightmare would be if the kids ever came up to me and said Dad, I'm a vegetarian.' Then I would sit them on the fence and electrocute them.");
            quotes.add("I've never ever ever ever ever met someone...I believe in as little as you.");
            quotes.add("I hid myself in food.");
            quotes.add("That's common sense Joe! And your tiny mind is not common!");
            quotes.add("I want my cooking to be able to say: That's me on the plate.");
            quotes.add("I'm not a smarmy-arse.");
            quotes.add("I don't want to produce clones.");
            quotes.add("The decour is hideous");
            quotes.add("What a shame.");
            quotes.add("Where's the lamb sauce! Where's the lamb sauce!");
            quotes.add("What happens in Vegas should stay in Vegas, right? And honestly, what happened in that kitchen should've stayed in that kitchen");
            quotes.add("The dish is clumsy...just like you!");
            quotes.add("You can't turn an oven on. You got no chance at even running a kitchen.");
            quotes.add("You've got a palate like a cow's back side.");
            quotes.add("I wish you would jump in the oven, that would make my life a lot easier");
            quotes.add("It's fine...as far as rabbit food goes.");

            // get a random quote
            int randomWord = new Random().nextInt(quotes.size());
            String random = quotes.get(randomWord);
            sendMessage(channel, random);
            /**
             *
             *
             *
             * Random !commands for links
             *
             *
             *
             */
        } // display link for monotone bingo
        else if (message.equalsIgnoreCase("!bingo")) {
            sendMessage(channel, "https://dl.dropboxusercontent.com/u/32724868/bingo/bingo.html");

        } // Ramsaybot die joke
        else if (message.equalsIgnoreCase("RamsayBot die")) {
            sendMessage(channel, "Dinner service isn't over yet!");
        } // command to kill ramsay
        else if (message.equalsIgnoreCase("Dinner service is over")) {
            sendMessage(channel, "No, it's not.");
        } // Doesn't kill Jaden anymore but I'm keeping it anyways
        else if (message.equalsIgnoreCase("!killjaden")) {
            sendMessage(channel, "‘‘‘‘‘‘‘");
        } // Link to monotone booru
        else if (message.equalsIgnoreCase("!booru")) {
            sendMessage(channel, "http://mono.booru.org");
        } // Link to nintendo spreadsheet
        else if (message.equalsIgnoreCase("!nnid")) {
        	sendMessage(channel, "http://pyor.us/nnid");
        } // Link to QDB
        else if(message.equalsIgnoreCase("!qdb")) {
        	sendMessage(channel,"http://qdb.pyor.us/");
        }
        /**
         *
         *
         *
         * !WEATHER COMMAND
         *
         *
         *
         */
        // declare object
        OpenWeatherMap owm = new OpenWeatherMap("32cde1c9becb27f854084e325067f525");
        if (message.startsWith("!weather")) {
            // store user input in a String variable
            String city = message.replace("!weather", "");

            try {
                // get weather for city
                CurrentWeather cwd = owm.currentWeatherByCityName(city);
                // check if the city is valid
                if (cwd.isValid()) {
                    cwd = owm.currentWeatherByCityName(city);
                    if (cwd.getMainInstance().hasTemperature()) {
                        // calculate celcius 
                        float celciusTemp = (cwd.getMainInstance().getTemperature() - 32) * 5 / 9;

                        sendMessage(channel, cwd.getCityName() + " Temperature " + cwd.getMainInstance().getTemperature() + "F" + " / " + String.format("%2.1f", celciusTemp) + "C" + " / " + cwd.getMainInstance().getHumidity() + " " + "%" + " humidity");
                    }
                }

            } catch (IOException | JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
