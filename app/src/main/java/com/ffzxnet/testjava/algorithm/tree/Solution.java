package com.ffzxnet.testjava.algorithm.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if(root == null) {
            return returnList;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode n = stack.pop();
            returnList.add(n.val);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }

        }
        return returnList;
    }
}
