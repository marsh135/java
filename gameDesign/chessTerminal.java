import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class chessTerminal {
  
  public static class piece{
    String type = "WP";
    int[] location = new int[]{0,0};
    public boolean checkmove(int[] pos){
        ArrayList<int[]> possiblemoves = new ArrayList<int[]>();
        if (type.equals("WP")){
            if (check(combine(location,-1,0)).equals("e")){
                possiblemoves.add(combine(location,-1,0));
            }
            if ((location[0] == 6)&&check(combine(location,-2,0)).equals("e")){
                possiblemoves.add(combine(location,-2,0));
            }
            if (check(combine(location,-1,1)).equals("x")){
                possiblemoves.add(combine(location,-1,1));
            }
            if (check(combine(location,-1,-1)).equals("x")){
                possiblemoves.add(combine(location,-1,-1));
            }
        }
        if (type.equals("BP")){
            if (check(combine(location,1,0)).equals("e")){
                possiblemoves.add(combine(location,1,0));
            }
            if (location[0] == 1&&check(combine(location,2,0)).equals("e")){
                possiblemoves.add(combine(location,2,0));
            }
            if (check(combine(location,1,1)).equals("x")){
                possiblemoves.add(combine(location,1,1));
            }
            if (check(combine(location,1,-1)).equals("x")){
                possiblemoves.add(combine(location,1,-1));
            }
        }
        if (type.endsWith("R")||type.endsWith("Q")){
            boolean up = true;
            boolean down = true;
            boolean left = true;
            boolean right = true;
            for (int i = 0; i < 8; i++){
                if (!check(combine(location,i+1,0)).equals("i")&&down){
                    possiblemoves.add(combine(location,i+1,0));
                }
                else{
                    down = false;
                }
                if (!check(combine(location,-i-1,0)).equals("i")&&up){
                    possiblemoves.add(combine(location,-i-1,0));
                }
                else{
                    up = false;
                }
                if (!check(combine(location,0,i+1)).equals("i")&&right){
                    possiblemoves.add(combine(location,0,i+1));
                }
                else{
                    right = false;
                }
                if (!check(combine(location,0,-i-1)).equals("i")&&left){
                    possiblemoves.add(combine(location,0,-i-1));
                }
                else{
                    left = false;
                }
            }
        }
        if (type.endsWith("B")||type.endsWith("Q")){
            boolean upright = true;
            boolean upleft = true;
            boolean downright = true;
            boolean downleft = true;
            for (int i = 0; i < 8; i++){
                if (!check(combine(location,-i-1,i+1)).equals("i")&&upright){
                    possiblemoves.add(combine(location,-i-1,i+1));
                }
                else{
                    upright = false;
                }
                if (!check(combine(location,-i-1,-i-1)).equals("i")&&upleft){
                    possiblemoves.add(combine(location,-i-1,-i-1));
                }
                else{
                    upleft = false;
                }
                if (!check(combine(location,i+1,i+1)).equals("i")&&downright){
                    possiblemoves.add(combine(location,i+1,i+1));
                }
                else{
                    downright = false;
                }
                if (!check(combine(location,i+1,-i-1)).equals("i")&&downleft){
                    possiblemoves.add(combine(location,i+1,-i-1));
                }
                else{
                    downleft = false;
                }
            }
        }
        if (type.endsWith("N")){
            if (!check(combine(location,-2,1)).equals("i")){
                possiblemoves.add(combine(location,-2,1));
            }
            if (!check(combine(location,2,1)).equals("i")){
                possiblemoves.add(combine(location,2,1));
            }
            if (!check(combine(location,-2,-1)).equals("i")){
                possiblemoves.add(combine(location,-2,-1));
            }
            if (!check(combine(location,2,-1)).equals("i")){
                possiblemoves.add(combine(location,2,-1));
            }
            if (!check(combine(location,1,2)).equals("i")){
                possiblemoves.add(combine(location,1,2));
            }
            if (!check(combine(location,-1,2)).equals("i")){
                possiblemoves.add(combine(location,-1,2));
            }
            if (!check(combine(location,1,-2)).equals("i")){
                possiblemoves.add(combine(location,1,-2));
            }
            if (!check(combine(location,-1,-2)).equals("i")){
                possiblemoves.add(combine(location,-1,-2));
            }
        }
        if (type.endsWith("K")){
            if (!check(combine(location,-1,0)).equals("i")){
                possiblemoves.add(combine(location,-1,0));
            }
            if (!check(combine(location,-1,1)).equals("i")){
                possiblemoves.add(combine(location,-1,1));
            }
            if (!check(combine(location,0,1)).equals("i")){
                possiblemoves.add(combine(location,0,1));
            }
            if (!check(combine(location,1,1)).equals("i")){
                possiblemoves.add(combine(location,1,1));
            }
            if (!check(combine(location,1,0)).equals("i")){
                possiblemoves.add(combine(location,1,0));
            }
            if (!check(combine(location,1,-1)).equals("i")){
                possiblemoves.add(combine(location,1,-1));
            }
            if (!check(combine(location,0,-1)).equals("i")){
                possiblemoves.add(combine(location,0,-1));
            }
            if (!check(combine(location,-1,-1)).equals("i")){
                possiblemoves.add(combine(location,-1,-1));
            }
        }

        for (int[] move : possiblemoves) {
            if (Arrays.equals(move, pos)) {

                return true;
            }
        }

        return false;
    }
    @Override
    public String toString() {
        return "Chess Piece {"+type+"} y:"+location[0]+" x:"+location[1]+"\n";
    }
  }
  public static class move{
    String[] destination = {"",""};
    String[] piecelocation = {"",""};
    String piece = "";
    String promote = "";
    @Override
    public String toString() {
        return "Move Destination{"+destination[0]+","+destination[1]+"}, Piecelocation{"+piecelocation[0]+","+piecelocation[1]+"}, Piece{"+piece+"}, Promote{"+promote+"}\n";
    }
  }
  public static Scanner inputscaner = new Scanner(System.in);
  public static boolean whiteturn = true;
  public static piece[][] board = new piece[8][8];
  
  

  public static void main(String[] args) {
    
    for (int y = 0; y < board.length; y++){
        for (int x = 0; x < board[y].length;x++){
            board[y][x] = new piece();
            board[y][x].location[0] = y;
            board[y][x].location[1] = x;
            if (y == 0){
                switch(x){
                    case 0:
                    case 7:
                        board[y][x].type = "BR";
                        break;
                    case 1:
                    case 6:
                        board[y][x].type = "BN";
                        break;
                    case 2:
                    case 5:
                        board[y][x].type = "BB";
                        break;
                    case 3:
                        board[y][x].type = "BQ";
                        break;
                    case 4:
                        board[y][x].type = "BK";
                        break;
                }
            }
            if (y == 1){
                board[y][x].type = "BP";
            }
            if (y == 2||y == 3||y == 4|| y == 5){
                board[y][x].type = "EE";
            }
            if (y == 6){
                board[y][x].type = "WP";
            }
            if (y == 7){
                switch(x){
                    case 0:
                    case 7:
                        board[y][x].type = "WR";
                        break;
                    case 1:
                    case 6:
                        board[y][x].type = "WN";
                        break;
                    case 2:
                    case 5:
                        board[y][x].type = "WB";
                        break;
                    case 3:
                        board[y][x].type = "WQ";
                        break;
                    case 4:
                        board[y][x].type = "WK";
                        break;
                }
            }
        }
    }
    turn();
    }
    
    public static move translate(String moveinput){
        String[] temparray = {"",""};
        move output = new move();

        //<EXPORT>
        String[] destination = {"",""};
        String[] piecelocation = {"",""};
        String piece = "";
        String promote = "";
        //<EXPORT>

        int indexstart = 0;
        int indexend = 0;
        ArrayList<String> movestringarray = new ArrayList<String>(Arrays.asList(moveinput.split("")));
        ArrayList<String> locationcharletter = new ArrayList<String>();
        ArrayList<String> locationcharnumber = new ArrayList<String>();
        locationcharletter.add("a");
        locationcharletter.add("b");
        locationcharletter.add("c");
        locationcharletter.add("d");
        locationcharletter.add("e");
        locationcharletter.add("f");
        locationcharletter.add("g");
        locationcharletter.add("h");
        locationcharnumber.add("1");
        locationcharnumber.add("2");
        locationcharnumber.add("3");
        locationcharnumber.add("4");
        locationcharnumber.add("5");
        locationcharnumber.add("6");
        locationcharnumber.add("7");
        locationcharnumber.add("8");
        boolean dubbledig = false;
        for (int i = 0; i < movestringarray.size(); i++){
            if (!(i+1 > movestringarray.size())){
                if (locationcharletter.contains(movestringarray.get(i))&&locationcharnumber.contains(movestringarray.get(i+1))){
                    if ((temparray[0] == ""||temparray[1] == "")){
                        temparray[0] = movestringarray.get(i);
                        temparray[1] = movestringarray.get(i+1);
                        indexstart = i;
                        indexend = i+1;
                    }
                    else{
                        dubbledig = true;
                        piecelocation = temparray;
                        destination[0] = movestringarray.get(i);
                        destination[1] = movestringarray.get(i+1);
                        indexend = i+1;
                    }
                }
            }
        }
        if (dubbledig == false){
            destination = temparray;
            if (!(indexstart == 0)){
                if (locationcharletter.contains(movestringarray.get(indexstart-1))){
                    piecelocation[0] = movestringarray.get(indexstart-1);
                }
                if (locationcharnumber.contains(movestringarray.get(indexstart-1))){
                    piecelocation[1] = movestringarray.get(indexstart-1);
                }
            }
            else{
                piece = "P";
            }
        }
        ArrayList<String> types = new ArrayList<String>();
        types.add("R");
        types.add("N");
        types.add("B");
        types.add("K");
        types.add("Q");
        if (types.contains(movestringarray.get(0))){
            piece = movestringarray.get(0);
        }
        else{
            piece = "P";
        }
        if (types.contains(movestringarray.get(movestringarray.size()-1))){
            promote = movestringarray.get(movestringarray.size()-1); 
        }
        if (((destination[0] == ""||destination[1] == ""))||((piece == ""))){
            System.out.println("destination = "+destination[0]+","+destination[1]);
            System.out.println("piecelocation = "+piecelocation[0]+","+piecelocation[1]);
            System.out.println("piece = "+piece);
            System.out.println("promote = "+promote);
            System.out.println("There was an error in translate");
            System.exit(1);
        }
        output.destination = destination;
        output.piecelocation = piecelocation;
        output.piece = piece;
        output.promote = promote;
        return output;
    }
    
    public static String check(int[] pos){
        try{
            if (board[pos[0]][pos[1]].type.startsWith("E")){
                return "e";
            }
            else{
                if ((whiteturn&&board[pos[0]][pos[1]].type.startsWith("B"))||
                ((!(whiteturn))&&board[pos[0]][pos[1]].type.startsWith("W"))){
                    return "x";
                }
                else{
                    return "i";
                }
            }
            }
        catch(Exception e){
            return "i";
        }
    }
    public static void boardprint(){
      System.out.println("-------------------------");
      for (int i = 0; i != 8; i++){
        System.out.println("|"+board[i][0].type+"|"+board[i][1].type+"|"+board[i][2].type+"|"+board[i][3].type+"|"+board[i][4].type+"|"+board[i][5].type+"|"+board[i][6].type+"|"+board[i][7].type+"|");
      };
      System.out.println("-------------------------");
    }
    
    public static void turn(){
        boolean idiotloop = true;
        while (idiotloop){
                boardprint();
                if (whiteturn){
                System.out.println("White Turn:");
                }
                else{
                System.out.println("Black Turn:");
                }
                String temp = input("Enter Move : ");
                move moveinput = translate(temp);
                // System.out.println(moveinput);
                ArrayList<piece> pieces = new ArrayList<piece>();
                for (int y = 0; y < board.length; y++){
                    for (int x = 0; x < board[y].length; x++){
                        if (whiteturn){
                            if (board[y][x].type.startsWith("W")){
                                pieces.add(board[y][x]);
                            } 
                        }
                        else{
                            if (board[y][x].type.startsWith("B")){
                                pieces.add(board[y][x]);
                            } 
                        }
                    }
                }// gets all pieces of their type
                String lookfortype = null;
                if (whiteturn){
                    lookfortype = "W"+moveinput.piece;
                }
                else{
                    lookfortype = "B"+moveinput.piece;
                }
                for (int i = pieces.size()-1; i > -1; i--){
                    if (!(pieces.get(i).type.equals(lookfortype))){
                        pieces.remove(i);
                    }
                }// elim all not right piece
                //translate move destination into cords
                int[] transdes = new int[]{0,0};
                switch (moveinput.destination[0]){
                    case "a":
                        transdes[1] = 0;
                        break;
                    case "b":
                        transdes[1] = 1;
                        break;
                    case "c":
                        transdes[1] = 2;
                        break;
                    case "d":
                        transdes[1] = 3;
                        break;
                    case "e":
                        transdes[1] = 4;
                        break;
                    case "f":
                        transdes[1] = 5;
                        break;
                    case "g":
                        transdes[1] = 6;
                        break;
                    case "h":
                        transdes[1] = 7;
                        break;
                }
                switch (moveinput.destination[1]){
                    case "1":
                        transdes[0] = 7;
                        break;
                    case "2":
                        transdes[0] = 6;
                        break;
                    case "3":
                        transdes[0] = 5;
                        break;
                    case "4":
                        transdes[0] = 4;
                        break;
                    case "5":
                        transdes[0] = 3;
                        break;
                    case "6":
                        transdes[0] = 2;
                        break;
                    case "7":
                        transdes[0] = 1;
                        break;
                    case "8":
                        transdes[0] = 0;
                        break;
                }
                int[] transloc = new int[]{0,0};
                if (!(moveinput.piecelocation[0].equals("")&&moveinput.piecelocation[1].equals(""))){
                    switch (moveinput.piecelocation[0]){
                        case "a":
                            transloc[1] = 0;
                            break;
                        case "b":
                            transloc[1] = 1;
                            break;
                        case "c":
                            transloc[1] = 2;
                            break;
                        case "d":
                            transloc[1] = 3;
                            break;
                        case "e":
                            transloc[1] = 4;
                            break;
                        case "f":
                            transloc[1] = 5;
                            break;
                        case "g":
                            transloc[1] = 6;
                            break;
                        case "h":
                            transloc[1] = 7;
                            break;
                    }
                    switch (moveinput.piecelocation[1]){
                        case "1":
                            transloc[0] = 7;
                            break;
                        case "2":
                            transloc[0] = 6;
                            break;
                        case "3":
                            transloc[0] = 5;
                            break;
                        case "4":
                            transloc[0] = 4;
                            break;
                        case "5":
                            transloc[0] = 3;
                            break;
                        case "6":
                            transloc[0] = 2;
                            break;
                        case "7":
                            transloc[0] = 1;
                            break;
                        case "8":
                            transloc[0] = 0;
                            break;
                    }
                }
                else if ((!(moveinput.piecelocation[0].equals("")))&&(moveinput.piecelocation[1].equals("?"))){
                    switch (moveinput.piecelocation[0]){
                        case "a":
                            transloc[1] = 0;
                            break;
                        case "b":
                            transloc[1] = 1;
                            break;
                        case "c":
                            transloc[1] = 2;
                            break;
                        case "d":
                            transloc[1] = 3;
                            break;
                        case "e":
                            transloc[1] = 4;
                            break;
                        case "f":
                            transloc[1] = 5;
                            break;
                        case "g":
                            transloc[1] = 6;
                            break;
                        case "h":
                            transloc[1] = 7;
                            break;
                    }
                    transloc[0] = -1;
                }
                else if ((!(moveinput.piecelocation[1].equals("")))&&(moveinput.piecelocation[0].equals("?"))){
                    switch (moveinput.piecelocation[1]){
                        case "1":
                            transloc[0] = 7;
                            break;
                        case "2":
                            transloc[0] = 6;
                            break;
                        case "3":
                            transloc[0] = 5;
                            break;
                        case "4":
                            transloc[0] = 4;
                            break;
                        case "5":
                            transloc[0] = 3;
                            break;
                        case "6":
                            transloc[0] = 2;
                            break;
                        case "7":
                            transloc[0] = 1;
                            break;
                        case "8":
                            transloc[0] = 0;
                            break;
                    }
                    transloc[1] = -1;
                }
                for (int i = pieces.size()-1; i > (-1); i--){
                    if (!pieces.get(i).checkmove(transdes)){
                        pieces.remove(i);
                    }
                } // check all pieces for valid movment
                // System.out.println(pieces);

                if (pieces.size() > 1){
                    if (!moveinput.piecelocation[0].equals("")&&!moveinput.piecelocation[1].equals("")){
                        for (int i = pieces.size()-1; i > (-1); i--){
                            if ((!(pieces.get(i).location[0]==transloc[0]))||(!(pieces.get(i).location[1]==transloc[1]))){
                                pieces.remove(i);
                            }
                        }
                    }
                    else if (!moveinput.piecelocation[0].equals("")){
                        for (int i = pieces.size()-1; i > (-1); i--){
                            if ((!(pieces.get(i).location[1]==transloc[1]))){
                                pieces.remove(i);
                            }
                        }
                    }
                    else if (!moveinput.piecelocation[1].equals("")){
                        for (int i = pieces.size()-1; i > (-1); i--){
                            if ((!(pieces.get(i).location[0]==transloc[0]))){
                                pieces.remove(i);
                            }
                        }
                    }
                }
                // System.out.println(transloc[0]+","+transloc[1]);
                // System.out.println(pieces);
                if (pieces.size() == 1){
                    if (!(board[transdes[0]][transdes[1]].type.equals("EE"))){
                        board[transdes[0]][transdes[1]].type = "EE";
                    }
                    int[] temp3 = board[transdes[0]][transdes[1]].location;
                    board[transdes[0]][transdes[1]].location = pieces.get(0).location;
                    piece temp2 = board[transdes[0]][transdes[1]];
                    board[transdes[0]][transdes[1]] = pieces.get(0);
                    board[pieces.get(0).location[0]][pieces.get(0).location[1]] = temp2;
                    // System.out.println(pieces.get(0));
                    pieces.get(0).location = temp3;

                    if (!moveinput.promote.equals("")&&((pieces.get(0).type.equals("WP")&&pieces.get(0).location[0] == 0)||(pieces.get(0).type.equals("BP")&&pieces.get(0).location[0] == 7))){
                        ArrayList<String> tempstring = new ArrayList<String>(Arrays.asList(pieces.get(0).type.split("")));
                        pieces.get(0).type = (tempstring.get(0)+moveinput.promote);
                    }
                    else if (((pieces.get(0).type.equals("WP")&&pieces.get(0).location[0] == 0)||(pieces.get(0).type.equals("BP")&&pieces.get(0).location[0] == 7))){
                        ArrayList<String> tempstring = new ArrayList<String>(Arrays.asList(pieces.get(0).type.split("")));
                        pieces.get(0).type = (tempstring.get(0)+"Q");
                    }

                    if (whiteturn){
                        whiteturn = false;
                    }
                    else{
                        whiteturn = true;
                    }
                }
                
            }
        }

    
    public static String input(String text){
      System.out.print(text);
      return inputscaner.nextLine();
    }
    public static int[] combine(int[] pos,int y, int x){
        int[] temp = new int[]{pos[0]+y,pos[1]+x};
        return temp;
    }
}