
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class GauravAgarwal extends Student implements SpecialInterestOrHobby
{
   int array2d [] [] = new int [6] [10];
   boolean couldNotSit = false;
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
   public GauravAgarwal(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".mp3";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
   }
   /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
   public GauravAgarwal() {
        firstName="Gaurav";
        lastName="Agarwal";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+lastName.toLowerCase()+"-standing.jpg";
        soundFile= "Sounds/"+firstName.toLowerCase()+lastName.toLowerCase()+".mp3";
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
        if(Greenfoot.mouseClicked(this) || couldNotSit == true){
            if (sitting || couldNotSit == true){
                sitting=false;
                couldNotSit = false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                //sayName(soundFile);
                Greenfoot.playSound("gauravagarwal.mp3");
            
                myHobby("I like to hike and camp!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                moveClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
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
        boolean firstQuestion = false;
        boolean canUnderstand = false;
        String q=Greenfoot.ask("What would you like to know").toLowerCase();
        if (q.contains("hard")){
            q=Greenfoot.ask("I found 2D arrays, interfaces, remembering to put the semicolon, merge sort, and overloading hard. Which one would you like to know more about?");
            firstQuestion = true;
        }
        if (q.contains("array") && firstQuestion == true){
            q=Greenfoot.ask("A 2D array is an array of arrays! I actually used one to move around! Can I sit down now?");
            canUnderstand = true;
        }
        if (q.contains("interface") && firstQuestion == true){
            q=Greenfoot.ask("Java is similar to a class, but not quite; it's a collection of abstract methods. Can I sit down now?");
            canUnderstand = true;
        }
        if (q.contains("semicolon") && firstQuestion == true){
            q=Greenfoot.ask("Every command in java requires a semicolon at the end. Can I sit down now?");
            canUnderstand = true;
        }
        if (q.contains("merge") && firstQuestion == true){
            q=Greenfoot.ask("Merge sort is a divide and conquer algorithm that can sort a list from smallest to greatest. Can I sit down now?");
            canUnderstand = true;
        }
        if (q.contains("overload") && firstQuestion == true){
            q=Greenfoot.ask("Overloading a method lets two classes with the same name exist, if their argument lists are different. Can I sit down now?");
            canUnderstand = true;
        }
        if (!canUnderstand){
            q=Greenfoot.ask("I don't understand the question. Can I sit down?");
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else{
                couldNotSit = true;
                act();
            }
        }
        if (canUnderstand){
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else{
                couldNotSit = true;
                act();
            }
        }
    }
    
    public int randomWithRange(int min, int max){
    int rangevalue = (max - min) + 1;     
    return (int)(Math.random() * rangevalue) + min;
    }

    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void moveClass(){
        setLocation(0,0);
        Greenfoot.delay(5);
        // move right
        for (int i = 0; i < array2d.length; i++){
            for (int j = 0; j < array2d[0].length; j++){
            setLocation(i,j);
            setRotation(randomWithRange(0,360));
            Greenfoot.delay(2);
            }
        }
        Greenfoot.delay(2);
        returnToSeat();
    }
     public void myHobby(String s) {
         System.out.println(s);
    }

}