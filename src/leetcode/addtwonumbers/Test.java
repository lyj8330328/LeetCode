package leetcode.addtwonumbers;

import org.w3c.dom.NodeList;

/**
 * @Author: 98050
 * @Time: 2018-11-02 15:16
 * @Feature: 两数相加
 */
public class Test {

    public static void main(String[] args) {

        LinkList linkList = new LinkList();
        linkList.addFirstAlvinNode(9);
        linkList.addFirstAlvinNode(9);
        linkList.addFirstAlvinNode(9);
        linkList.displayAllNode();

        LinkList linkList2 = new LinkList();
        linkList2.addFirstAlvinNode(1);
//        linkList2.addFirstAlvinNode(6);
//        linkList2.addFirstAlvinNode(4);
        linkList2.displayAllNode();

        LinkList linkList3 = add(linkList,linkList2);
        linkList3.displayAllNode();
    }

    public static LinkList add(LinkList list1,LinkList list2){
        ListNode dummyHead = new ListNode(0);
        LinkList linkList = new LinkList();
        ListNode p = list1.first, q = list2.first, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            linkList.addFirstAlvinNode(sum % 10);
            if (p != null){ p = p.next;}
            if (q != null){ q = q.next;}
        }
        if (carry > 0) {
            linkList.addFirstAlvinNode(carry);
        }
        return linkList;
    }
}
