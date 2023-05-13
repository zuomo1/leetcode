//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9578 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //用来保存链表头结点
        ListNode result = new ListNode(0);
        //用作可移动的节点
        ListNode current= result;
        //pre用来存进位
        int pre=0;
        while(l1!=null || l2!=null){
            //cur用来存当前值
            int cur=0;
            //获取值并移动l1和l2的指针
            if(l1!=null){
                cur += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                cur += l2.val;
                l2 = l2.next;
            }
            //如果上一次有进位，先加上进位，再重置进位为0
            if(pre>0){
                cur += pre;
                pre = 0;
            }
            //如果当前值大于10，提取进位，并更新当前值cur
            if(cur>=10){
                pre = cur / 10;
                cur = cur % 10;
            }
            //存储节点并后移
            current.next = new ListNode(cur);
            current = current.next;
        }
        //处理剩余的进位
        if(pre>0){
            current.next = new ListNode(pre);
        }
        //返回头结点的下一个节点，因为result存的是new ListNode(0)，result.next才是真正需要的开始节点
        return result.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
