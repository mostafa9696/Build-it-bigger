package com.example;

import java.util.ArrayList;
import java.util.Random;

public class GenerateJokes {
    ArrayList<String>Jokes;

    public GenerateJokes() {
        Jokes=new ArrayList<>();
        Jokes.add("Patient: Doctor, I have a pain in my eye whenever I drink tea."+"\n" +
                "Doctor: Take the spoon out of the mug before you drink. ");
        Jokes.add("Patient: Doctor! You've got to help me! Nobody ever listens to me. No one ever pays any attention to what I have to say."+"\n" +
                "Doctor: Next please! ");
        Jokes.add("A snail walks into a bar and the barman tells him there's a strict policy about having snails in the bar and so kicks him out. A year later the same snail re-enters the bar and asks the barman What did you do that for?");
        Jokes.add("Mother: Did you enjoy your first day at school?" +"\n" +
                "Girl: \"First day? Do you mean I have to go back tomorrow? ");
        Jokes.add("A: Hey, man! Please call me a taxi."+ "\n" +
                "B: Yes, sir. You are a taxi. ");
    }
    public String GetJoke()
    {
        Random random=new Random();
        String Joke=Jokes.get(random.nextInt(4));
        return Joke;
    }


}
