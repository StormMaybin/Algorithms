package com.stormma.day4;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class MainG 
{
    class Node 
    {
        int[] max = new int[3];// S,M,N
        int[] v = new int[3];//这个数组用来保存这个状态时候瓶子和两个杯子的状态
        int count;

        public Node clone() 
        {
            Node node = new Node();
            for (int i = 0; i < 3; i++) 
            {
                node.max[i] = max[i];
                node.v[i] = v[i];
                node.count = count;
            }
            return node;
        }
    }
    Scanner input;
    boolean[] hash = new boolean[100 * 100 * 100 + 100 * 100 + 100];
    LinkedList<Node> list = new LinkedList<Node>();

    public static void main(String[] args)
    {
        new MainG().work();
    }

    public int hashing(Node node) 
    {
        return node.v[0] * 10000 + node.v[1] * 100 + node.v[2];
    }

    public void work() 
    {
        input = new Scanner(System.in);
        while (input.hasNext()) 
        {
            list.clear();//清空list
            Arrays.fill(hash, false);//初始化hash数组为false
            Node head = new Node();//定义一个Node类的对象
            head.max[0] = input.nextInt();//S
            head.max[1] = input.nextInt();//M
            head.max[2] = input.nextInt();//N
            head.v[0] = head.max[0];//初始化瓶子最大的体积
            head.count = 0;//初始化倒水的次数
            input.nextLine();
            if (hashing(head) == 0)
                break;//输入0 0 0停止的作用
            list.addLast(head);//容器添加元素
            //以下是两个剪枝
            if (head.max[0] % 2 == 1)
            {
            	System.out.println("NO");
            	continue;
            }
            else if (head.max[1] == head.max[2])
            {
            	System.out.println("1");
            	continue;
            }
            else
            	bfs();//开始搜索
        }
    }
    //判断是否倒水操作是否已经平分了
    public boolean check(Node node)
    {
        if ((node.v[0] == node.v[1] && node.v[2] == 0)
                || (node.v[0] == node.v[2] && node.v[1] == 0)
                || (node.v[0] == 0 && node.v[1] == node.v[2]))
            return true;
        return false;
    }
    //搜索
    public void bfs()
    {
        while (list.size() != 0)//当容器中还有元素
        {
            Node node = list.poll();//先取出来开始判断
            for (int i = 0; i < 3; i++) 
            {
            	//如果还有水就继续操作
                if (node.v[i] != 0)
                {
                    for (int j = 0; j < 3; j++) 
                    {
                    	//不能自己给自己倒，如果容器已满
                        if (i == j || node.max[j] == node.v[j]) 
                            continue;
                        else
                        {
                            Node tmp = node.clone();
                            tmp.count++;
                            if (tmp.v[i] >= (tmp.max[j] - tmp.v[j])) 
                            {
                                tmp.v[i] -= (tmp.max[j] - tmp.v[j]);
                                tmp.v[j] = tmp.max[j];
                            } 
                            else 
                            {
                                tmp.v[j] += tmp.v[i];
                                tmp.v[i] = 0;
                            }
                            int hashV = hashing(tmp);
                            if (!hash[hashV]) 
                            {
                                if (check(tmp)) 
                                {
                                    System.out.println(tmp.count);
                                    return;
                                }
                                hash[hashV] = true;
                                list.addLast(tmp);
                            }

                        }
                    }
                }
            }
        }
        System.out.println("NO");
        
    }
}