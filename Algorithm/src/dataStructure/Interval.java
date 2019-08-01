package dataStructure;

public class Interval {

	 private int start;
     private int end;

     public Interval() {
         this.start = 0;
         this.end = 0;
     }

     public Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }

     public void set(int start, int end) {

         this.start = start;
         this.end = end;
     }

     public void setEnd(int end) {
         this.end = end;
     }

     public String print() {
         return "[" + start + "," + end + "]";
     }

     public void setStart(int start) {
         this.start = start;
     }

     public int getEnd() {
         return end;
     }

     public int getStart() {
         return start;
     }


}
