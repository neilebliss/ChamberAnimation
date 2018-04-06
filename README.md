Particle Animation Modeller

This project depends on Maven and uses Java 1.7 or later.

Usage: mvn package; java -classpath target/oci-challenge-1.0-SNAPSHOT.jar com.buildingt.ChamberAnimation [startingFrame]

The optional starting frame should be a quoted string depicting the initial state of a 1d chamber, containing particle elements.
Particle elements are defined in the Particle package, initial values are '<', '>', 'X', and ' '.

Problem statement:

 The challenge is to model a chamber with particles! Given a string (that represents a chamber), model the contents of the chamber until the chamber is empty. A chamber of length N is represented by a string of length N. Spaces represent empty locations in the chamber. A > represents a right traveling particle. A < represents a left traveling particle. An “X” represents two overlapping particles: one traveling right, the other left. All particles travel one space per interval.

 Implements the function

 (golang function signature)
 func Animate(chamber string) (frames []string)

 Some examples:

 given “>  “ Animate outputs
 “>  “
 “ > “
 “  >”
 “   “

 Given “XXX” Animate outputs
 “XXX"
 “<X>”
 “< >”
 “   “
