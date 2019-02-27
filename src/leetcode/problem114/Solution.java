package leetcode.problem114;


class Solution {
    public void flatten(TreeNode root) {
       if (root == null){
           return;
       }
       if (root.left != null){
           flatten(root.left);
       }
       if (root.right != null){
           flatten(root.right);
       }
       TreeNode temp = root.right;
       root.right = root.left;
       root.left = null;
       while (root.right != null){
           root = root.right;
       }
       root.right = temp;

    }

    public void flatten2(TreeNode root){
        TreeNode temp = root;
        while (temp != null){
            if (temp.left != null){
                TreeNode temp2 = temp.left;
                while (temp2.right != null){
                    temp2 = temp2.right;
                }
                temp2.right = temp.right;
                temp.right = temp.left;
                temp.left = null;
            }
            temp = temp.right;
        }
    }

}