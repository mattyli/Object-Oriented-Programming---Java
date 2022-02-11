import java.util.Random; 

public class GuessMaster {
    private int numberOfCandidateEntities;
    private int szOfArr = 10;           // Setting the default array size to 10, change if you desire
    private Entity[] entities = new Entity[szOfArr];

    // class constructor
    public GuessMaster(){
        numberOfCandidateEntities = 0; // array needs to have a size
        entities = new Entity[]{null, null, null, null, null, null, null, null, null, null};    // need to initialize the array, this would have to change
                                                                                                // depending on the array size, (NOT DYNAMIC)
    }

    public void addEntity(Entity entity){
        entities[numberOfCandidateEntities] = new Entity(entity); // using the copy constructor
        numberOfCandidateEntities++; // incrementing the # of entities
    }

    public void playGame(Entity entity){
        Date guess = new Date();    // creating new date object that will store guess made by user
        Boolean tryAgain = true;
        System.out.printf("Guess %s' birthday!\n", entity.getName());
        while(tryAgain){
            guess.readInput();
            if (entity.getBorn().equals(guess)){
                System.out.println("Bingo you got it!");
                tryAgain = false;
            }
            else{
                if (guess.precedes(entity.getBorn())){
                    System.out.println("Try a later date");
                }
                else{
                    System.out.println("Try an earlier date");
                }
            }
        }
        System.out.println();
        playGame(genRandomEntityInd()); // calling the game again (repeats until the user quits)
    }

    /**
     *  The conditional statement here catches all cases where the program tries to play the game with
     *  an index that has been set to null (which would obviously not work).
     *  Instead it randomly picks another index to play the game with. 
     */
    public void playGame(int entityInd){
        if(entities[entityInd] == null){
            System.out.println("Sorry this field has not been intialized");
            playGame();
        }
        else{
            playGame(entities[entityInd]);
        }
    }

    public void playGame(){
        playGame(genRandomEntityInd());
    }

    // helper function 
    public int genRandomEntityInd(){
        Random rnd = new Random();
        int ind = rnd.nextInt(szOfArr);
        return ind;
    }

    public static void main(String[] args){
        GuessMaster gm = new GuessMaster();

        Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
        Entity faketrudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
        Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
        Entity usa = new Entity("United States", new Date("July", 4, 1776));
        Entity Matty = new Entity("Matthew Li", new Date("November", 15, 2002));
        Entity Canada = new Entity("Canada", new Date("July", 1, 1867));
       
        gm.addEntity(trudeau);
        gm.addEntity(faketrudeau);
        gm.addEntity(dion);
        gm.addEntity(usa);
        gm.addEntity(Matty);
        gm.addEntity(Canada);

        System.out.println(Boolean.toString(trudeau.equals(faketrudeau)));
        System.out.println(Boolean.toString(trudeau.equals(Matty)));

       

        // game starts here
        gm.playGame();
    }
}
