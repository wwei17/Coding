package LeetCode;
import java.util.HashMap;


public class MaxPointsOnALine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] ps = new Point[3];
		ps[0] = new Point(1,1);
		ps[1] = new Point(1,1);
		ps[2] = new Point(4,5);
		Solution s = new Solution();
		
		
		
		//System.out.println(s.maxPoints(ps));
		
	}

}

class Solution1 {
    public int maxPoints(Point[] points) {
        HashMap map = new HashMap<Line, Integer>();
        if(points == null || points.length == 0){
            return 0;
        }else if(points.length == 1){
            return 1;
        }
          
        map.put(new Line(points[0],points[1]),2);
        for(int i =2; i<points.length; i++){
            /*Iterator it = map.keySet().iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                Line l = (Line)entry.getKey();
                if(l.isInLine(points[i])){
                    map.put(l, (int)(map.get(l))+1);
                }
            }*/
            for(Object l : map.keySet()){
                if(((Line)l).isInLine(points[i])){
                    map.put(((Line)l), (int)(map.get(((Line)l)))+1);
                }  
            }
            
            
            for(int j = 0; j < i-1; j++){
                Line l = new Line(points[i], points[j]);
                if(!map.containsKey(l)){
                    map.put(l,2);
                }
            }
        }
        
        int max = -1;
        for(Object a : map.values()){
            if((int)a > max){
                max = (int)a;
            }
        }
        return max;
    }
}


class Point {
	int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
//ax+b=y
class Line{
  double a; double b;
  int HV = '/';
  Line(Point p1, Point p2){
	  if(Math.abs(p1.y-p2.y) < 0.01 && Math.abs(p1.x-p2.x) < 0.01){
		  HV = 'p';
		  a = p1.x;
		  b = p1.y;
	  }else if(Math.abs(p1.x-p2.x) < 0.01){
		  HV = 'v';
		  a = p1.x; 
	  }else if(Math.abs(p1.y-p2.y) < 0.01){
		  HV = 'h';
		  b = p1.y; 
	  }else{
	      a=(p2.y-p1.y)*1.0/(p2.x-p1.x);
	      b=p2.y-a*p2.x; 
	  }
  }
  public boolean equals(Object ob){
      Line l = (Line)ob;
      if(l.HV == 'p' && Math.abs(l.a-a)<0.01 && Math.abs(l.b-b)<0.01){
    	  return true;
      }else if(	(l.HV == 'v' && Math.abs(l.a-a)<0.01) ||
    		  	(l.HV == 'h' && Math.abs(l.b-b)<0.01)){
    	  return true;
      }else if(l.HV == '/' && Math.abs(l.a-a)<0.01 && Math.abs(l.b-b)<0.01){
          return true;
      }else{
          return false;
      }
  }
  
  public boolean isInLine(Point p){
	  if(HV == 'p'){
		  return true;
	  }else if(HV == '/' && Math.abs(p.x*a+b-p.y) < 0.01){
         return true;
      }else if(HV=='v' && Math.abs(p.x - a) < 0.01){
         return true;
      }else if(HV=='h' && Math.abs(p.y - b) < 0.01){
    	  return true;
      }else{
    	  return false;
      }
  }
  
}