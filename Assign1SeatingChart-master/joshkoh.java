import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class joshkoh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class joshkoh extends Student implements SpecialInterestOrHobby
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
    public joshkoh(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        redboneFile="redbone.wav";
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public joshkoh() {
        firstName="Josh";
        lastName="Koh";
        myRow=1;
        mySeat=1;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        redboneFile="redbone.wav";
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
                getName();
                sayName(soundFile);
                
                // Talk about my hobby
                myHobby("I build robots!");
                
                // Calls my actions
                mlg();
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
        System.out.println("My name is " + firstName + " " + lastName + ".");
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("Sorry I came up so close. What would you like to know about my sister?");
        q = q.toLowerCase();
        if (q.contains("who") || q.contains("what") || q.contains("why") || q.contains("where"))
        {
            q=Greenfoot.ask("Christy Koh goes to Berkeley and does EECS. " + 
            "She's done many famous projects such as Stay On Course, Noh Snap, and Blindsight. " + 
            "During her time at high school, she was president of the robotics club, the chemistry club, etc, etc. \n" + 
            "Everyone who talks to me only asks about Christy anyway, so this spiel is kind of memorized. Any other questions?");
        
            if (q.contains("Yes"))
            {
                
            }
        }
        
        else 
        {
          q=Greenfoot.ask("I don't think that was a question... I'll sit down now."); 
        }
        
    }
    public void mlg(){
       // Short delay to allow JoshKoh.wav to finish playing
       Greenfoot.delay(70);
       
       // Change the image to the standing image file, and play redbone.wav
       setImage(standingFile);
       
       GreenfootImage image = getImage();
       
       sayName(redboneFile);
       
       // Create new 2D Array:
       int[][] sizing_list = new int[73][2];
       sizing_list[0][0] = 100;
       sizing_list[0][1] = 125;
       
       int size_limit = 45;
       
       // Set X and Y dimentions for the image, but stop increasing at 
       // 100*size_limit and 125*size_limit so that greenfoot doesn't start
       // freaking out.
       for (int i=1;i<size_limit;i++) 
       {
           sizing_list[i][0] = 100*i;
           sizing_list[i][1] = 125*i;
       }
       
       // Implement size_limit, with maximum at the number of columns in
       // the 2D array.
       for (int i=size_limit;i<73;i++) 
       {
           sizing_list[i][0] = sizing_list[size_limit-1][0];
           sizing_list[i][1] = sizing_list[size_limit-1][1];
       }
       
       // Rotate and Scale the image using Math.random() and the 2D array,
       // respectively. 
       
       int rotate_amt = (int)(Math.random() * 10) + 5; // Randomizer
       
       for (int i=0;i<72;i++)
       {
           // Set rotation
           setRotation(getRotation() + 10);
           
           // Resize image
           image.scale(sizing_list[i][0],sizing_list[i][1]);
           
           // Refresh images so that rotation and resizes are saved
           setImage(image);
           
           // Delay for the sake of sanity
           Greenfoot.delay(5);
       }
       
       // Delay to ensure that the song is finished 
       Greenfoot.delay(100);
       
       // Reset the image to the original dimentions and rotation
       image.scale(100,125);
       setRotation(0);
    }
    public void myHobby(String s) {
        System.out.println(s);
    }

}
