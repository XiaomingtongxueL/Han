package Test;


public class test {
    public static void main(String[] args) {
       int[][] map = new int[8][7]; //0表示可以走，1表示障碍物. 2表示走过
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for(int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }

        map[4][1] = 1;
        map[4][2] = 1;

        mice escap = new mice();
        escap.escape(map,1,1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}

class mice {
    public boolean escape(int[][] map, int i, int j) {
        if (map[7][6] == 2)
            return true;
        else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (escape(map, i + 1, j)) {
                    return true;
                }else if (escape(map, i, j + 1)){
                    return true;
                }else if (escape(map, i - 1, j)) {
                    return true;
                }else return escape(map, i, j - 1);
            }
            else{
                return false;
            }
        }
    }
}