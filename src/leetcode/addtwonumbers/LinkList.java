package leetcode.addtwonumbers;

/**
 * @Author: 98050
 * @Time: 2018-11-02 15:43
 * @Feature: 单链表
 */
public class LinkList {
    /**
     * 头节点
     */
    ListNode first;

    public LinkList() {
        this.first=null;
    }

    /**
     * 头插法增加节点
     * @param data
     */
    public void addFirstAlvinNode(int data){
        //实例化一个新的node
        ListNode node=new ListNode(data);
        node.next=first;
        first=node;
    }

    public void addEndNode(int data){
        //初始化要加入的节点
        ListNode newNode = new ListNode(data);

        //临时节点
        ListNode temp = first;

        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }

        // 已经包括了头节点.next为null的情况了～
        temp.next = newNode;
    }

    /**
     * 查询所有的node
     */
    public void displayAllNode(){
        ListNode current=first;
        System.out.println("所有的结点信息：");
        while(current!=null){
            current.display();
            current=current.next;
        }
    }
}
