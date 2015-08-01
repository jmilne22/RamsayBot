package james;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.jibble.pircbot.*;
import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;

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
            // list of quotes
            quotes.add("I mean, families are weird.");
            quotes.add("I don't run restaurants that are out of control. We are about establishing phenomenal footholdings with talent.");
            quotes.add("Try not to throw it on there, yeah? We're fucking cooking, we're not playing darts!");
            quotes.add("Chimichangas? Chimi-chuck it in the bin");
            quotes.add("Look at that. Overcooked on the bottom, crispy as fuck and it looks like Ghandi's flip flop!");
            quotes.add("I'd like to think I'm a great teacher.");
            quotes.add("It's Raw!");
            quotes.add("The public should have the right at any time to walk into the kitchen and see how the food is being prepared. You go into a dentist's office and you look around and you're so comfortable with the pristineness. Kitchens should be the same way.");
            quotes.add("Raw Carrot?! Fine if you're a fucking rabbit!");
            quotes.add("eh! All of you! come here!! taste it! taste it, taste it, taste it!!!");
            quotes.add("I am still learning… I'm still getting better.");
            quotes.add("My life has been an incredible rollercoaster ride.");
            quotes.add("I don't give a shit.");
            quotes.add("I don't want to see a wimp - I can't stand wimps.");
            quotes.add("Wow! Look at that sign, what is that, a big capital S, lets hope that doesn't stand for shit");
            quotes.add("It looked like chappy took a crappy in my gumbo");
            quotes.add("My biggest nightmare would be if the kids ever came up to me and said Dad, I'm a vegetarian.' Then I would sit them on the fence and electrocute them.");
            quotes.add("I've never ever ever ever ever met someone...I believe in as little as you.");
            quotes.add("This fucking pigeon is that raw that it can still fly!");
            quotes.add("Oh my God. Right now I'd rather eat poodle shit than put that in my mouth");
            quotes.add("I hid myself in food.");
            quotes.add("That's common sense Joe! And your tiny mind is not common!");
            quotes.add("Don't just stand there like a big fucking muffin!");
            quotes.add("I want my cooking to be able to say: That's me on the plate.");
            quotes.add("I'm not a smarmy-arse.");
            quotes.add("I don't want to produce clones.");
            quotes.add("I hate the smell of poo.");
            quotes.add("I wouldn't trust you running a bath, let alone a fucking restaurant.");
            quotes.add("Why did the chicken cross the road? Because you didn't fucking cook it.");
            quotes.add("The chicken is pinker than your fucking lipstick.");
            quotes.add("The decour is hideous");
            quotes.add("What a shame.");
            quotes.add("Look at that, it's like a bisons penis. What is that shit?");
            quotes.add("Where's the lamb sauce! Where's the lamb sauce!");
            quotes.add("What happens in Vegas should stay in Vegas, right? And honestly, what happened in that kitchen should've stayed in that kitchen");
            quotes.add("The dish is clumsy...just like you!");
            quotes.add("You can't turn an oven on. You got no chance at even running a kitchen.");
            quotes.add("If that was the last thing in this country to eat, I'd fucking starve.");
            quotes.add("You've got a palate like a cow's back side.");
            quotes.add("I wish you would jump in the oven, that would make my life a lot easier");
            quotes.add("Sounds like the fucking weirdo on Dr. Phil.");
            quotes.add("You're so full of shit your eyes are brown");
            quotes.add("It's like toenails. From a fucking dinosaur.");
            quotes.add("It's still walking that fucking piece of meat.");
            quotes.add("The chicken is drier than a donkey's dick in a desert storm");
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
        /**
         *
         *
         *
         * !FLICKR COMMAND
         *
         *
         *
         */
        if (message.startsWith("!flickr")) {
            try {
                String search = message.replace("!flickr", "");
                String apiKey = "ccbcc57af608de6a75d11621b31a5d53";
                String sharedSecret = "81da7eefdecfde72";
                
                // construct flickr object
                Flickr f = new Flickr(apiKey, sharedSecret, new REST());
                
                // construct photo interface
                PhotosInterface photoInterface = f.getPhotosInterface();
                
                // construct search paramters
                SearchParameters searchParams = new SearchParameters();
                searchParams.setText(search); // test for now
                // get random photo
                Random rand = new Random();
                int n = rand.nextInt(5000) + 1;
                
                PhotoList<Photo> photos = photoInterface.search(searchParams, 1, n);
                int i = 1;
                for (Photo photo1 : photos) {
                    ++i;
                    sendMessage(channel, photo1.getUrl() + " / " + photo1.getTitle());
                }
            } catch (FlickrException ex) {
                Logger.getLogger(RamsayBot.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
