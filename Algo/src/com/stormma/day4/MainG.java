package com.stormma.day4;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class MainG 
{
    class Node 
    {
        int[] max = new int[3];// S,M,N
        int[] v = new int[3];//������������������״̬ʱ��ƿ�Ӻ��������ӵ�״̬
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
            list.clear();//���list
            Arrays.fill(hash, false);//��ʼ��hash����Ϊfalse
            Node head = new Node();//����һ��Node��Ķ���
            head.max[0] = input.nextInt();//S
            head.max[1] = input.nextInt();//M
            head.max[2] = input.nextInt();//N
            head.v[0] = head.max[0];//��ʼ��ƿ���������
            head.count = 0;//��ʼ����ˮ�Ĵ���
            input.nextLine();
            if (hashing(head) == 0)
                break;//����0 0 0ֹͣ������
            list.addLast(head);//�������Ԫ��
            //������������֦
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
            	bfs();//��ʼ����
        }
    }
    //�ж��Ƿ�ˮ�����Ƿ��Ѿ�ƽ����
    public boolean check(Node node)
    {
        if ((node.v[0] == node.v[1] && node.v[2] == 0)
                || (node.v[0] == node.v[2] && node.v[1] == 0)
                || (node.v[0] == 0 && node.v[1] == node.v[2]))
            return true;
        return false;
    }
    //����
    public void bfs()
    {
        while (list.size() != 0)//�������л���Ԫ��
        {
            Node node = list.poll();//��ȡ������ʼ�ж�
            for (int i = 0; i < 3; i++) 
            {
            	//�������ˮ�ͼ�������
                if (node.v[i] != 0)
                {
                    for (int j = 0; j < 3; j++) 
                    {
                    	//�����Լ����Լ����������������
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