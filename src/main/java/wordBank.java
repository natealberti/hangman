import java.util.Random;

public class wordBank {

    int difficulty;

    public wordBank(int difficulty) {
        this.difficulty = difficulty;
    }

    // pick random word
    public String getWord() {
        // word banks
        String[] easy = {
                "hello",
                "world",
                "games",
                "planet",
                "vehicle",
                "charger",
                "cloud",
        };
        String[] medium = {
                "sat",
                "willful",
                "logo",
                "mousepad",
                "resurrect",
                "wrangle",
                "continent",
        };
        String[] hard = {
                "absurd",
                "ivory",
                "flyby",
                "duplex",
                "queue",
                "rhubarb",
                "yummy",
        };


        // code to generate random word from the appropriate word bank
        Random rand = new Random();
        int gen = rand.nextInt(6);
        if(difficulty==1)
            return easy[gen];
        if(difficulty==2)
            return medium[gen];
        if(difficulty==3)
            return hard[gen];
        return "";
    }

}
