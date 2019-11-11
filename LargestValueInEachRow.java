// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NOPE.


// Your code here along with comments explaining your approach

class LargestValueInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root){return result;}
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Integer max;
        while(!q.isEmpty()){
            max = null;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(null == max){
                    max = temp.val;
                }else{
                    max = Math.max(max,temp.val);
                }
                if(null != temp.left){
                    q.offer(temp.left);
                }
                if(null != temp.right){
                    q.offer(temp.right);
                }
            }
            result.add(max);
        }
    return result;
    }
}