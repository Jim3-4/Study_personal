import javax.swing.text.Position;

class Solution {
Position left;
Position right;
Position numPos;

public String solution(int[] numbers, String hand){
    String answer="";
    left=new Position(3,0);
    right=new Position(3,2);
    for (int i : numbers) {
        numPos=new Position((i-1)/3,(i-1)%3);
        if(num==0){
            numPos=new Position(3,1);
        }
        String finger=numPos.getFinger(hand);
        answer+=finger;

        if(finger.equals("L")){
            left=numPos;
        
        }else{
            right=numPos;
        }
        return answer;
    }
}

}
class Position{
int row;
int col;

public Position(int row, int col){
    this.row=row;
    this.col=col;
}
public String getFinger(String hand){
    String finger=hand.equals("right")?"R":"L";
    if(this.col==0) finger="L";
    else if(this.col==2) finger="R";
    else{
        int leftDist=left.getDistance(this);
        int rightDist=right.getDistance(this);
        
        if(leftDist<rightDist){
            finger="L";
        }else if(leftDist>rightDist){
            finger="R";
        }
        return finger;
    } 
}
public int getDistance(Position p) {
    return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
}
}