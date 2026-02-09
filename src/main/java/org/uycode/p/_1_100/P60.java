package org.uycode.p._1_100;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/05/2025 13:51:06
 */

public class P60 {

    public static void main(String[] args) {
        //Integer[] nums = {5,6,2,4,null,null,1,3,5};
        Integer[] nums = {6,0,3,null,8};
        Helpers helpers = new Helpers();
        TreeNode root = helpers.buildTree(nums);
        System.out.println(getMaxLayerSum(root));
    }

    public static int getMaxLayerSum(TreeNode root) {


        Map<Integer, Integer> maxPerLevel = new HashMap<>();

        checkSum(root, maxPerLevel);

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> pre = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                pre.offer(node);

                if (node == null) continue;

                if (levelSize > 1 && node.left != null && node.right != null) {
                    pre.poll();
                }

                if(node.left != null) {
                    if (node.right == null) {
                        pre.peek().left = node.left;
                        checkSum(root, maxPerLevel);
                        pre.peek().left = node;
                    }
                    queue.offer(node.left);
                } else {
                    if (node.right == null) {
                        pre.peek().left = null;
                        checkSum(root, maxPerLevel);
                        pre.peek().left = node;
                    }
                }
                if (node.right != null) {
                    if (node.left == null) {
                        pre.peek().right = node.right;
                        checkSum(root, maxPerLevel);
                        pre.peek().right = node;
                        //
                    }
                    queue.offer(node.right);
                } else {
                    if (node.left == null) {
                        pre.peek().right = null;
                        checkSum(root, maxPerLevel);
                        pre.peek().right = node;
                    }
                }
            }

            if (levelSize > 1) {
                pre.poll();
            }
        }



        return 0;
    }

    private static void checkSum(TreeNode root, Map<Integer, Integer> maxPerLevel) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelIndex =0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node == null) continue;

                levelSum+=node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            int prev = maxPerLevel.getOrDefault(levelIndex, -10001);
            maxPerLevel.put(levelIndex++, Math.max(prev, levelSum));

        }
        //maxPerLevel.put(levelIndex, 0);
        System.out.println(maxPerLevel);

    }
}
