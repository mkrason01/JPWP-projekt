public class Sentences {
    private int time;
    private int level;

    public Sentences() {
    }

    private int generateRandom() {
        int rand = (int) ((Math.random() * (4 - 1)) + 1);
        return rand;
    }

    public String sentence(int level) {
        this.level = level;
        String sentenceToSend = " ";
        int sentNum = this.generateRandom();
        if (this.level == 1) {
            if (sentNum == 1) {
                sentenceToSend = "Mam jednego brata   ";
                this.time = 4;
            }
            if (sentNum == 2) {
                sentenceToSend = "Robot na drodze sprawia problemy   ";
                this.time = 5;
            }
            if (sentNum == 3) {
                sentenceToSend = "Andrzej ma osiem lat i dwa psy   ";
                this.time = 5;
            }
            if (sentNum == 4) {
                sentenceToSend = "Rabarbar to giga dobry owoc   ";
                this.time = 5;
            }
        }
        if (this.level == 2) {
            if (sentNum == 1) {
                sentenceToSend = "Grzegorz ma bardzo pojemne płuca   ";
                this.time = 6;
            }
            if (sentNum == 2) {
                sentenceToSend = "Anakonda to bardzo niebezpieczny wąż   ";
                this.time = 7;
            }
            if (sentNum == 3) {
                sentenceToSend = "Uzbekistan znajduje się koło Tadżykistanu   ";
                this.time = 7;
            }
            if (sentNum == 4) {
                sentenceToSend = "Papież to bardzo szanowany człowiek   ";
                this.time = 6;
            }
        }
        if (this.level == 3) {
            if (sentNum == 1) {
                sentenceToSend = "król karol kupił królowej karolinie korale koloru koralowego   ";
                this.time = 8;
            }
            if (sentNum == 2) {
                sentenceToSend = "Wyrewolwerowany rewolwerowiec wyrewolwerował wyrewolwanego rewolwerowca   ";
                this.time = 9;
            }
            if (sentNum == 3) {
                sentenceToSend = "234435456657   ";
                this.time = 8;
            }
            if (sentNum == 4) {
                sentenceToSend = "Grzegorz brzęczyszczykiewicz chrząszczyżewoszyce powiat łękołody   ";
                this.time = 8;
            }
        }
        return sentenceToSend;
    }

    public int sentTime() {
        int time = this.time;
        return time;
    }
}
