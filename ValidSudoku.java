// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(null == board || 0 == board.length){return true;}
        Set<Character> box1 = new HashSet<>();
        Set<Character> box2 = new HashSet<>();
        Set<Character> box3 = new HashSet<>();
        Set<Character> box4 = new HashSet<>();
        Set<Character> box5 = new HashSet<>();
        Set<Character> box6 = new HashSet<>();
        Set<Character> box7 = new HashSet<>();
        Set<Character> box8 = new HashSet<>();
        Set<Character> box9 = new HashSet<>();
        Map<Integer,Set<Character>> rowMap = new HashMap<>();
        Map<Integer,Set<Character>> colMap = new HashMap<>();
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.'){
                if(i <= 2){
                    if(j <= 2){
                        if(box1.contains(board[i][j])){return false;}
                        else{box1.add(board[i][j]);}
                    }else if(j <=5){
                        if(box2.contains(board[i][j])){return false;}
                        else{box2.add(board[i][j]);}
                    }else{
                        if(box3.contains(board[i][j])){return false;}
                        else{box3.add(board[i][j]);}
                    }
                }else if(i <= 5){
                    if(j <= 2){
                        if(box4.contains(board[i][j])){return false;}
                        else{box4.add(board[i][j]);}
                    }else if(j <=5){
                        if(box5.contains(board[i][j])){return false;}
                        else{box5.add(board[i][j]);}
                    }else{
                        if(box6.contains(board[i][j])){return false;}
                        else{box6.add(board[i][j]);}
                    }
                }else{
                    if(j <= 2){
                        if(box7.contains(board[i][j])){return false;}
                        else{box7.add(board[i][j]);}
                    }else if(j <=5){
                        if(box8.contains(board[i][j])){return false;}
                        else{box8.add(board[i][j]);}
                    }else{
                        if(box9.contains(board[i][j])){return false;}
                        else{box9.add(board[i][j]);}
                    }
                }
                if(!rowMap.containsKey(i)){
                    rowMap.put(i,new HashSet<>());
                }
                if(rowMap.get(i).contains(board[i][j])){return false;}
                rowMap.get(i).add(board[i][j]);
                if(!colMap.containsKey(j)){
                    colMap.put(j,new HashSet<>());
                }
                if(colMap.get(j).contains(board[i][j])){return false;}
                colMap.get(j).add(board[i][j]);
            }
            }
        }
        return true;
    }
}