import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Celine Lafosse
 * @version 2.0 Aug 13, 2019
 */
public class CelineLafosse extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the CelineLafosse class.
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
    public CelineLafosse(String f, String l, int r, int s) {
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
    public CelineLafosse() {
        firstName="Celine";
        lastName="Lafosse";
        myRow=4;
        mySeat=3;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the CelineLafosse actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
                
                myHobby("I like to draw!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();
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
            q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
        
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
     * This is a local method specific to the CelineLafosse class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    private int j = 1;
    public void animation(){
        while(j<=9){
                j++;
                String animationSlide = "ani" + (j) + ".JPG" ;
                setImage(animationSlide);
                Greenfoot.delay(8);
                if (j >= 7) { 
                    j = 0;
                }
            }
    }
    public void move(){
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(5);
        }
    }
    public void circleClass(){
        setLocation(0,0);
         Greenfoot.delay(5);
        // move right
        for (int i=1;i<=9;i++){
            animation();
            setLocation(i,0);
            Greenfoot.delay(5);
        }
        Greenfoot.delay(10);
        setImage(standingFile); 
        returnToSeat();
        //The rest below here is for the full circle of the same animation:
        /*if (i>7){
                String animationSlide = "ani" + "1" + ".JPG";
            }*/
            
            
            /*Long Version of Code
             * running animation
            setImage("ani1.JPG");
            Greenfoot.delay(5); 
            setImage("ani2.JPG");
            Greenfoot.delay(5); 
            setImage("ani3.JPG");
            Greenfoot.delay(5); 
            setImage("ani4.JPG");
            Greenfoot.delay(5); 
            setImage("ani5.JPG");
            Greenfoot.delay(5); 
            setImage("ani6.JPG");
            Greenfoot.delay(5); 
            setImage("ani7.JPG");*/
        // move back
        /*for (int i=1;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(5);
            //running animation
            setImage("ani1.JPG");
            Greenfoot.delay(3); 
            setImage("ani2.JPG");
            Greenfoot.delay(3); 
            setImage("ani3.JPG");
            Greenfoot.delay(3); 
            setImage("ani4.JPG");
            Greenfoot.delay(3); 
            setImage("ani5.JPG");
            Greenfoot.delay(3); 
            setImage("ani6.JPG");
            Greenfoot.delay(3); 
            setImage("ani7.JPG");
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            Greenfoot.delay(5);
            //running animation
            setImage("ani1.JPG");
            Greenfoot.delay(3); 
            setImage("ani2.JPG");
            Greenfoot.delay(3); 
            setImage("ani3.JPG");
            Greenfoot.delay(3); 
            setImage("ani4.JPG");
            Greenfoot.delay(3); 
            setImage("ani5.JPG");
            Greenfoot.delay(3); 
            setImage("ani6.JPG");
            Greenfoot.delay(3); 
            setImage("ani7.JPG");
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(5);
            //running animation
            setImage("ani1.JPG");
            Greenfoot.delay(3); 
            setImage("ani2.JPG");
            Greenfoot.delay(3); 
            setImage("ani3.JPG");
            Greenfoot.delay(3); 
            setImage("ani4.JPG");
            Greenfoot.delay(3); 
            setImage("ani5.JPG");
            Greenfoot.delay(3); 
            setImage("ani6.JPG");
            Greenfoot.delay(3); 
            setImage("ani7.JPG");
        }   */
    }
     public void myHobby(String s) {
         System.out.println(s);
        }

}