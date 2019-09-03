import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class DaylenBoen extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the KilgoreTrout class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public DaylenBoen(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"sitting" + ".jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public DaylenBoen() {
        firstName="Daylen";
        lastName="Boen";
        myRow=3;
        mySeat=2;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"sitting" + ".jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("BLUEFACE BABY YEAH AIGHT");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                blinkClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("Interfaces, ");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        
    }
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void blinkClass(){
        int tempRow; //used to change row of image
        int tempSeat; //used to change seat of image
        //Math.random is used to generate a random number with a minium of row, column 1,1 and a maximum of row, column 7, 7. It is used
        //to place my profile picture randomly in the classroom. It is also used to set my rotation randomly each time I change.
        int [][] seatLayout = new int[10][5]; //declaring a 2d array with rough estimates of the dimension of the classroom
        
        setRotation((int)(Math.random() * 359 + 1)); //uses Math.random to set rotation to a random number of degrees
        //iterates through array to make image move up to down
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tempRow = i;
                tempSeat = j;
                Greenfoot.delay(2);
                setLocation(tempRow,tempSeat);
            }
        }
        
        
        setRotation((int)(Math.random() * 359 + 1));//uses Math.random to set rotation to a random number of degrees
        //iterates through array to make image move right to left until it is back at original seat
        for (int j = 5; j >= myRow; j--) {
            for (int i = 10; i >= mySeat; i--) {
                tempRow = i;
                tempSeat = j;
                Greenfoot.delay(2);
                setLocation(tempRow,tempSeat);
            }
        }
        
        setRotation(0); //makes image go back to original rotation
        
    }
     public void myHobby(String s) {
         System.out.println(s);
}

}