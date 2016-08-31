package com.stormma.day3;
import java.util.Scanner;
public class MainA
{

	/**
	 * @param args
	 */
	public static boolean flag = false;
	public static int n, m;
	public static int x1, x2, y1, y2;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//(x1,y1)��(x2,y2)
		while (scan.hasNext())
		{
			n = scan.nextInt();
			m = scan.nextInt();
			int [][] map = new int [1005][1005];
			if (n == 0 && m == 0)
			{
				System.exit(0);
			}
			/**
			 * ��ʼ����ͼ
			 */
			for (int i = 1; i <= n; i++)
			{
				for (int j = 1; j <= m; j++)
				{
					map[i][j] = scan.nextInt();
				}
			}
			//�������
			int time = scan.nextInt();
			//��ʼ����
			while ((time--) > 0)
			{
				flag = false;
				int [][] vis = new int [1005][1005];
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				//�����ͬһ������Ļ�
				if (x1 == x2 && y1 == y2 || map[x1][y1] == 0)
				{
					System.out.println("NO");
				}
				//��ͬ�����ֵ��ͬ�����Ҷ���Ϊ0
				else if ((map[x1][y1] == map[x2][y2]) && map[x1][y1] != 0)
				{
					//����
					dfs(map,vis,x1-1,y1,1,0);  
					//��
	                dfs(map,vis,x1+1,y1,2,0);  
	                dfs(map,vis,x1,y1-1,3,0);  
	                dfs(map,vis,x1,y1+1,4,0); 
	                if (flag)
	                {
	                	System.out.println("YES");
	                }
	                else
	                {
	                	System.out.println("NO");
	                }
				}
				else
					System.out.println("NO");
			}
		}
	}
	/**
	 * @param x��������
	 * @param y��������
	 * @param dir������(1:up,2:down,3:left,4right)
	 * @param count���������
	 * @return
	 */
	public static void dfs (int [][] map, int [][] vis, int x, int y, int dir, int count)
	{
		//����ҵ��˵Ļ�
		if (flag)
			return;
		//ת���������2��ֱ�Ӷ���
		if (count > 2)
			return;
		//���Խ��Ļ�������
		if(x<=0 || y<=0 || x>n || y>m) 
		    return ; 
		if(x == x2 && y == y2)//�ҵ���  
	    {  
	        flag = true;  
	        return ;  
	    } 
		if(count == 2)//��֦��ת������ʱ����Ŀ�ĵ�����������ڵĳ����Ƿ���һ�������ϣ����ڵĻ��ͷ���  
	    {  
	        if(!(dir == 1 && x > x2 && y == y2 || dir == 2 && x<x2 && y == y2 || dir == 3 && y>y2 && x==x2 || dir == 4 && y < y2 && x == x2))  
	        return;  
	    } 
		if(map[x][y]!=0) 
			return;  
	    if(vis[x][y] != 0) 
	    	return ;  
	    vis[x][y] = 1;  
	    if(dir == 1)//��  
	    {  
	        dfs(map,vis,x-1,y,1,count);  
	        dfs(map,vis,x+1,y,2,count+1);  
	        dfs(map,vis,x,y-1,3,count+1);  
	        dfs(map,vis,x,y+1,4,count+1);  
	    }  
	    else if(dir == 2)//��  
	    {  
	        dfs(map,vis,x-1,y,1,count+1);  
	        dfs(map,vis,x+1,y,2,count);  
	        dfs(map,vis,x,y-1,3,count+1);  
	        dfs(map,vis,x,y+1,4,count+1);  
	    }  
	    else if(dir == 3)//��  
	    {  
	        dfs(map,vis,x-1,y,1,count+1);  
	        dfs(map,vis,x+1,y,2,count+1);  
	        dfs(map,vis,x,y-1,3,count);  
	        dfs(map,vis,x,y+1,4,count+1);  
	    }  
	    else if(dir == 4)//��  
	    {  
	        dfs(map,vis,x-1,y,1,count+1);  
	        dfs(map,vis,x+1,y,2,count+1);  
	        dfs(map,vis,x,y-1,3,count+1);  
	        dfs(map,vis,x,y+1,4,count);  
	    }  
	    vis[x][y] = 0;  
	}
}
