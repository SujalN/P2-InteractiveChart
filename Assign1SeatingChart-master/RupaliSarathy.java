import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The  class is used as a model that represents my seating location, name, hobbies, and hardest concepts in Java in AP CSA
 * 
 * @author Rupali Sarathy
 * @version 2.0 Sep 5, 2019
 */
public class RupaliSarathy extends Student implements SpecialInterestOrHobby
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
    public RupaliSarathy(String f, String l, int r, int s) {
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
     * The default constructor that defines my full name and seat locaiton.
     * Sets images and sound files for my portrait. Location is defined by seat, and (1,1) is the upper corner
     * of the classroom.
     */
    public RupaliSarathy() {
        firstName="Rupali";
        lastName="Sarathy";
        myRow=3;
        mySeat=4;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - this does whatever the RupaliSarathy actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment. In this scenario, the actor is told to say its name and implement an interface
     * when they are standing up. From here, it also goes on to implement the CircleClass, in which the RupaliSarathy actor moves around.
 
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
            
                myHobby("I love to make and listen to music!");
                
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
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */

    public void answerQuestion(){
        String q=Greenfoot.ask("My name is Rupali Sarathy! What would you like to know?");
        if (q.contains("hard")){
          q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
          /*if (q.equals("2D arrays")){
              q=Greenfoot.ask("A 2D array has a type such as int[][] or String[][], with two pairs of square brackets. The elements of a 2D array are arranged in rows and columns, and the new operator for 2D arrays specifies both the number of rows and the number of columns. May I sit down?");
              if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();}
          if (q.equals("recursion")){
              q=Greenfoot.ask("A recursion is a method that calls itself continuously. May I sit down?");
              if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();}
          if (q.equals("merge sort")){
              q=Greenfoot.ask("Merge sort is a divide and conquer algorithm. It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. May I sit down?");
              if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();}*/}
          if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?");
          if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
        }

    }
}

    /**
     * This is a local method specific to the RupaliSarathy class used to animate the character once the image is clicked on.
     * This method makes the actor RupaliSarathy travel around the class in random locations.
     */
    
   public void circleClass(){

        Greenfoot.delay(10);

        // move right
        int movel[][] = new int[30][2];
        for (int i=0; i<movel[i].length; i++){
        
          for (int j=1;j<=9;j++){
            setLocation((int)(Math.random()*8)+1, (int)(Math.random()*8)+1);
            Greenfoot.delay(10);
          }
        
          for (int j=5;j>=0;j--){
            setLocation((int)(Math.random()*8)+1, (int)(Math.random()*8)+1);
            Greenfoot.delay(10);
          }   
           Greenfoot.delay(10);
           returnToSeat();
        }
    }

  
 public void myHobby(String s) {
         System.out.println(s);
}

}
         

