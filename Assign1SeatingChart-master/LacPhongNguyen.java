import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class LacPhongNguyen extends Student implements SpecialInterestOrHobby
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
    public LacPhongNguyen(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public LacPhongNguyen() {
        firstName="Lac-Phong";
        lastName="Nguyen";
        myRow=3;
        mySeat=1;
       //imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
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
            
                myHobby("I like to time travel!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
        System.out.println("I " + firstName + " " + lastName+ " have a dream");
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
            q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
            q.toLowerCase();
        }
        if (q.contains("yes")){
            sitDown();
        }
        if ((q.contains("hi"))||(q.contains("hello"))){
            q=Greenfoot.ask("Well hello there! I'm Lac-Phong Nguyen. How are you?");
            q.toLowerCase();
            if (q.contains("good")){
                q=Greenfoot.ask("Cool, but I don't care.");
                sitDown();
            }
            if (q.contains("bad")){
                q=Greenfoot.ask("Feelsbadman. Sucks to be you :P");
                sitDown();
            }
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else {
                answerQuestion();
            }
            
        }
         
        
    }
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        int[][] list = new int[10][10];
        for (int i=0;i<10;i++){
            for (int n=0;n<10;n++){
            list[i][n] = (int)Math.random()*10+1;
        }
       }
        setLocation(1,3);
        Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,3);
            turn(100);
            Greenfoot.delay(6);
        }
        // move back
        for (int i=5;i<=5;i++){
            setLocation(9,i);
            turn(100);
            Greenfoot.delay(6);
        }      
         // move left
        for (int i=5;i>=1;i--){
            setLocation(i,5);
            turn(100);
            Greenfoot.delay(6);
        }      
              // move Forward
        for (int i=5;i>=3;i--){
            setLocation(1,i);
            turn(100);
            Greenfoot.delay(6);
        }
        for (int i=0; i<10;i++){
            turn(list[(int)Math.random()*10+1][(int)Math.random()*10+1]);
            Greenfoot.delay(6);
        }
        Greenfoot.delay(20);
        returnToSeat();
    
}
     public void myHobby(String s) {
         System.out.println(s);
}

}