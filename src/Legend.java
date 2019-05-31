import java.awt.Graphics;
import java.sql.SQLOutput;

public class Legend {
    public int r=0, c=0;
    private Tile[][] legend = new Tile[4][3];

    public Legend(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j< 3; j++){
                legend[i][j]= new Tile(0,i,j);
            }
        }
        legend[0][0].setValue(2);
    }
    public void addTile(int max){
        /**System.out.println("max = " + max);
        legend[(int)( (Math.log(max)/Math.log(2)) / 4)][(int)( (Math.log(max)/Math.log(2)) / 3)].setValue(max);
        **/

        if(r<3){
            r+=1;
        }else{
            c+=1;
            r = 0;
        }
        legend[r][c].setValue(max);
    }
    public void draw(Graphics g) {
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j<3; j++){
                legend[i][j].drawLeg(g);
            }
        }
    }
}

