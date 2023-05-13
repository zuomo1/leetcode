package com.zm.leetcode.demos.web;

public class TwoNoPlusWithOther {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));

        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
