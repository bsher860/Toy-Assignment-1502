package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class junit {
@Test
public static int testUserInput(InputStream in,PrintStream out) { 
Scanner keyboard = new Scanner(in); 
out.println("Give a number between 1 and 10"); 
int input = keyboard.nextInt(); while (input < 1 || input > 10) { out.println("Wrong number, try again."); 
input = keyboard.nextInt(); } return input; 
}

@Test
public void testExceptionAndState() {
  List<Object> arrList = new ArrayList<>();

  IndexOutOfBoundsException thrown = assertThrows(
      IndexOutOfBoundsException.class,
      () -> arrList.add(1, new Object()));

  // assertions on the thrown exception
  assertEquals("Index: 1, Size: 0", thrown.getMessage());
  // will assert the state of the domain of the object after the exception is thrown
  assertTrue(arrList.isEmpty());
  
}

@Test
public void testIntArrayList()
{
   ArrayList<Integer> l = new ArrayList<Integer>();
   l.add(5);
   l.add(-14);
   l.add(29);
   assertEquals(l.size(),3);
   assertEquals(l.get(0),5);
   assertEquals(l.get(1),-14);
   assertEquals(l.get(2),29);
}



@Test
 public void readFileRelativePath() {
     File file = new File("res/toyfile");
     assertTrue(file.exists());
 }

}
