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
                        boolean contains = containsInThisBox(box1,board[i][j]);
                        if(!contains){return false;}
                    }else if(j <=5){
                        boolean contains = containsInThisBox(box2,board[i][j]);
                        if(!contains){return false;}
                    }else{
                        boolean contains = containsInThisBox(box3,board[i][j]);
                        if(!contains){return false;}
                    }
                }else if(i <= 5){
                    if(j <= 2){
                        boolean contains = containsInThisBox(box4,board[i][j]);
                        if(!contains){return false;}
                    }else if(j <=5){
                        boolean contains = containsInThisBox(box5,board[i][j]);
                        if(!contains){return false;}
                    }else{
                        boolean contains = containsInThisBox(box6,board[i][j]);
                        if(!contains){return false;}
                    }
                }else{
                    if(j <= 2){
                        boolean contains = containsInThisBox(box7,board[i][j]);
                        if(!contains){return false;}
                    }else if(j <=5){
                        boolean contains = containsInThisBox(box8,board[i][j]);
                        if(!contains){return false;}
                    }else{
                        boolean contains = containsInThisBox(box9,board[i][j]);
                        if(!contains){return false;}
                    }
                }
                boolean containsInRow = containsInThisRowOrColumn(rowMap,board[i][j],i);
                if(!containsInRow){return false;}
                boolean containsInCol = containsInThisRowOrColumn(colMap,board[i][j],j);
                if(!containsInCol){return false;}
            }
            }
        }
        return true;
    }
    private boolean containsInThisBox(Set<Character> box, char ch){
        if(box.contains(ch)){return false;}
        else{box.add(ch);}
        return true;
    }
    private boolean containsInThisRowOrColumn(Map<Integer,Set<Character>> rowOrColMap, char ch, Integer key){
        if(!rowOrColMap.containsKey(key)){
            rowOrColMap.put(key,new HashSet<>());
        }
        if(rowOrColMap.get(key).contains(ch)){return false;}
        rowOrColMap.get(key).add(ch);
        return true;
    }
}