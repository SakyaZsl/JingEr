package com.zlj.jinger.utils;

import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class Test {

    LinkedList linkedList=new LinkedList();


    void  test(){
        View.MeasureSpec measureSpec=new View.MeasureSpec();
        View.MeasureSpec.getMode(100);
        View.MeasureSpec.getSize(100);
    }

    class  Node{
        int num;
        Node next;

        public Node(int num, Node next) {
            this.num = num;
            this.next = next;
        }

        public Node(int num) {
            this.num = num;
        }
    }
    private void init(){

    }

    private void sort(){
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        Node aux=new Node(0,node1);
        Node pre=node1;
        Node cur=node1.next;

        while(cur!=null){
            if(pre.num>=cur.num){
                pre=cur;
                cur=cur.next;
                continue;
            }
            pre.next=cur.next;
            Node node11=aux;
            Node node22=aux.next;


        }

        while (pre.next!=null){
            if(pre.num>=pre.next.num){
                pre=pre.next;
                continue;
            }
            cur=pre.next;

            Node temp=pre.next;
            pre.next=temp.next;
            temp.next=pre;
            aux.next=temp;
        }

    }
}
